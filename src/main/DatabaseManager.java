package main;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DatabaseManager {
	private static final String DB_DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
	private static final String CONNECTION_STRING = "jdbc:mysql://mysql.stud.ntnu.no/ingebrin_dbproj?serverTimezone=UTC";
	private static final String DB_USERNAME = "ingebrin_dbproj";
	private static final String DB_PASSWORD = "dbproj";
	
	private static Connection connection;
	
	static {
		try {
			Class.forName(DB_DRIVER_PATH);
			connection = DriverManager.getConnection(CONNECTION_STRING, DB_USERNAME, DB_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Map<String, String>> sendQuery(String query) {
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			ResultSetMetaData rsmd = resultSet.getMetaData();
			
			// return-liste som inneholder hvert objekt som en hashmap mellom kolonne-overskrift og kolonne-verdi.
			List<Map<String, String>> resultArray = new ArrayList<>(); 
			
			while (resultSet.next()) {
				Map<String, String> currentRow = new HashMap<String, String>();
			       for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			           currentRow.put(rsmd.getColumnName(i), resultSet.getString(i));
			       } // lagrer et objekt i hashmappet "currentRow"
			       resultArray.add(currentRow); // lagrer currentRow i return-lista
		    }
			statement.close();
			
			return resultArray;
			
		} catch (SQLException e) {
			System.out.println("Query failed.");
			e.printStackTrace();
			return null;
		}
	}
	
	public static int sendUpdate(String update) {
		try {
			Statement statement = connection.createStatement();
			int rowsAffected = statement.executeUpdate(update);
			statement.close();
			
			return rowsAffected;
			
		} catch (SQLException e) {
			System.err.println("Connection failed.");
			e.printStackTrace();
			return 0;
		}
	}
	
	public static void closeConnection() {
		try {
			connection.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}


