package com.stepinfo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcMysqlConnector {

//	Driver monDriver = new com.mysql.jdbc.Driver();
//	DriverManager.registerDriver(monDriver);
	private static Connection connection;

	synchronized public static Connection getInstance() {
		
		if ( connection == null )
			initConnection();

		return connection;
			
	}
	
	// initialisation de la connexion à la base MySQL
	private static void initConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Trouver le jar du driver JDBC !");
			e.printStackTrace();
		}
		
		// Création de la connection
		System.out.println("MySQL JDBC Driver Registered!");

		try {
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/cem",
							"root", "root");
 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}

	}


}
