/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
import java.util.List;
/**
 *
 * @author bryce
 */
public class DBConnection {

	private Connection connection;
	private List<ArrayList<String>> resultArr;
	private ArrayList colArr;
	
	public Connection connect() {
		String dataBasePath = getCurrentPath() + "/SQLite/Note-Taking-App-DB.db";
		try {
			String url = "jdbc:sqlite:" + dataBasePath;

			connection = DriverManager.getConnection(url);

			System.out.println("Connection to SQLite has been established.");

			return connection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

	public List<ArrayList<String>> selectAllUsers() {
		String queryUsers = "SELECT * FROM USERS";

		try ( PreparedStatement stmt = connection.prepareStatement(queryUsers)) {
			
			ResultSet resultSet = stmt.executeQuery();
			ResultSetMetaData rsmd = resultSet.getMetaData();
				
			String c1;
			String c2;
			String c3;
			
			colArr = new ArrayList<String>();
			
			int colNum = rsmd.getColumnCount();
			
			for (int i = 1; i <= colNum; i++) {
				colArr.add(rsmd.getColumnName(i));
			}
			
			resultArr = new ArrayList<ArrayList<String>>();
			while(resultSet.next()) {
				c1 = resultSet.getObject(1).toString();
				c2 = resultSet.getObject(2).toString();
				c3 = resultSet.getObject(3).toString();
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(c1);
				temp.add(c2);
				temp.add(c3);
				resultArr.add(temp);
			}
			
			return resultArr;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}

	public void insertUser(int userId, String firstName, String lastName) {
		String insertUserStmt = "INSERT INTO USERS"
			+ " (UserID,FirstName,LastName) VALUES (?,?,?)";
		try ( PreparedStatement queryStatement = connection.prepareStatement(insertUserStmt)) {

			// insert values into SQL prepared statement and execute
			queryStatement.setInt(1, userId);
			queryStatement.setString(2, firstName);
			queryStatement.setString(3, lastName);
			queryStatement.executeUpdate();

		} catch (SQLException e) {
			e.getMessage();
		}
	}
	
	public void removeUser(int userId) {
		String removeUserStmt = "DELETE FROM USERS where UserID = ?";
		try ( PreparedStatement queryStatement = connection.prepareStatement(removeUserStmt)) {

			// insert values into SQL prepared statement and execute
			queryStatement.setInt(1, userId);
			queryStatement.executeUpdate();

		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
		}
	}

	public static String getCurrentPath() {
		return System.getProperty("user.dir");
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public List<ArrayList<String>> getResultArr() {
		return resultArr;
	}

	public void setResultArr(List<ArrayList<String>> resultArr) {
		this.resultArr = resultArr;
	}	

	public ArrayList getColArr() {
		return colArr;
	}

	public void setColArr(ArrayList colArr) {
		this.colArr = colArr;
	}
}
