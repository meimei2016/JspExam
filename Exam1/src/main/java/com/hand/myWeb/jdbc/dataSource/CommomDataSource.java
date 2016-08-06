package com.hand.myWeb.jdbc.dataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CommomDataSource implements DataSource{
	static {
		String driver=PropertyData.getParam().get("driver");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static String url=PropertyData.getParam().get("url");
	private static String userName=PropertyData.getParam().get("userName");
	private static String password=PropertyData.getParam().get("password");
	
	/*
	 * get a connection used in no transaction terms
	 */
	public Connection getConn() {
		Connection conn=null;
		try {
			System.out.println(url);
			System.out.println(userName);
			System.out.println(password);
			conn = DriverManager.getConnection(url, userName, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed connection of database ");
		}
		return conn;
	}

}
