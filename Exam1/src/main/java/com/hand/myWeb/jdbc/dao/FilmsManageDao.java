package com.hand.myWeb.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hand.myWeb.bean.Film;
import com.hand.myWeb.bean.Language;
import com.hand.myWeb.jdbc.jdbcConnection.JdbcCallbackInterface;
import com.hand.myWeb.jdbc.jdbcConnection.JdbcTemplate;

public class FilmsManageDao extends JdbcTemplate<Film>{
	public List<Film> getAllFilm(boolean transactionSurport){
		JdbcTemplate<Film> ShowFilms=new FilmsManageDao();
		String sql="select f.film_id,title,description,l.name from film f, language l where f.language_id=l.language_id";
		List<Film> list=ShowFilms.query(sql, 
			new JdbcCallbackInterface<Film>(){

			public void setParam(PreparedStatement ps) throws SQLException {}									
			
			public List<Film> getResultSet(ResultSet rs) throws SQLException {
				List<Film> list1=new ArrayList<Film>();
				while(rs.next()){
					list1.add(new Film(rs.getInt("film_id"),rs.getString("title"),
							rs.getString("description"),rs.getString("name")));
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
		String sql="insert into film (title,description,language_id) values(?,?,?)";
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
	
	public int deleteFilm(int film_id, boolean transactionSurport){
		final int filmId=film_id;
		JdbcTemplate<Film> filmManage=new FilmsManageDao();
		String sql="delete from film where film_id=?";
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
}
