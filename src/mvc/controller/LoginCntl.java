/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.controller;

import mvc.model.DBConnection;
import mvc.model.User;
import mvc.view.CreateAccountView;
import mvc.view.LoginView;

/**
 *
 * @author bryce
 */
public class LoginCntl {

	private CreateAccountView createAccountUI;
	private LoginView loginUI;
	private DBConnection dbConnection;
	private User user;

	public LoginCntl() {
		this.dbConnection = new DBConnection();
		this.createAccountUI = new CreateAccountView(this);
		this.loginUI = new LoginView(this);
		showLoginUI(true);
	}

	public void showLoginUI(boolean bool) {
		loginUI.setVisible(bool);
		if (bool == false) {
			loginUI.dispose();
		}
	}

	public void showCreateAccountUI(boolean bool) {
		createAccountUI.setVisible(bool);
		if (bool == false) {
			createAccountUI.dispose();
		}
	}

	public void createAccount(String firstName, String lastName) {
		dbConnection.insertUser(firstName, lastName);
	}

	public void authenticate(String firstName, String lastName) {
		boolean accountExist = dbConnection.checkAccountCredentials(firstName, lastName);
		if (accountExist) {
			int userId = dbConnection.getUserId(firstName, lastName);
			user = new User(userId, firstName, lastName);
			NavCntl navCntl = new NavCntl(this, dbConnection, user);
			showLoginUI(false);
		}
	}
}
