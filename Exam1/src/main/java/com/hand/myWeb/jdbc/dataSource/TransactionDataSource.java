package com.hand.myWeb.jdbc.dataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransactionDataSource implements DataSource{
	
	static ThreadLocal<Connection>  threadLocal=new ThreadLocal<Connection>();
    private static String url=PropertyData.getParam().get("url");
	private static String userName=PropertyData.getParam().get("userName");
	private static String password=PropertyData.getParam().get("password");
	
	/*
	 * get a connection used in transaction terms
	 */
	public Connection getConn() {
		Connection con=null;
		try {
			if(threadLocal.get()==null||threadLocal.get().isClosed()){
				con=DriverManager.getConnection(url, userName, password);
				con.setAutoCommit(false);
				threadLocal.set(con);				
			}else{
				return threadLocal.get();
			}			
		} catch (SQLException e) {
			throw new RuntimeException("Failed connection of database ");
		}
		return con;
	}
 
}
