package com.hand.myWeb.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hand.myWeb.bean.Language;
import com.hand.myWeb.common.Constants;
import com.hand.myWeb.jdbc.jdbcConnection.JdbcCallbackInterface;
import com.hand.myWeb.jdbc.jdbcConnection.JdbcTemplate;

public class LanguageManageDao extends JdbcTemplate<Language>{
	public List<Language> getAllLanguage(boolean transactionSurport){
		JdbcTemplate<Language> languageDao=new LanguageManageDao();
		String sql=Constants.SQL_SELECT_ALL_LANGUAGE;
		List<Language> list=languageDao.query(sql, 
				new JdbcCallbackInterface<Language>(){

				public void setParam(PreparedStatement ps) throws SQLException {}									
				
				public List<Language> getResultSet(ResultSet rs) throws SQLException {
					List<Language> list1=new ArrayList<Language>();
					while(rs.next()){
						list1.add(new Language(rs.getInt(Constants.TABLE_LANGUAGE_LANGUAGEID),
								rs.getString(Constants.TABLE_FILM_NAME),
						rs.getDate(Constants.TABLE_INVENTORY_LASTUPDATE)));
					 }
					return list1;
				  }
				}, transactionSurport);
			return  list;
	}	
	
	public Language getLanguage(String title, boolean transactionSurport){
		JdbcTemplate<Language> languageDao=new LanguageManageDao();
		String sql=Constants.SQL_SELECT_LANGUAGE_BY_NAME;
		final String tit=title;
		Language language=languageDao.queryOne(sql, 
				new JdbcCallbackInterface<Language>(){

				public void setParam(PreparedStatement ps) throws SQLException {
					ps.setString(1, tit);
				}									
				
				public List<Language> getResultSet(ResultSet rs) throws SQLException {
					List<Language> list1=new ArrayList<Language>();
					while(rs.next()){
						list1.add(new Language(rs.getInt(Constants.TABLE_LANGUAGE_LANGUAGEID),
								rs.getString(Constants.TABLE_FILM_NAME),
						rs.getDate(Constants.TABLE_INVENTORY_LASTUPDATE)));
					 }
					return list1;
				  }
				}, transactionSurport);
			return  language;
	}	
}
