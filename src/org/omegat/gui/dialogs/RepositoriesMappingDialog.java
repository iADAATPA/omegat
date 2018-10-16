/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool
          with fuzzy matching, translation memory, keyword search,
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2014 Alex Buloichik
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

package org.omegat.gui.dialogs;

import org.omegat.util.OStrings;

/**
 * UI for repositories mapping. Should be modified in the Netbeans only.
 *
 * @author Alex Buloichik (alex73mail@gmail.com)
 */
@SuppressWarnings("serial")
public class RepositoriesMappingDialog extends javax.swing.JDialog {

    /**
     * Creates new form RepositoriesMappingDialog
     */
    public RepositoriesMappingDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRepositories = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnRepoAdd = new javax.swing.JButton();
        btnRepoRemove = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMapping = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        btnMappingRemove = new javax.swing.JButton();
        btnMappingAdd = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(OStrings.getString("RMD_TITLE")); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 500));

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 10, 0));
        jPanel3.setLayout(new java.awt.BorderLayout());

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, OStrings.getString("RMD_TABLE_REPOSITORIES")); // NOI18N
        jPanel3.add(jLabel1, java.awt.BorderLayout.NORTH);

        tableRepositories.setAutoCreateRowSorter(true);
        tableRepositories.setFillsViewportHeight(true);
        tableRepositories.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tableRepositories);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(btnRepoAdd, OStrings.getString("RMD_BTN_ADD")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(btnRepoAdd, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(btnRepoRemove, OStrings.getString("RMD_BTN_REMOVE")); // NOI18N
        btnRepoRemove.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(btnRepoRemove, gridBagConstraints);

        jPanel5.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel3);

        jPanel4.setLayout(new java.awt.BorderLayout());

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, OStrings.getString("RMD_TABLE_MAPPING")); // NOI18N
        jPanel4.add(jLabel2, java.awt.BorderLayout.NORTH);

        tableMapping.setAutoCreateRowSorter(true);
        tableMapping.setFillsViewportHeight(true);
        tableMapping.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tableMapping);

        jPanel4.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel8.setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(btnMappingRemove, OStrings.getString("RMD_BTN_REMOVE")); // NOI18N
        btnMappingRemove.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel8.add(btnMappingRemove, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(btnMappingAdd, OStrings.getString("RMD_BTN_ADD")); // NOI18N
        btnMappingAdd.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel8.add(btnMappingAdd, gridBagConstraints);

        jPanel7.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel7, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel4);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 10, 10));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        org.openide.awt.Mnemonics.setLocalizedText(okButton, OStrings.getString("BUTTON_OK")); // NOI18N
        jPanel1.add(okButton);

        org.openide.awt.Mnemonics.setLocalizedText(cancelButton, OStrings.getString("BUTTON_CANCEL")); // NOI18N
        jPanel1.add(cancelButton);

        jPanel9.add(jPanel1, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel9, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnMappingAdd;
    public javax.swing.JButton btnMappingRemove;
    public javax.swing.JButton btnRepoAdd;
    public javax.swing.JButton btnRepoRemove;
    public javax.swing.JButton cancelButton;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    public javax.swing.JPanel jPanel6;
    public javax.swing.JPanel jPanel7;
    public javax.swing.JPanel jPanel8;
    public javax.swing.JPanel jPanel9;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JButton okButton;
    public javax.swing.JTable tableMapping;
    public javax.swing.JTable tableRepositories;
    // End of variables declaration//GEN-END:variables
}
