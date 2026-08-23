package com.JDBC.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseTesting {
	private Connection connection;
	
	public void establishDatabaseConnection() throws ClassNotFoundException, SQLException {
		String databaseURL = "jdbc:mysql://localhost:3306/seleniumautomation";
		String user = "root";
		String password = "Abhi2005";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Connecting to Database");
		connection = DriverManager.getConnection(databaseURL, user,password);
		
		if(connection == null) {
			System.out.println("Database Connection Failed");
		}
		else {
			System.out.println("Databse Connection Successfully");
		}
	}
}
