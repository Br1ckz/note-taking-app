/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.controller;

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

	public void sendNote(int userId, int noteID, String noteBody) {
		this.dbConnection.insertNote(noteID, noteBody);
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
