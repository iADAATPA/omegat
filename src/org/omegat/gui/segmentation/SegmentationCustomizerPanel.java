/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool
          with fuzzy matching, translation memory, keyword search,
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2000-2006 Keith Godfrey and Maxym Mykhalchuk
               2016 Aaron Madlon-Kay
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

package org.omegat.gui.segmentation;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.omegat.util.OStrings;

/**
 * Main UI for for setting up sentence segmenting. The UI is created as
 * SRX-like as possible, but the segmentation is not (yet) SRX-compliant.
 *
 * @author Maxym Mykhalchuk
 * @author Aaron Madlon-Kay
 */
@SuppressWarnings("serial")
public class SegmentationCustomizerPanel extends JPanel {

    public SegmentationCustomizerPanel() {
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

        mapPanel = new javax.swing.JPanel();
        hintTextArea = new javax.swing.JTextArea();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));
        projectSpecificCB = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        mapScrollPane = new javax.swing.JScrollPane();
        mapTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        mapInsertButton = new javax.swing.JButton();
        mapDeleteButton = new javax.swing.JButton();
        mapUpButton = new javax.swing.JButton();
        mapDownButton = new javax.swing.JButton();
        mapErrorsLabel = new javax.swing.JLabel();
        rulePanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        ruleScrollPane = new javax.swing.JScrollPane();
        ruleTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        ruleInsertButton = new javax.swing.JButton();
        ruleDeleteButton = new javax.swing.JButton();
        ruleFirstButton = new javax.swing.JButton();
        ruleUpButton = new javax.swing.JButton();
        ruleDownButton = new javax.swing.JButton();
        ruleBottomButton = new javax.swing.JButton();
        ruleErrorsLabel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        mapPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(OStrings.getString("GUI_SEGMENTATION_RULESETS"))); // NOI18N
        mapPanel.setAlignmentX(0.0F);
        mapPanel.setAlignmentY(0.0F);
        mapPanel.setLayout(new javax.swing.BoxLayout(mapPanel, javax.swing.BoxLayout.PAGE_AXIS));

        hintTextArea.setEditable(false);
        hintTextArea.setFont(new JLabel().getFont());
        hintTextArea.setLineWrap(true);
        hintTextArea.setText(OStrings.getString("GUI_SEGMENTATION_NOTE")); // NOI18N
        hintTextArea.setWrapStyleWord(true);
        hintTextArea.setAlignmentX(0.0F);
        hintTextArea.setAlignmentY(0.0F);
        hintTextArea.setDragEnabled(false);
        hintTextArea.setFocusable(false);
        hintTextArea.setOpaque(false);
        mapPanel.add(hintTextArea);
        mapPanel.add(filler1);

        org.openide.awt.Mnemonics.setLocalizedText(projectSpecificCB, OStrings.getString("PP_CHECKBOX_PROJECT_SPECIFIC_SEGMENTATION_RULES")); // NOI18N
        projectSpecificCB.setAlignmentY(0.0F);
        mapPanel.add(projectSpecificCB);

        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setLayout(new java.awt.BorderLayout());

        mapScrollPane.setViewportView(mapTable);

        jPanel1.add(mapScrollPane, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(mapInsertButton, OStrings.getString("BUTTON_ADD_NODOTS")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel2.add(mapInsertButton, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(mapDeleteButton, OStrings.getString("BUTTON_REMOVE")); // NOI18N
        mapDeleteButton.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel2.add(mapDeleteButton, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(mapUpButton, OStrings.getString("GUI_SEGMENTATION_BUTTON_UP_1")); // NOI18N
        mapUpButton.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel2.add(mapUpButton, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(mapDownButton, OStrings.getString("GUI_SEGMENTATION_BUTTON_DOWN_1")); // NOI18N
        mapDownButton.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel2.add(mapDownButton, gridBagConstraints);

        jPanel3.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel1.add(jPanel3, java.awt.BorderLayout.EAST);

        mapPanel.add(jPanel1);

        mapErrorsLabel.setForeground(new java.awt.Color(255, 0, 0));
        mapErrorsLabel.setAlignmentY(0.0F);
        mapPanel.add(mapErrorsLabel);

        add(mapPanel);

        rulePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(OStrings.getString("GUI_SEGMENTATION_RULEORDER"))); // NOI18N
        rulePanel.setAlignmentX(0.0F);
        rulePanel.setAlignmentY(0.0F);
        rulePanel.setLayout(new javax.swing.BoxLayout(rulePanel, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel4.setLayout(new java.awt.BorderLayout());

        ruleScrollPane.setViewportView(ruleTable);

        jPanel4.add(ruleScrollPane, java.awt.BorderLayout.CENTER);

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(ruleInsertButton, OStrings.getString("BUTTON_ADD_NODOTS2")); // NOI18N
        ruleInsertButton.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel6.add(ruleInsertButton, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(ruleDeleteButton, OStrings.getString("BUTTON_REMOVE_2")); // NOI18N
        ruleDeleteButton.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel6.add(ruleDeleteButton, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(ruleFirstButton, OStrings.getString("GUI_SEGMENTATION_BUTTON_TOP")); // NOI18N
        ruleFirstButton.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel6.add(ruleFirstButton, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(ruleUpButton, OStrings.getString("GUI_SEGMENTATION_BUTTON_UP_2")); // NOI18N
        ruleUpButton.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel6.add(ruleUpButton, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(ruleDownButton, OStrings.getString("GUI_SEGMENTATION_BUTTON_DOWN_2")); // NOI18N
        ruleDownButton.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel6.add(ruleDownButton, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(ruleBottomButton, OStrings.getString("GUI_SEGMENTATION_BUTTON_BOTTOM")); // NOI18N
        ruleBottomButton.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel6.add(ruleBottomButton, gridBagConstraints);

        jPanel5.add(jPanel6, java.awt.BorderLayout.NORTH);

        jPanel4.add(jPanel5, java.awt.BorderLayout.EAST);

        rulePanel.add(jPanel4);

        ruleErrorsLabel.setForeground(new java.awt.Color(255, 0, 0));
        rulePanel.add(ruleErrorsLabel);

        add(rulePanel);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    javax.swing.JTextArea hintTextArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    javax.swing.JButton mapDeleteButton;
    javax.swing.JButton mapDownButton;
    javax.swing.JLabel mapErrorsLabel;
    javax.swing.JButton mapInsertButton;
    javax.swing.JPanel mapPanel;
    javax.swing.JScrollPane mapScrollPane;
    javax.swing.JTable mapTable;
    javax.swing.JButton mapUpButton;
    javax.swing.JCheckBox projectSpecificCB;
    javax.swing.JButton ruleBottomButton;
    javax.swing.JButton ruleDeleteButton;
    javax.swing.JButton ruleDownButton;
    javax.swing.JLabel ruleErrorsLabel;
    javax.swing.JButton ruleFirstButton;
    javax.swing.JButton ruleInsertButton;
    javax.swing.JPanel rulePanel;
    javax.swing.JScrollPane ruleScrollPane;
    javax.swing.JTable ruleTable;
    javax.swing.JButton ruleUpButton;
    // End of variables declaration//GEN-END:variables
}
