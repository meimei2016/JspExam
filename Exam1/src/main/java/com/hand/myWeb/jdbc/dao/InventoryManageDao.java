package com.hand.myWeb.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hand.myWeb.bean.Inventory;
import com.hand.myWeb.common.Constants;
import com.hand.myWeb.jdbc.jdbcConnection.JdbcCallbackInterface;
import com.hand.myWeb.jdbc.jdbcConnection.JdbcTemplate;

public class InventoryManageDao extends JdbcTemplate<Inventory> {
	public List<Inventory> getInventoryByFilmId(int filmId,boolean transactionSurport){
		
		final int film_id=filmId;		
		JdbcTemplate<Inventory> login=new InventoryManageDao();
		
		String sql=Constants.SQL_SELECT_INVENTORY_BY_FILMID;
		List<Inventory> list=login.query(sql, 
			new JdbcCallbackInterface<Inventory>(){
	
				public void setParam(PreparedStatement ps) throws SQLException {
					ps.setInt(1, film_id);					
				}
				public List<Inventory> getResultSet(ResultSet rs) throws SQLException {
					List<Inventory> list1=new ArrayList<Inventory>();
					while(rs.next()){
						list1.add(new Inventory(rs.getInt(Constants.TABLE_INVENTORY_INVENTORYID),rs.getInt(Constants.TABLE_FILM_FILMID),
								  rs.getInt(Constants.TABLE_INVENTORY_STOREID),rs.getDate(Constants.TABLE_INVENTORY_LASTUPDATE)));
					}
					return list1;
				}
		},transactionSurport);
		return list;
	}

}
