/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool
          with fuzzy matching, translation memory, keyword search,
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2017 Aaron Madlon-Kay
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

package org.omegat.core.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.omegat.core.Core;
import org.omegat.core.TestCore;
import org.omegat.core.segmentation.SRX;
import org.omegat.core.segmentation.Segmenter;
import org.omegat.filters2.master.FilterMaster;
import org.omegat.filters2.mozlang.MozillaLangFilter;
import org.omegat.filters2.po.PoFilter;
import org.omegat.util.Language;

public class ExternalTMFactoryTest extends TestCore {

    @Before
    public final void setUp() {
        Core.setSegmenter(new Segmenter(SRX.getDefault()));
        FilterMaster.setFilterClasses(Arrays.asList(PoFilter.class, MozillaLangFilter.class));
        Core.setFilterMaster(new FilterMaster(FilterMaster.createDefaultFiltersConfig()));
        ProjectProperties props = new ProjectProperties() {
            public Language getSourceLanguage() {
                return new Language("en");
            }

            public Language getTargetLanguage() {
                return new Language("pl");
            }

            @Override
            public boolean isSentenceSegmentingEnabled() {
                return true;
            }
        };
        Core.setProject(new NotLoadedProject() {
            @Override
            public ProjectProperties getProjectProperties() {
                return props;
            }
        });
    }

    @Test
    public void testLoadTMX() throws Exception {
        File tmxFile = new File("test/data/tmx/resegmenting.tmx");

        assertTrue(ExternalTMFactory.isSupported(tmxFile));

        ExternalTMX tmx = ExternalTMFactory.load(tmxFile);

        assertEquals(2, tmx.getEntries().size());
        assertEquals("This is test.", tmx.getEntries().get(0).source);
        assertEquals("Ceci est un test.", tmx.getEntries().get(0).translation);
        assertEquals("Just a test.", tmx.getEntries().get(1).source);
        assertEquals("Juste un test.", tmx.getEntries().get(1).translation);
    }

    @Test
    public void testLoadPO() throws Exception {
        File tmxFile = new File("test/data/filters/po/file-POFilter-be-utf8.po");

        assertTrue(ExternalTMFactory.isSupported(tmxFile));

        ExternalTMX tmx = ExternalTMFactory.load(tmxFile);

        assertEquals(1013, tmx.getEntries().size());
        assertEquals("Choose syntax highlighting", tmx.getEntries().get(0).source);
        assertEquals(
                "\u0412\u044B\u043B\u0443\u0447\u044D\u043D\u044C\u043D\u0435 "
                        + "&\u043A\u043E\u043B\u0435\u0440\u0430\u043C "
                        + "\u0441\u044B\u043D\u0442\u0430\u043A\u0441\u044B\u0441\u0443",
                tmx.getEntries().get(0).translation);
        assertEquals("< Auto >", tmx.getEntries().get(1).source);
        assertEquals("\u041F\u0440\u0430 \u043F\u0440\u0430\u0433\u0440\u0430\u043C\u0443",
                tmx.getEntries().get(1).translation);
    }

    @Test
    public void testLoadMozillaLang() throws Exception {
        File tmxFile = new File("test/data/filters/MozillaLang/file-MozillaLangFilter-de.lang");

        assertTrue(ExternalTMFactory.isSupported(tmxFile));

        ExternalTMX tmx = ExternalTMFactory.load(tmxFile);

        assertEquals(33, tmx.getEntries().size());
        assertEquals("Download %s for Android in your language", tmx.getEntries().get(0).source);
        assertEquals("Laden Sie %s f\u00FCr Android in Ihrer Sprache herunter",
                tmx.getEntries().get(0).translation);
        assertEquals("Download %s in your language", tmx.getEntries().get(1).source);
        assertEquals("Laden Sie %s in Ihrer Sprache herunter",
                tmx.getEntries().get(1).translation);
    }
}
