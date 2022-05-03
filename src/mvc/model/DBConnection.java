/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.sql.Date;
import static mvc.model.DBConnection.getCurrentPath;

/**
 *
 * @author bryce
 */
public class DBConnection {

	private Connection connection;
	private List<ArrayList<String>> resultArr;
	private ArrayList<String> colArr;

	/**
	 *
	 */
	public DBConnection() {
		this.connect();
	}

	/**
	 *
	 * @return
	 */
	public Connection connect() {
		String dataBasePath = getCurrentPath() + "/SQLite/Note-Taking-App-DB.db";

		File dataBase = new File(dataBasePath);
		boolean dataBaseExists = dataBase.exists();

		try {
			String url = "jdbc:sqlite:" + dataBasePath;

			connection = DriverManager.getConnection(url);

			System.out.println("Connection to SQLite has been established.");

			if (!dataBaseExists) {
				String stmt = "CREATE TABLE USERS_NOTES ("
					+ "NoteID INTEGER REFERENCES NOTES (NoteID),"
					+ "UserID INTEGER REFERENCES USERS (UserID)"
					+ ");";
				PreparedStatement createTable = connection.prepareStatement(stmt);
				createTable.execute();
				stmt = "CREATE TABLE USERS ("
					+ "UserID    INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "FirstName TEXT,"
					+ "LastName  TEXT"
					+ ");";
				createTable = connection.prepareStatement(stmt);
				createTable.execute();
				stmt = "CREATE TABLE NOTES ("
					+ "NoteID      INTEGER  PRIMARY KEY AUTOINCREMENT,"
					+ "CreatedDate DATETIME,"
					+ "DueByDate   DATETIME,"
					+ "Body        TEXT,"
					+ "Title       TEXT"
					+ ");";
				createTable = connection.prepareStatement(stmt);
				createTable.execute();
			}

			return connection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

	/**
	 *
	 * @return
	 */
	public List<ArrayList<String>> selectAllUsers() {
		String queryUsers = "SELECT * FROM USERS";

		try ( PreparedStatement stmt = connection.prepareStatement(queryUsers)) {

			ResultSet resultSet = stmt.executeQuery();
			ResultSetMetaData rsmd = resultSet.getMetaData();

			String c1;
			String c2;
			String c3;

			colArr = new ArrayList<>();

			int colNum = rsmd.getColumnCount();

			for (int i = 1; i <= colNum; i++) {
				colArr.add(rsmd.getColumnName(i));
			}

			resultArr = new ArrayList<ArrayList<String>>();
			while (resultSet.next()) {
				c1 = resultSet.getObject(1).toString();
				c2 = resultSet.getObject(2).toString();
				c3 = resultSet.getObject(3).toString();
				System.out.println(c1);
				System.out.println(c2);
				System.out.println(c3);
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

	/**
	 *
	 * @param userId
	 * @param firstName
	 * @param lastName
	 */
	public void insertUser(
		//		int userId, 
		String firstName, String lastName) {
		String insertUserStmt = "INSERT INTO USERS "
			+ "(FirstName, LastName) "
			+ "VALUES (?, ?)";
		try ( PreparedStatement stmt = connection.prepareStatement(insertUserStmt)) {

			// insert values into SQL prepared statement and execute
//			queryStatement.setInt(1, userId);
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public Integer insertNote(String noteTitle, String noteBody) {
		String insertNote = "INSERT INTO NOTES "
			+ "(Body, CreatedDate, Title) "
			+ "VALUES (?, ?, ?)";
		try ( PreparedStatement queryStatement = connection.prepareStatement(insertNote)) {
			Date createdDate = new Date(System.currentTimeMillis());
			queryStatement.setString(1, noteBody);
			queryStatement.setDate(2, createdDate);
			queryStatement.setString(3, noteTitle);
			int noteID = queryStatement.executeUpdate();
			queryStatement.close();
			return noteID;

		} catch (SQLException e) {
			e.getMessage();
		}
		return -1;
	}

	public Integer insertNote(String noteTitle, String noteBody, Date dueByDate) {
		String insertNote = "INSERT INTO NOTES "
			+ "(Body, CreatedDate, DateDueBy, Title) "
			+ "VALUES (?, ?, ?, ?)";
		try ( PreparedStatement queryStatement = connection.prepareStatement(insertNote)) {
			Date createdDate = new Date(System.currentTimeMillis());
			queryStatement.setString(1, noteBody);
			queryStatement.setDate(2, createdDate);
			queryStatement.setDate(3, dueByDate);
			queryStatement.setString(4, noteTitle);
			int noteID = queryStatement.executeUpdate();
			queryStatement.close();
			return noteID;

		} catch (SQLException e) {
			e.getMessage();
		}
		return -1;
	}

	public void insertNoteUser(int userId, int noteId) {
		String insertData = "INSERT INTO USERS_NOTES "
			+ "(NoteID, UserID) "
			+ "VALUES (?, ?)";
		try ( PreparedStatement queryStatement = connection.prepareStatement(insertData)) {
			queryStatement.setInt(1, noteId);
			queryStatement.setInt(2, userId);
			queryStatement.executeUpdate();
			queryStatement.close();

		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public int getNoteID(String title) {
		String insertData = "SELECT NoteID FROM NOTES"
			+ " WHERE Title = ?";
		try ( PreparedStatement queryStatement = connection.prepareStatement(insertData)) {

			queryStatement.setString(1, title);
			ResultSet resultSet = queryStatement.executeQuery();
			int noteID = resultSet.getInt("NoteID");
//			ArrayList<Integer> arr = new ArrayList<>(); 
//			while (resultSet.next()) {
//				arr.add(resultSet.getInt("NoteID"));
//			}
//			return arr;
			resultSet.close();
			queryStatement.close();
			System.out.println("NoteID: " + noteID);
			return noteID;

		} catch (SQLException e) {
			e.getMessage();
		}
		return -1;
	}

	/**
	 *
	 * @param userId
	 */
	public void removeUser(int userId) {
		String removeUserStmt = "DELETE FROM USERS where UserID = ?";
		try ( PreparedStatement queryStatement = connection.prepareStatement(removeUserStmt)) {

			// insert values into SQL prepared statement and execute
			queryStatement.setInt(1, userId);
			queryStatement.executeUpdate();
			queryStatement.close();

		} catch (SQLException e) {
			e.getMessage();
		}
	}

	/**
	 *
	 */
	public void closeConnection() {
		try {
			connection.close();
			System.out.println("Connection to SQLite has been closed.");
		} catch (SQLException e) {
		}
	}

	/**
	 *
	 * @return
	 */
	public static String getCurrentPath() {
		return System.getProperty("user.dir");
	}

	/**
	 *
	 * @return
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 *
	 * @param connection
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	/**
	 *
	 * @return
	 */
	public List<ArrayList<String>> getResultArr() {
		return resultArr;
	}

	/**
	 *
	 * @param resultArr
	 */
	public void setResultArr(List<ArrayList<String>> resultArr) {
		this.resultArr = resultArr;
	}

	/**
	 *
	 * @return
	 */
	public ArrayList<String> getColArr() {
		return colArr;
	}

	/**
	 *
	 * @param colArr
	 */
	public void setColArr(ArrayList<String> colArr) {
		this.colArr = colArr;
	}

	public int getLastUserId() {
		String queryId = "SELECT * FROM USERS ORDER BY UserID DESC LIMIT 1";

		try ( PreparedStatement stmt = connection.prepareStatement(queryId)) {

			ResultSet resultSet = stmt.executeQuery();

			return resultSet.getRow();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return -1;
	}

	public boolean checkAccountCredentials(String firstName, String lastName) {
		String queryAccount = "SELECT * FROM USERS where FirstName = ? AND LastName = ?";

		try ( PreparedStatement stmt = connection.prepareStatement(queryAccount)) {
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			ResultSet resultSet = stmt.executeQuery();

			Boolean accountExist = false;
			while (resultSet.next()) {
				String resFirstName = resultSet.getString("FirstName");
				String resLastName = resultSet.getString("LastName");
				if (firstName.equalsIgnoreCase(resFirstName) && lastName.equals(resLastName)) {
					accountExist = true;
					break;
				}
			}

			resultSet.close();
			stmt.close();

			if (accountExist) {
				return true;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	public void insertDate(int noteID, Date finalDateTime) {
		String insertDateStatement = "Update NOTES "
			+ "SET DateDueBy = ? "
			+ "where NoteID = ?";

		try ( PreparedStatement queryStatement = connection.prepareStatement(insertDateStatement)) {
			queryStatement.setDate(1, finalDateTime);
			queryStatement.setInt(2, noteID);
			queryStatement.executeUpdate();
			
			queryStatement.close();
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public int getUserId(String firstName, String lastName) {
		String userIdStatement = "SELECT UserID from USERS where "
			+ "FirstName = ? AND LastName = ?";
		try ( PreparedStatement stmt = connection.prepareStatement(userIdStatement)) {
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			ResultSet resultSet = stmt.executeQuery();
			int userId = resultSet.getInt("UserID");
			resultSet.close();
			stmt.close();
			return userId;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}
	
	public ArrayList<String> selectNote(int noteID) {
		String selectNotes = "SELECT Title, Body from Notes "
			+ "where NoteID = ?";
		try (PreparedStatement stmt = connection.prepareStatement(selectNotes)) {
			stmt.setInt(1, noteID);
			ResultSet resultSet = stmt.executeQuery();
			ArrayList<String> arr = new ArrayList<>();
			while(resultSet.next()) {
				arr.add(resultSet.getString("Title"));
				arr.add(resultSet.getString("Body"));
			}
			resultSet.close();
			stmt.close();
			return arr;
		} catch (SQLException e) {
			System.out.println("selectNote");
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public int getLastNoteID() {
		String lastID = "SELECT * from NOTES ORDER BY NoteID DESC LIMIT 1";
		try (PreparedStatement stmt = connection.prepareStatement(lastID)) {
			ResultSet resultSet = stmt.executeQuery();
			int noteID = resultSet.getInt("NoteID");
			System.out.println("LastNoteID: " + noteID);
			return noteID;
		} catch (SQLException e) {
			System.out.println("getLastNoteID");
			System.out.println(e.getMessage());
		}
		return -1;
	}
	
	public int getFirstNoteID() {
		String lastID = "SELECT * from NOTES ORDER BY NoteID ASC LIMIT 1";
		try (PreparedStatement stmt = connection.prepareStatement(lastID)) {
			ResultSet resultSet = stmt.executeQuery();
			int noteID = resultSet.getInt("NoteID");
			System.out.println("LastNoteID: " + noteID);
			return noteID;
		} catch (SQLException e) {
			System.out.println("getLastNoteID");
			System.out.println(e.getMessage());
		}
		return -1;
	}
	
	public void updateNote(int noteID, String noteTitle, String noteBody) {
		String updateNote = "UPDATE NOTES "
			+ "SET Title = ? , Body = ? "
			+ "where NoteID = ?";
		try (PreparedStatement stmt = connection.prepareStatement(updateNote)) {
			stmt.setString(1, noteTitle);
			stmt.setString(2, noteBody);
			stmt.setInt(3, noteID);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("updateDate");
			System.out.println(e.getMessage());
		}
	}
}
