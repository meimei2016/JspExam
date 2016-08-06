package com.hand.myWeb.service;

import java.util.List;

import com.hand.myWeb.bean.mybean.User;

public interface LoginServiceInterface {
	
	User getUser(String userName,boolean transactionSurport);
	String getTipMessage(String userName,String password,boolean transactionSurport);
	boolean userInfoCheck(String userName,String password,boolean transactionSurport);
	List<User> queryAllUser(boolean transactionSurport);
	int modifyUserInfo(User user,boolean transactionSurport);
	int addUser(User user,boolean transactionSurport);
	int addUserInBulk(List<User> list,boolean transactionSurport);
	int deleteUserByName(String userName,boolean transactionSurport );

}
