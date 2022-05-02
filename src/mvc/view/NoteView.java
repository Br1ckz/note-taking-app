/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.util.Date;
//import java.sql.date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import mvc.controller.NoteCntl;

/**
 *
 * @author sabrinamatteoli
 */
public class NoteView extends javax.swing.JFrame {

	private NoteCntl noteCntl;
	/**
	 * Creates new form NoteView
	 */
	//pubic variable
	public String NoteInformation;
	public String DueDate;
	public String DueTime;

	public NoteView(NoteCntl noteCntl) {
		this.noteCntl = noteCntl;
		initComponents();
	}

	//get and set for NoteInformation
	public JTextField getNoteInformation() {
		return NewNoteField;
	}//getNoteInforamtion

	public void setNoteInformation() {
		NoteInformation = NewNoteField.getText();
	}//setNoteInformation

	//get and set for DueDate
	public JTextField getDueDate() {
		return NoteDate;
	}//getNoteInforamtion

	public void setDueDate() {
		DueDate = NoteDate.getText();
	}//setNoteInformation

	//get and set for DueTime
	public JTextField getDueTime() {
		return NoteTime;
	}//getNoteInforamtion

	public void setDueTime() {
		DueTime = NoteTime.getText();
	}//setNoteInformation

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                CreateNotePanel = new javax.swing.JPanel();
                CreateNewNoteLabel = new javax.swing.JLabel();
                DirectionsLabel = new javax.swing.JLabel();
                NewNoteField = new javax.swing.JTextField();
                SubmitButton = new javax.swing.JButton();
                CancelButton = new javax.swing.JButton();
                NoteDate = new javax.swing.JFormattedTextField();
                NoteTime = new javax.swing.JFormattedTextField();
                btnBack = new javax.swing.JButton();
                fieldNoteTitle = new javax.swing.JTextField();
                labelNoteTitle = new javax.swing.JLabel();
                labelAlertDate = new javax.swing.JLabel();
                labelAlertDateFormat = new javax.swing.JLabel();
                labelAlertTime = new javax.swing.JLabel();
                jLabel1 = new javax.swing.JLabel();
                labelAlertTimeFormat = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                CreateNewNoteLabel.setText("Create New Note");

                DirectionsLabel.setText("Enter your new note in the field below:");

                SubmitButton.setText("Submit");
                SubmitButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                SubmitButtonActionPerformed(evt);
                        }
                });

                CancelButton.setText("Cancel");

                btnBack.setText("Back");
                btnBack.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnBackActionPerformed(evt);
                        }
                });

                labelNoteTitle.setText("Note Title:");

                labelAlertDate.setText("Alert Date");

                labelAlertDateFormat.setText("YYYY/MM/DD");

                labelAlertTime.setText("Alert Time");

                jLabel1.setText("jLabel1");

                labelAlertTimeFormat.setText("HH:mm:ss");

                javax.swing.GroupLayout CreateNotePanelLayout = new javax.swing.GroupLayout(CreateNotePanel);
                CreateNotePanel.setLayout(CreateNotePanelLayout);
                CreateNotePanelLayout.setHorizontalGroup(
                        CreateNotePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(CreateNotePanelLayout.createSequentialGroup()
                                .addGroup(CreateNotePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(CreateNotePanelLayout.createSequentialGroup()
                                                .addGap(145, 145, 145)
                                                .addComponent(CreateNewNoteLabel))
                                        .addGroup(CreateNotePanelLayout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(CreateNotePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(CreateNotePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(CreateNotePanelLayout.createSequentialGroup()
                                                                        .addComponent(SubmitButton)
                                                                        .addGap(71, 71, 71)
                                                                        .addComponent(CancelButton)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(btnBack))
                                                                .addComponent(DirectionsLabel)
                                                                .addComponent(NewNoteField, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(CreateNotePanelLayout.createSequentialGroup()
                                                                        .addComponent(labelNoteTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(fieldNoteTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreateNotePanelLayout.createSequentialGroup()
                                                                        .addGroup(CreateNotePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(NoteDate, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(labelAlertDate))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(CreateNotePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(labelAlertTime)
                                                                                .addComponent(NoteTime, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel1)
                                                                                .addComponent(labelAlertTimeFormat))))
                                                        .addComponent(labelAlertDateFormat))))
                                .addContainerGap(33, Short.MAX_VALUE))
                );
                CreateNotePanelLayout.setVerticalGroup(
                        CreateNotePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(CreateNotePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(CreateNewNoteLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(CreateNotePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelNoteTitle)
                                        .addComponent(fieldNoteTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DirectionsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(CreateNotePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(CreateNotePanelLayout.createSequentialGroup()
                                                .addComponent(NewNoteField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addGroup(CreateNotePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labelAlertDate)
                                                        .addComponent(labelAlertTime))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(CreateNotePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labelAlertDateFormat)
                                                        .addComponent(labelAlertTimeFormat))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(CreateNotePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(NoteDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(NoteTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(CreateNotePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(SubmitButton)
                                                        .addComponent(CancelButton)
                                                        .addComponent(btnBack)))
                                        .addGroup(CreateNotePanelLayout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CreateNotePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(CreateNotePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
		noteCntl.giveNavControl();
        }//GEN-LAST:event_btnBackActionPerformed

        private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
		if (!(NoteDate.getText().equals("")) || !(NoteTime.getText().equals(""))) {
			String inputDateTime = NoteDate.getText() + " " + NoteTime.getText();
			SimpleDateFormat formatDateTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			try {
				java.util.Date dueByDateTime = formatDateTime.parse(inputDateTime);
				java.sql.Date sqlDate = new java.sql.Date(dueByDateTime.getTime());
				System.out.println(dueByDateTime.toString());
				noteCntl.sendNote(fieldNoteTitle.getText(), NewNoteField.getText(), sqlDate);
			} catch (ParseException ex) {
				Logger.getLogger(NoteView.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			noteCntl.sendNote(fieldNoteTitle.getText(), NewNoteField.getText());
		}
        }//GEN-LAST:event_SubmitButtonActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton CancelButton;
        private javax.swing.JLabel CreateNewNoteLabel;
        private javax.swing.JPanel CreateNotePanel;
        private javax.swing.JLabel DirectionsLabel;
        private javax.swing.JTextField NewNoteField;
        private javax.swing.JFormattedTextField NoteDate;
        private javax.swing.JFormattedTextField NoteTime;
        private javax.swing.JButton SubmitButton;
        private javax.swing.JButton btnBack;
        private javax.swing.JTextField fieldNoteTitle;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel labelAlertDate;
        private javax.swing.JLabel labelAlertDateFormat;
        private javax.swing.JLabel labelAlertTime;
        private javax.swing.JLabel labelAlertTimeFormat;
        private javax.swing.JLabel labelNoteTitle;
        // End of variables declaration//GEN-END:variables
}
