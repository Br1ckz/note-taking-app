/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mvc.view;

import mvc.controller.NavCntl;

/**
 *
 * @author bryce
 */
public class NavView extends javax.swing.JFrame {

	private NavCntl navCntl;
	/**
	 * Creates new form NavView
	 */
	public NavView(NavCntl navCntl) {
		this.navCntl = navCntl;
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                btnBack = new javax.swing.JButton();
                btnAlert = new javax.swing.JButton();
                btnNote = new javax.swing.JButton();
                labelTitle = new javax.swing.JLabel();
                btnNoteList = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                btnBack.setText("Back");
                btnBack.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnBackActionPerformed(evt);
                        }
                });

                btnAlert.setText("Alert");
                btnAlert.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnAlertActionPerformed(evt);
                        }
                });

                btnNote.setText("Note");
                btnNote.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnNoteActionPerformed(evt);
                        }
                });

                labelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                labelTitle.setText("Navigation");

                btnNoteList.setText("Note List");
                btnNoteList.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnNoteListActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(labelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(btnNoteList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnAlert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(165, 165, 165))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(labelTitle)
                                .addGap(35, 35, 35)
                                .addComponent(btnNote)
                                .addGap(35, 35, 35)
                                .addComponent(btnNoteList)
                                .addGap(35, 35, 35)
                                .addComponent(btnAlert)
                                .addGap(35, 35, 35)
                                .addComponent(btnBack)
                                .addGap(20, 20, 20))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
                navCntl.giveLoginControl();
        }//GEN-LAST:event_btnBackActionPerformed

        private void btnNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoteActionPerformed
                navCntl.giveNoteControl();
        }//GEN-LAST:event_btnNoteActionPerformed

        private void btnAlertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlertActionPerformed
                navCntl.giveAlertControl();
        }//GEN-LAST:event_btnAlertActionPerformed

        private void btnNoteListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoteListActionPerformed
                navCntl.giveNoteListControl();
        }//GEN-LAST:event_btnNoteListActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnAlert;
        private javax.swing.JButton btnBack;
        private javax.swing.JButton btnNote;
        private javax.swing.JButton btnNoteList;
        private javax.swing.JLabel labelTitle;
        // End of variables declaration//GEN-END:variables
}
