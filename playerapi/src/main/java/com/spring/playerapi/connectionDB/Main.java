package com.spring.playerapi.connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

		String username ="root";
		String password ="mostafa";
		String url ="jdbc:mysql://localhost:3306/player?useSSL=false";
		String driver = "com.mysql.cj.jdbc.Driver";
		Connection connection = null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connected successfully!");
			//System.out.println(connection);
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		finally {
			connection.close();
		}
	}

}
