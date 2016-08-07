package com.hand.myWeb.jdbc.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hand.myWeb.bean.Rental;
import com.hand.myWeb.common.Constants;
import com.hand.myWeb.jdbc.jdbcConnection.JdbcCallbackInterface;
import com.hand.myWeb.jdbc.jdbcConnection.JdbcTemplate;

public class RentalManageDaoImpl extends JdbcTemplate<Rental>{
	public int deleteRentalByInventoryId(int inventoryId,boolean transactionSurport){
		final int inventory_id=inventoryId;
		JdbcTemplate<Rental> entalManageDao=new RentalManageDaoImpl();
		String sql=Constants.SQL_DELETE_RENTAL_BY_INVENTORYID;
		int i=entalManageDao.update(sql, 
				new JdbcCallbackInterface<Rental>(){
			public void setParam(PreparedStatement ps) throws SQLException {
				ps.setInt(1, inventory_id);				
			}
			public List<Rental> getResultSet(ResultSet rs) throws SQLException {				
				return null;
			}									
		}, transactionSurport);
		return i;
	}
	
}
