/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.controller;

import mvc.model.DBConnection;
import mvc.view.NavView;

/**
 *
 * @author bryce
 */
public class NavCntl {
	private LoginCntl loginCntl;
	private NavView navUI;
	private DBConnection dbConnection;
	
	public NavCntl(LoginCntl loginCntl, DBConnection dbConnection) {
		this.loginCntl = loginCntl;
		this.dbConnection = dbConnection;
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
		NoteCntl noteCntl = new NoteCntl(this, dbConnection);
		showNavUI(false);
	}
	
	public void giveAlertControl() {
		AlertCntl alertCntl = new AlertCntl(this, dbConnection);
		showNavUI(false);
	}
}
