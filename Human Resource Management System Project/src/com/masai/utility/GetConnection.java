package com.masai.utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class GetConnection {

	public static Connection connection() {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/hrms";
		
		try {
			conn = DriverManager.getConnection(url, "root", "updesh");
		} catch (SQLException e) {
			System.out.println("not connected!");
		}
		
		
		return conn;
	}
	
	
	
}
