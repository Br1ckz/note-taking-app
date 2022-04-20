/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package NoteTakingApp;

import java.sql.Connection;
import java.util.Scanner;
import mvc.model.DBConnection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bryce
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		DBConnection dbConnection = new DBConnection();

//		if (connection != null) {
//			insertUser(dbConnection);
//			dbConnection.removeUser(2);
//			printUsers(dbConnection);
//			dbConnection.closeConnection();
//		}
	}

	public static void insertUser(DBConnection dbConnection) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a UserID: ");
		int userId = Integer.parseInt(scanner.nextLine());

		System.out.print("Enter a first name: ");
		String firstName = scanner.nextLine();

		System.out.print("Enter a last name: ");
		String lastName = scanner.nextLine();

		dbConnection.insertUser(userId, firstName, lastName);
	}

	public static void printUsers(DBConnection dbConnection) {
		dbConnection.selectAllUsers();
		List<ArrayList<String>> userRs = dbConnection.selectAllUsers();
		ArrayList cols = dbConnection.getColArr();

		// loop through column names
		for (var col : cols) {
			System.out.printf("%-20s\t", col);
		}

		System.out.println();
		
		// loop through the result set  
		for (ArrayList temp : userRs) {
			
			System.out.printf("%-20s\t%-20s\t%-20s",
				temp.get(0),
				temp.get(1),
				temp.get(2));
			System.out.println();

		}
	}
}
