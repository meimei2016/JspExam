package com.hand.myWeb.jdbc.jdbcConnection;

import java.sql.Connection;

import com.hand.myWeb.jdbc.dataSource.CommomDataSource;
import com.hand.myWeb.jdbc.dataSource.DataSource;
import com.hand.myWeb.jdbc.dataSource.DataSourceManager;
import com.hand.myWeb.jdbc.dataSource.TransactionDataSource;

public class JdbcConnection implements JdbcConnectionInterface{

	public Connection getConnection(boolean transactiobSurport) {
		Connection con=null;
		if(!transactiobSurport){
			DataSource dataSource=new CommomDataSource();
			con=dataSource.getConn();
		}else{
			DataSource dataSource=new TransactionDataSource();
			con=dataSource.getConn();
		}
		return con;
	}

	public void commit(Connection con) {
		DataSourceManager.commit(con);		
	}
	
	public void rollback(Connection con) {
		DataSourceManager.rollback(con);		
	}
	
	public void close(Connection con) {
		DataSourceManager.close(con);		
	}
}
