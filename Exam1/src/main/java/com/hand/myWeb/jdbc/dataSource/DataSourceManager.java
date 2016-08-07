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
			throw new RuntimeException("�ύʧ��",e);
		}
		
	}
	
	public static void rollback(Connection con){
		try {
			if(con!=null){
				con.rollback();
			}
		} catch (SQLException e) {
			throw new RuntimeException("�ع�ʧ��",e);
		}
	}
	
	public static void close(Connection con){
		try {
			if(con!=null){
				con.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException("�ر�ʧ��",e);
		}		
	}

}
