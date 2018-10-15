/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool
          with fuzzy matching, translation memory, keyword search,
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2014, 2015 Aaron Madlon-Kay
               Home page: http://www.omegat.org/
               Support center: http://groups.yahoo.com/group/OmegaT/

 This file is part of OmegaT.

 OmegaT is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 OmegaT is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **************************************************************************/

package org.omegat.util.gui;

import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

import org.omegat.core.Core;
import org.omegat.core.CoreEvents;
import org.omegat.core.events.IApplicationEventListener;
import org.omegat.core.events.IProjectEventListener;
import org.omegat.gui.main.ProjectUICommands;
import org.omegat.util.Log;
import org.omegat.util.OConsts;
import org.omegat.util.Preferences;
import org.omegat.util.StaticUtils;

/**
 * This class uses reflection to set Mac OS X-specific integration hooks.
 *
 * @author Aaron Madlon-Kay
 */
public final class OSXIntegration {

    private OSXIntegration() {
    }

    public static final Image APP_ICON_MAC = ResourcesUtil.getBundledImage("OmegaT_mac.png");

    private static volatile Class<?> appClass;
    private static volatile Object app;

    private static boolean guiLoaded = false;
    private static final List<Runnable> DO_AFTER_LOAD = new ArrayList<>();

    public static void init() {
        try {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", "OmegaT");

            // Set dock icon
            Method setDockIconImage = getAppClass().getDeclaredMethod("setDockIconImage", Image.class);
            setDockIconImage.invoke(getApp(), APP_ICON_MAC);

            // Set quit strategy:
            //   app.setQuitStrategy(com.apple.eawt.QuitStrategy.CLOSE_ALL_WINDOWS);
            Class<?> strategyClass = Class.forName("com.apple.eawt.QuitStrategy");
            Method setQuitStrategy = getAppClass().getDeclaredMethod("setQuitStrategy", strategyClass);
            setQuitStrategy.invoke(getApp(), strategyClass.getField("CLOSE_ALL_WINDOWS").get(null));

            // Prevent sudden termination:
            //   app.disableSuddenTermination();
            Method disableTerm = getAppClass().getDeclaredMethod("disableSuddenTermination");
            disableTerm.invoke(getApp());

            // Register to find out when app finishes loading so we can
            // 1. Set up full-screen support, and...
            CoreEvents.registerApplicationEventListener(APP_LISTENER);
            // 2. The open file handler can defer opening a project until the GUI is ready.
            setOpenFilesHandler(OPEN_FILES_HANDLER);

            // Register listener to update the main window's proxy icon and modified indicators.
            CoreEvents.registerProjectChangeListener(PROJECT_LISTENER);
        } catch (Exception ex) {
            Log.log(ex);
        }
    }

    private static final IApplicationEventListener APP_LISTENER = new IApplicationEventListener() {
        @Override
        public void onApplicationStartup() {
            guiLoaded = true;
            synchronized (DO_AFTER_LOAD) {
                for (Runnable r : DO_AFTER_LOAD) {
                    r.run();
                }
                DO_AFTER_LOAD.clear();
            }
            Window window = Core.getMainWindow().getApplicationFrame();
            enableFullScreen(window);
        }
        @Override
        public void onApplicationShutdown() {
            guiLoaded = false;
        }
    };

    private static final IOpenFilesHandler OPEN_FILES_HANDLER = new IOpenFilesHandler() {
        @Override
        public void openFiles(List<?> files) {
            if (files.isEmpty()) {
                return;
            }
            File firstFile = (File) files.get(0); // Ignore others
            if (firstFile.getName().equals(OConsts.FILE_PROJECT)) {
                firstFile = firstFile.getParentFile();
            }
            if (!StaticUtils.isProjectDir(firstFile)) {
                return;
            }
            final File projDir = firstFile;
            Runnable openProject = new Runnable() {
                @Override
                public void run() {
                    ProjectUICommands.projectOpen(projDir, true);
                }
            };
            if (guiLoaded) {
                SwingUtilities.invokeLater(openProject);
            } else {
                synchronized (DO_AFTER_LOAD) {
                    DO_AFTER_LOAD.add(openProject);
                }
            }
        }
    };

    private static final IProjectEventListener PROJECT_LISTENER = eventType -> {
        JRootPane rootPane = Core.getMainWindow().getApplicationFrame().getRootPane();
        switch (eventType) {
        case CREATE:
        case LOAD:
            String projDir = Core.getProject().getProjectProperties().getProjectRoot();
            setProxyIcon(rootPane, new File(projDir));
            break;
        case CLOSE:
            setProxyIcon(rootPane, null);
            break;
        case MODIFIED:
            setModifiedIndicator(rootPane, true);
            break;
        case SAVE:
            setModifiedIndicator(rootPane, false);
            break;
        default:
            // Nothing
        }
    };

    public static void setAboutHandler(final ActionListener al) {
        try {
            // Handler must implement com.apple.eawt.AboutHandler interface.
            Class<?> aboutHandlerClass = Class.forName("com.apple.eawt.AboutHandler");
            InvocationHandler ih = (proxy, method, args) -> {
                if (method.getName().equals("handleAbout")) {
                    // Respond to handleAbout(com.apple.eawt.AppEvent.AboutEvent)
                    al.actionPerformed(null);
                }
                return null;
            };
            Object handler = Proxy.newProxyInstance(OSXIntegration.class.getClassLoader(),
                    new Class<?>[] { aboutHandlerClass }, ih);
            // Set handler:
            //   app.setAboutHandler(handler);
            Method setAboutHandler = getAppClass().getDeclaredMethod("setAboutHandler", aboutHandlerClass);
            setAboutHandler.invoke(getApp(), handler);
        } catch (Exception ex) {
            Log.log(ex);
        }
    }

    public static void setQuitHandler(final ActionListener al) {
        try {
            // Handler must implement com.apple.eawt.QuitHandler interface.
            Class<?> quitHandlerClass = Class.forName("com.apple.eawt.QuitHandler");
            InvocationHandler ih = (proxy, method, args) -> {
                if (method.getName().equals("handleQuitRequestWith")) {
                    Class<?> quitResponseClass = Class.forName("com.apple.eawt.QuitResponse");
                    if (args != null && args.length > 1 && quitResponseClass.isInstance(args[1])
                            && Preferences.isPreference(Preferences.ALWAYS_CONFIRM_QUIT)) {
                        // Respond to handleQuitRequestWith(com.apple.eawt.AppEvent.QuitEvent,
                        //     com.apple.eawt.QuitResponse)
                        // Cancel the quit because OmegaT will prompt:
                        //     arg1.cancelQuit();
                        Method cancelQuit = quitResponseClass.getDeclaredMethod("cancelQuit");
                        cancelQuit.invoke(args[1]);
                    }
                    al.actionPerformed(null);
                }
                return null;
            };
            Object handler = Proxy.newProxyInstance(OSXIntegration.class.getClassLoader(),
                    new Class<?>[] { quitHandlerClass }, ih);
            // Set handler:
            //   app.setAboutHandler(handler);
            Method setQuitHandler = getAppClass().getDeclaredMethod("setQuitHandler", quitHandlerClass);
            setQuitHandler.invoke(getApp(), handler);
        } catch (Exception ex) {
            Log.log(ex);
        }
    }

    public static void setOpenFilesHandler(final IOpenFilesHandler ofh) {
        try {
            // Handler must implement com.apple.eawt.OpenFilesHandler interface.
            Class<?> openFilesHandlerClass = Class.forName("com.apple.eawt.OpenFilesHandler");
            InvocationHandler ih = (proxy, method, args) -> {
                try {
                    if (method.getName().equals("openFiles")) {
                        Class<?> filesEventClass = Class.forName("com.apple.eawt.AppEvent$FilesEvent");
                        if (args != null && args.length > 0 && filesEventClass.isInstance(args[0])) {
                            Object filesEvent = args[0];
                            // Respond to openFiles(com.apple.eawt.AppEvent.OpenFilesEvent)
                            // Get provided list of files:
                            //    arg0.getFiles()
                            Method getFilesMethod = filesEventClass.getDeclaredMethod("getFiles");
                            Object filesList = getFilesMethod.invoke(filesEvent);
                            ofh.openFiles((List<?>) filesList);
                        }
                    }
                } catch (Throwable t) {
                    Log.log(t);
                }
                return null;
            };
            Object handler = Proxy.newProxyInstance(OSXIntegration.class.getClassLoader(),
                    new Class<?>[] { openFilesHandlerClass }, ih);
            // Set handler:
            //   app.setOpenFileHandler(handler);
            Method setOpenFileHandler = getAppClass().getDeclaredMethod("setOpenFileHandler", openFilesHandlerClass);
            setOpenFileHandler.invoke(getApp(), handler);
        } catch (Exception ex) {
            Log.log(ex);
        }
    }

    public static void setPreferencesHandler(ActionListener listener) {
        try {
            // Handler must implement com.apple.eawt.PreferencesHandler interface.
            Class<?> preferencesHandlerClass = Class.forName("com.apple.eawt.PreferencesHandler");
            InvocationHandler ih = (proxy, method, args) -> {
                if (method.getName().equals("handlePreferences")) {
                    // Respond to
                    // handlePreferences(com.apple.eawt.AppEvent.PreferencesHandler)
                    listener.actionPerformed(null);
                }
                return null;
            };
            Object handler = Proxy.newProxyInstance(OSXIntegration.class.getClassLoader(),
                    new Class<?>[] { preferencesHandlerClass }, ih);
            // Set handler:
            // app.setPreferencesHandler(handler);
            Method setAboutHandler = getAppClass().getDeclaredMethod("setPreferencesHandler", preferencesHandlerClass);
            setAboutHandler.invoke(getApp(), handler);
        } catch (Exception ex) {
            Log.log(ex);
        }
    }

    public static void enableFullScreen(Window window) {
        try {
            // Enable full-screen mode:
            //   FullScreenUtilities.setWindowCanFullScreen(java.awt.Window, boolean)
            Class<?> utilClass = Class.forName("com.apple.eawt.FullScreenUtilities");
            Method setWindowCanFullScreen = utilClass.getMethod("setWindowCanFullScreen",
                    new Class<?>[] { java.awt.Window.class, Boolean.TYPE });
            setWindowCanFullScreen.invoke(utilClass, window, true);
        } catch (Exception ex) {
            Log.log(ex);
        }
    }

    public static void setProxyIcon(JRootPane rootPane, File file) {
        rootPane.putClientProperty("Window.documentFile", file);
    }

    public static void setModifiedIndicator(JRootPane rootPane, boolean isModified) {
        rootPane.putClientProperty("Window.documentModified", isModified);
    }

    public interface IOpenFilesHandler {
        void openFiles(List<?> files);
    }

    private static Class<?> getAppClass() throws Exception {
        if (appClass == null) {
            appClass = Class.forName("com.apple.eawt.Application");
        }
        return appClass;
    }

    private static Object getApp() throws Exception {
        if (app == null) {
            Method getApp = getAppClass().getDeclaredMethod("getApplication");
            app = getApp.invoke(null);
        }
        return app;
    }
}
