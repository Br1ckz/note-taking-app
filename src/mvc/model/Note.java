/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author bryce
 */
public class Note {

	private DBConnection dbConnection;
	private int noteID;
	private String noteTitle;
	private String noteBody;
	private int firstNoteID;
	private int lastNoteID;

	public Note(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
		firstNoteID = dbConnection.getFirstNoteID();
		noteID = firstNoteID;
		lastNoteID = dbConnection.getLastNoteID();
	}

	public int getNoteID() {
		return noteID;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public String getNoteBody() {
		return noteBody;
	}

	public void getNextNote() {
		noteID++;
		if (noteID <= lastNoteID) {
			ArrayList arr = dbConnection.selectNote(noteID);
			noteTitle = arr.get(0).toString();
			noteBody = arr.get(1).toString();
			System.out.println("NoteTitle: " + noteTitle);
			System.out.println("NoteBody: " + noteBody);
		} else {
			noteID = 1;
			ArrayList arr = dbConnection.selectNote(noteID);
			noteTitle = arr.get(0).toString();
			noteBody = arr.get(1).toString();
			System.out.println("NoteTitle: " + noteTitle);
			System.out.println("NoteBody: " + noteBody);
		}
	}

	public void getPreviousNote() {
		noteID--;
		if (noteID >= firstNoteID) {
			ArrayList arr = dbConnection.selectNote(noteID);
			noteTitle = arr.get(0).toString();
			noteBody = arr.get(1).toString();
			System.out.println("NoteTitle: " + noteTitle);
			System.out.println("NoteBody: " + noteBody);
		} else {
			noteID = lastNoteID;
			ArrayList arr = dbConnection.selectNote(noteID);
			noteTitle = arr.get(0).toString();
			noteBody = arr.get(1).toString();
			System.out.println("NoteTitle: " + noteTitle);
			System.out.println("NoteBody: " + noteBody);
		}
	}
}
