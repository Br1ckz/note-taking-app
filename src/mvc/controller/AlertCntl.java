/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import java.util.Date;
import mvc.model.DBConnection;
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
	
	public AlertCntl(NavCntl navCntl, DBConnection dbConnection) {
		this.navCntl = navCntl;
		this.dbConnection = dbConnection;
		this.alertUI = new AlertView(this);
		showAlertUI(true);
	}//DateTimeCntl

	public void showAlertUI(boolean bool) {
		alertUI.setVisible(bool);
		if (bool == false) {
			alertUI.dispose();
		}
	}//showDateTimeCntl   

	public void addDateTime(Date finalDateTime) {
		dbConnection.insertDate(finalDateTime);
	}//addDateTime

	public void giveNavControl() {
		navCntl.showNavUI(true);
		showAlertUI(false);
	}
}//class AlertCntl
