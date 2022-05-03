/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.controller;

import java.sql.Date;
import mvc.model.DBConnection;
import mvc.model.User;
import mvc.view.NoteView;

/**
 *
 * @author Joseph Miller
 *
 */

/*
**************************** MODIFICATION LOG ****************************
 */
public class NoteCntl {

	private final DBConnection dbConnection;
	private final NoteView noteview;
	private final NavCntl navCntl;
	private User user;

	public NoteCntl(NavCntl navCntl, DBConnection dbConnection, User user) {
		this.navCntl = navCntl;
		this.dbConnection = dbConnection;
		this.user = user;
		noteview = new NoteView(this);
		showNoteUI(true);
	}

	public void sendNote(String noteTitle, String noteBody) {
		int userId = user.getUserId();
		int noteID = dbConnection.insertNote(noteTitle, noteBody);	
		dbConnection.insertNoteUser(userId, noteID);
	}
	public void sendNote(String noteTitle, String noteBody, Date dueByDate) {
		int userId = user.getUserId();
		int noteID = dbConnection.insertNote(noteTitle, noteBody, dueByDate);
//		int noteID = dbConnection.getNote(noteTitle);
		dbConnection.insertNoteUser(userId, noteID);
	}
        
//        public void getNote (String title) {
//                this.dbConnection.getNote(title);
//        }

	public void showNoteUI(Boolean bool) {
		noteview.setVisible(bool);
		if (bool == false) {
			noteview.dispose();
		}
	}

	public void giveNavControl() {
		navCntl.showNavUI(true);
		showNoteUI(false);
	}

}// end of class NoteCntl
