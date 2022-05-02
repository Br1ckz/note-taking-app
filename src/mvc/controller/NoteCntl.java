/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.controller;

import java.util.Date;
import java.SQL.Date;
import mvc.model.DBConnection;
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

	public NoteCntl(NavCntl navCntl, DBConnection dbConnection) {
		noteview = new NoteView(this);
		showNoteUI(true);

		this.dbConnection = new DBConnection();
		this.navCntl = navCntl;
	}

	public void sendNote(int userId, int noteID, String noteBody, Date dueByDate) {
		this.dbConnection.insertNote(noteBody,dueByDate);
		this.dbConnection.insertNoteUser(userId, noteID);
	}
        
        public void getNote (String title) {
                this.dbConnection.getNote(title);
        }

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
