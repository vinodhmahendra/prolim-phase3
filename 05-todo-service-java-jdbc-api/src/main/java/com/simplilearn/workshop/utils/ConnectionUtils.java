package com.simplilearn.workshop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// load the driver class
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?useSSL=false", "root", "OmgPassword!");
	
		return connection;
	}

}
