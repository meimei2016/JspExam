package com.hand.myWeb.jdbc.dataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceManager {
	public static void commit(Connection con){
		try {
			if(con!=null){
				con.commit();
			}
		} catch (SQLException e) {
			rollback(con);
			throw new RuntimeException("�ύʧ��");
		}
		
	}
	
	public static void rollback(Connection con){
		try {
			if(con!=null){
				con.rollback();
			}
		} catch (SQLException e) {
			throw new RuntimeException("�ع�ʧ��");
		}
	}
	
	public static void close(Connection con){
		try {
			if(con!=null){
				con.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException("�ر�ʧ��");
		}		
	}

}
