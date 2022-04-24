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
public class NoteCntl{
    private final DBConnection dbConnection;
    private final NoteView noteview;
    private final LoginCntl loginview;
    
    public NoteCntl(){
        noteview = new NoteView();
        showNoteUI(true);
        
        dbConnection = new DBConnection();
        
        loginview = new LoginCntl();
        this.loginview.showLoginUI(false);
    }
    
    public void sendNote (int userId, int noteID, String noteBody) {
        this.dbConnection.insertNote(noteID, noteBody);
        this.dbConnection.insertNoteUser(userId, noteID);
    }
    
    public void showNoteUI(Boolean bool) { 
        noteview.setVisible(bool);
        if (bool == false) {
                noteview.dispose();
        }
    }
    
    public void returnToLogin() {
        loginview.showLoginUI(true);
        showNoteUI(false);
    }

}// end of class NoteCntl
