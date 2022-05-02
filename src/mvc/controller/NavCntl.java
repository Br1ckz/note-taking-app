/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.controller;

import mvc.model.DBConnection;
import mvc.model.User;
import mvc.view.NavView;

/**
 *
 * @author bryce
 */
public class NavCntl {

	private LoginCntl loginCntl;
	private NavView navUI;
	private DBConnection dbConnection;
	private User user;

	public NavCntl(LoginCntl loginCntl, DBConnection dbConnection, User user) {
		this.loginCntl = loginCntl;
		this.dbConnection = dbConnection;
		this.user = user;
		navUI = new NavView(this);
		showNavUI(true);
	}

	public void showNavUI(boolean bool) {
		navUI.setVisible(bool);
		if (bool == false) {
			navUI.dispose();
		}
	}

	public void giveLoginControl() {
		loginCntl.showLoginUI(true);
		showNavUI(false);
	}

	public void giveNoteControl() {
		NoteCntl noteCntl = new NoteCntl(this, dbConnection, user);
		showNavUI(false);
	}

	public void giveAlertControl() {
		AlertCntl alertCntl = new AlertCntl(this, dbConnection, user);
		showNavUI(false);
	}

	public void giveNoteListControl() {
		NoteListCntl noteListCntl = new NoteListCntl(this, dbConnection, user);
		showNavUI(false);
	}
}
