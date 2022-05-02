/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import java.sql.Date;
import mvc.model.DBConnection;
import mvc.model.User;
import mvc.view.AlertView;

/**
 *
 * @author sabrinamatteoli
 */

/**
 * ******************************* MODIFICATION LOG
 * *************************************
 *
 *
 ****************************************************************************************
 */
public class AlertCntl {

	private AlertView alertUI;
	private DBConnection dbConnection;
	private NavCntl navCntl;
	private User user;
	
	public AlertCntl(NavCntl navCntl, DBConnection dbConnection, User user) {
		this.navCntl = navCntl;
		this.dbConnection = dbConnection;
		this.user = user;
		this.alertUI = new AlertView(this);
		showAlertUI(true);
	}//DateTimeCntl

	public void showAlertUI(boolean bool) {
		alertUI.setVisible(bool);
		if (bool == false) {
			alertUI.dispose();
		}
	}//showDateTimeCntl   

	public void addDateTime(String noteTitle, Date finalDateTime) {
		int noteID = dbConnection.getNoteID(noteTitle);
		dbConnection.insertDate(noteID, finalDateTime);
	}//addDateTime

	public void giveNavControl() {
		navCntl.showNavUI(true);
		showAlertUI(false);
	}
}//class AlertCntl
