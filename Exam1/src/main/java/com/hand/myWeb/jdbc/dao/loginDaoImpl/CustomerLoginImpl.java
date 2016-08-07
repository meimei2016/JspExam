package com.hand.myWeb.jdbc.dao.loginDaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hand.myWeb.common.Constants;
import com.hand.myWeb.jdbc.dao.CustomerLoginDao;
import com.hand.myWeb.jdbc.jdbcConnection.JdbcCallbackInterface;
import com.hand.myWeb.jdbc.jdbcConnection.JdbcTemplate;

public class CustomerLoginImpl extends JdbcTemplate<Integer> implements CustomerLoginDao{

	@Override
	public int getUserName(String userName,boolean transactionSurport) {
		final String name=userName;		
		JdbcTemplate<Integer> login=new CustomerLoginImpl();
		
		String sql=Constants.SQL_SELECT_CUSTOMER_BY_NAME;
		int i=login.queryOne(sql, 
			new JdbcCallbackInterface<Integer>(){

				public void setParam(PreparedStatement ps) throws SQLException {
					ps.setString(1, name);					
				}
				public List<Integer> getResultSet(ResultSet rs) throws SQLException {
					List<Integer> list=new ArrayList<Integer>();
					while(rs.next()){
						list.add(rs.getInt(1));
					}
					return list;
				}
		},transactionSurport);
		return i;
	}
}
