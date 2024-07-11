package com.foodie.DbConnectionUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnectionUtil  {
	
	public static final String url ="jdbc:mysql://localhost:3306/online_foods_delivery"; 
	public static final String userName = "root";
	public static final  String pw = "root";
	static Connection connection = null;
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, userName, pw);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return connection;
		
	}

}
