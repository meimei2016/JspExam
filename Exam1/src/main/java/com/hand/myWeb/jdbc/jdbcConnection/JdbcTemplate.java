package com.hand.myWeb.jdbc.jdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hand.myWeb.common.Constants;

public abstract class JdbcTemplate<T>{
	
	public List<T> query(String sql, JdbcCallbackInterface<T> callback ,boolean transactionSurport ){
		JdbcConnectionInterface jdbcCon=new JdbcConnection();
		List<T> list=new ArrayList<T>();
		Connection con=jdbcCon.getConnection(transactionSurport);
		PreparedStatement ps=null;
		ResultSet rs=null;					
		try {
			if(con!=null){
				ps=con.prepareStatement(sql);
				callback.setParam(ps);
				rs=ps.executeQuery();
				list=callback.getResultSet(rs);
			}else{
				throw new RuntimeException(Constants.TIP_MESSAGE_COLLECTION_WRONG   );
			}
		} catch (SQLException e) {
			throw new RuntimeException(Constants.TIP_MESSAGE_SQL_WRONG,e);
		}
		if(!transactionSurport){
			close(rs, ps, con);
		}else{
			close(rs, ps, null);
		}
		return list;		
	}
	public T queryOne(String sql,JdbcCallbackInterface<T> callback,boolean transactionSurport){		
		JdbcConnectionInterface jdbcCon=new JdbcConnection();
		Connection con=jdbcCon.getConnection(transactionSurport);
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		T t =null;
		try {
			if(con!=null){
				ps=con.prepareStatement(sql);
				callback.setParam(ps);
				rs=ps.executeQuery();
				t=callback.getResultSet(rs).get(0);
			}else{
				throw new RuntimeException(Constants.TIP_MESSAGE_COLLECTION_WRONG);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(Constants.TIP_MESSAGE_SQL_WRONG);
		}
		if(!transactionSurport){
			close(rs, ps, con);
		}else{
			close(rs, ps, null);
		}
		return t;
	}
	public int update(String sql,JdbcCallbackInterface<T> callback,boolean transactionSurport){
		int i=0;
		JdbcConnectionInterface jdbcCon=new JdbcConnection();
		Connection con=jdbcCon.getConnection(transactionSurport);
		PreparedStatement ps=null;
		try {
			if(con!=null){
				ps=con.prepareStatement(sql);
				callback.setParam(ps);
				i=ps.executeUpdate();
			}else{
				throw new RuntimeException(Constants.TIP_MESSAGE_COLLECTION_WRONG);
			}
		} catch (SQLException e) {
			throw new RuntimeException(Constants.TIP_MESSAGE_SQL_WRONG,e);
		}
		if(!transactionSurport){
			close(null, ps, con);
		}else{
			close(null, ps, null);
		}
		return i;		
	}
	
	public void close(ResultSet rs,PreparedStatement ps,Connection con){
		
		try {
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(con!=null){
				con.close();
			}
		} catch (SQLException e) {				
			e.printStackTrace();				
		}
	}
}
