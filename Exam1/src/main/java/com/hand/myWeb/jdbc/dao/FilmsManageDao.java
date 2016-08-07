package com.hand.myWeb.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hand.myWeb.bean.Film;
import com.hand.myWeb.bean.Inventory;
import com.hand.myWeb.bean.Language;
import com.hand.myWeb.common.Constants;
import com.hand.myWeb.jdbc.jdbcConnection.JdbcCallbackInterface;
import com.hand.myWeb.jdbc.jdbcConnection.JdbcTemplate;

public class FilmsManageDao extends JdbcTemplate<Film>{
	public List<Film> getAllFilm(boolean transactionSurport){
		JdbcTemplate<Film> ShowFilms=new FilmsManageDao();
		String sql=Constants.SQL_SELECT_ALL_FILM;
		List<Film> list=ShowFilms.query(sql, 
			new JdbcCallbackInterface<Film>(){

			public void setParam(PreparedStatement ps) throws SQLException {}									
			
			public List<Film> getResultSet(ResultSet rs) throws SQLException {
				List<Film> list1=new ArrayList<Film>();
				while(rs.next()){
					list1.add(new Film(rs.getInt(Constants.TABLE_FILM_FILMID),rs.getString(Constants.TABLE_FILM_TITLE),
							rs.getString(Constants.TABLE_FILM_DESCRIPTION),rs.getString(Constants.TABLE_FILM_NAME)));
				 }
				return list1;
			  }
			}, transactionSurport);
		return list;
	}
	
	public int addFilm(Film f,boolean transactionSurport){
		final Film film=f;
		JdbcTemplate<Film> filmManage=new FilmsManageDao();
		LanguageManageDao languageDao=new LanguageManageDao();
		final Language language=languageDao.getLanguage(film.getLanguage(), transactionSurport);
		String sql=Constants.SQL_INSERT_FILM;
		int i=filmManage.update(sql, 
				new JdbcCallbackInterface<Film>(){

			public void setParam(PreparedStatement ps) throws SQLException {
				ps.setString(1, film.getTitle());
				ps.setString(2, film.getDescription());
				ps.setInt(3, language.getLanguage_id());				
			}

			public List<Film> getResultSet(ResultSet rs) throws SQLException {				
				return null;
			}									
			}, transactionSurport);
		return i;
	}
	
	public int deleteFilm(String sql, int film_id, boolean transactionSurport){
		final int filmId=film_id;
		JdbcTemplate<Film> filmManage=new FilmsManageDao();		
		int i=filmManage.update(sql, 
			new JdbcCallbackInterface<Film>(){
				public void setParam(PreparedStatement ps) throws SQLException {
					ps.setInt(1, filmId);				
				}
				public List<Film> getResultSet(ResultSet rs) throws SQLException {				
					return null;
				}									
			}, transactionSurport);
		return i;
	}
	
	public int deleteFilmRefer(int film_id, boolean transactionSurport){
		String sqls[]=Constants.SQL_DELETE_Film_REFER;
		int result=0;
		List<Inventory> inventoryList=new InventoryManageDao().getInventoryByFilmId(film_id, transactionSurport);
		for(Inventory inventory:inventoryList){
			new RentalManageDaoImpl().deleteRentalByInventoryId(inventory.getInventory_id(), transactionSurport);
		}		
		for(int j=0;j<sqls.length;j++){
			int i=deleteFilm( sqls[j], film_id,transactionSurport);
			if(j==sqls.length-1){
				result=i;
			}
		}
		return result;
	}
}
