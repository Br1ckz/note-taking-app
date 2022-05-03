/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.controller;

import mvc.model.DBConnection;
import mvc.model.Note;
import mvc.model.User;
import mvc.view.NoteListView;

/**
 *
 * @author bryce
 */
public class NoteListCntl {

	private NavCntl navCntl;
	private NoteListView noteListUI;
	private DBConnection dbConnection;
	private User user;
	private Note note;

	public NoteListCntl(NavCntl navCntl, DBConnection dbConnection, User user) {
		this.navCntl = navCntl;
		this.dbConnection = dbConnection;
		this.user = user;
		note = new Note(dbConnection);
		noteListUI = new NoteListView(this);
		showNoteListUI(true);
	}

	public void showNoteListUI(boolean bool) {
		noteListUI.setVisible(bool);
		if (bool == false) {
			noteListUI.dispose();
		}
	}

	public void giveNavControl() {
		navCntl.showNavUI(true);
		showNoteListUI(false);
	}

	public void getNextNote() {
		note.getNextNote();
	}

	public void getPreviousNote() {
		note.getPreviousNote();
	}

	public String getNoteTitle() {
		return note.getNoteTitle();
	}

	public String getNoteBody() {
		return note.getNoteBody();
	}
	
	public void updateNote(String noteTitle, String noteBody) {
		dbConnection.updateNote(note.getNoteID(), noteTitle, noteBody);
	}
	
	public void deleteNote() {
		dbConnection.deleteNote(note.getNoteID());
	}
}
