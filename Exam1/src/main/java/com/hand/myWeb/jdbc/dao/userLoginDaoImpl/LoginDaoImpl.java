package com.hand.myWeb.jdbc.dao.userLoginDaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hand.myWeb.bean.mybean.User;
import com.hand.myWeb.common.Constants;
import com.hand.myWeb.jdbc.dao.LoginDaoInterface;
import com.hand.myWeb.jdbc.jdbcConnection.JdbcCallbackInterface;
import com.hand.myWeb.jdbc.jdbcConnection.JdbcTemplate;

public class LoginDaoImpl extends JdbcTemplate<User> implements LoginDaoInterface{
	public User getUser(String userName,boolean transactionSurport){
		final String name=userName;		
		JdbcTemplate<User> login=new LoginDaoImpl();
		
		String sql=Constants.SQL_GET_USER_BY_NAME;
		User user=login.queryOne(sql, 
			new JdbcCallbackInterface<User>(){

				public void setParam(PreparedStatement ps) throws SQLException {
					ps.setString(1, name);					
				}
				public List<User> getResultSet(ResultSet rs) throws SQLException {
					List<User> list=new ArrayList<User>();
					while(rs.next()){
						list.add(new User(rs.getInt(Constants.TABLE_USERS_USERID),rs.getString(Constants.TABLE_USERS_USERNAME),rs.getString(Constants.TABLE_USERS_PASSWORD),rs.getString(Constants.TABLE_USERS_IDENTITY)));
					}
					return list;
				}
		},transactionSurport);
		
		return user;
	}

	public List<User> queryAllUser(boolean transactionSurport) {
		JdbcTemplate<User> login=new LoginDaoImpl();
		String sql=Constants.SQL_GET_ALL_USER;
		List<User> list=login.query(sql, 
			new JdbcCallbackInterface<User>(){
				public void setParam(PreparedStatement ps) throws SQLException {}
				public List<User> getResultSet(ResultSet rs) throws SQLException {
					List<User> list=new ArrayList<User>();
					while(rs.next()){
						list.add(new User(rs.getInt(Constants.TABLE_USERS_USERID),rs.getString(Constants.TABLE_USERS_USERNAME),rs.getString(Constants.TABLE_USERS_PASSWORD),rs.getString(Constants.TABLE_USERS_IDENTITY)));
					}
					return list;
				}
		}, transactionSurport);
		return list;
	}

	public int modifyUserInfo(User user,boolean transactionSurport) {
		JdbcTemplate<User> login=new LoginDaoImpl();
		final User user1=user;
		String sql=Constants.SQL_MODIFY_USER_BY_NAME;
		int i=login.update(sql, 
			new JdbcCallbackInterface<User>(){
				public void setParam(PreparedStatement ps) throws SQLException {
					ps.setString(1, user1.getUserName());
					ps.setString(2, user1.getPassword());
					ps.setString(3, user1.getIdentity());
					ps.setString(4, user1.getUserName());
				}
				public List<User> getResultSet(ResultSet rs) throws SQLException {
					return null;
				}				
			}, transactionSurport);
		return i;
	}

	public int addUser(User user, boolean transactionSurport) {
		JdbcTemplate<User> login=new LoginDaoImpl();
		final User user1=user;
		String sql=Constants.SQL_ADD_USER;
		int i=login.update(sql,
			new JdbcCallbackInterface<User>(){
				public void setParam(PreparedStatement ps) throws SQLException {
					ps.setString(1, user1.getUserName());
					ps.setString(2, user1.getPassword());
					ps.setString(3, user1.getIdentity());
				}
				public List<User> getResultSet(ResultSet rs) throws SQLException {
					return null;
				}
			}, transactionSurport);
		return i;
	}

	public int addUserInBulk(List<User> list, boolean transactionSurport) {
		JdbcTemplate<User> login=new LoginDaoImpl();
		String sql=Constants.SQL_ADD_USER;
		int i=0;
		for(final User user:list){
			i=i+login.update(sql,
					new JdbcCallbackInterface<User>(){
						public void setParam(PreparedStatement ps) throws SQLException {
							ps.setString(1, user.getUserName());
							ps.setString(2, user.getPassword());
							ps.setString(3, user.getIdentity());
						}
						public List<User> getResultSet(ResultSet rs) throws SQLException {
							return null;
						}
					}, transactionSurport);
		}
		return i;
	}

	public int deleteUserByName(String userName, boolean transactionSurport) {
		JdbcTemplate<User> login=new LoginDaoImpl();
		final String name=userName;
		String sql=Constants.SQL_ADD_USER;
		int i=login.update(sql,
			new JdbcCallbackInterface<User>(){
				public void setParam(PreparedStatement ps) throws SQLException {
					ps.setString(1, name);
				}
				public List<User> getResultSet(ResultSet rs) throws SQLException {
					return null;
				}
			}, transactionSurport);
		return i;
	}
	
}
