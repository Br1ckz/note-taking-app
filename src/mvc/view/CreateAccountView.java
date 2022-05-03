/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mvc.view;

import mvc.controller.LoginCntl;

/**
 *
 * @author bryce
 */
public class CreateAccountView extends javax.swing.JFrame {

	private LoginCntl loginCntl;

	/**
	 * Creates new form CreateAccountUI
	 */
	public CreateAccountView(LoginCntl loginCntl) {
		this.loginCntl = loginCntl;
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

                titleLabel = new javax.swing.JLabel();
                usernameLabel = new javax.swing.JLabel();
                passwordLabel = new javax.swing.JLabel();
                usernameField = new javax.swing.JTextField();
                passwordField = new javax.swing.JTextField();
                resetButton = new javax.swing.JButton();
                cancelButton = new javax.swing.JButton();
                submitButton = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                titleLabel.setText("Create Account");

                usernameLabel.setText("Username:");

                passwordLabel.setText("Password:");

                usernameField.setText("Please Enter a Username");
                usernameField.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                usernameFieldMouseClicked(evt);
                        }
                });

                passwordField.setText("Please Enter a Password");
                passwordField.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                passwordFieldMouseClicked(evt);
                        }
                });

                resetButton.setText("Reset");
                resetButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                resetButtonActionPerformed(evt);
                        }
                });

                cancelButton.setText("Cancel");
                cancelButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                cancelButtonActionPerformed(evt);
                        }
                });

                submitButton.setText("Submit");
                submitButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                submitButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(passwordLabel)
                                                        .addComponent(usernameLabel))
                                                .addGap(98, 98, 98)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(usernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                                        .addComponent(passwordField)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(resetButton)
                                                .addGap(48, 48, 48)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(titleLabel)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(cancelButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(submitButton)))))
                                .addContainerGap(60, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleLabel)
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(usernameLabel)
                                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLabel)
                                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(resetButton)
                                        .addComponent(cancelButton)
                                        .addComponent(submitButton))
                                .addGap(37, 37, 37))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
		loginCntl.showLoginUI(true);
		loginCntl.showCreateAccountUI(false);
        }//GEN-LAST:event_cancelButtonActionPerformed

        private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
		usernameField.setText("");
		passwordField.setText("");
        }//GEN-LAST:event_resetButtonActionPerformed

        private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
                loginCntl.createAccount(usernameField.getText(), passwordField.getText());
		loginCntl.showLoginUI(true);
		loginCntl.showCreateAccountUI(false);
        }//GEN-LAST:event_submitButtonActionPerformed

    private void usernameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameFieldMouseClicked
                usernameField.setText("");
    }//GEN-LAST:event_usernameFieldMouseClicked

    private void passwordFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordFieldMouseClicked
                passwordField.setText("");
    }//GEN-LAST:event_passwordFieldMouseClicked

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton cancelButton;
        private javax.swing.JTextField passwordField;
        private javax.swing.JLabel passwordLabel;
        private javax.swing.JButton resetButton;
        private javax.swing.JButton submitButton;
        private javax.swing.JLabel titleLabel;
        private javax.swing.JTextField usernameField;
        private javax.swing.JLabel usernameLabel;
        // End of variables declaration//GEN-END:variables
}
