package com.hand.myWeb.jdbc.dao;

import java.util.List;

import com.hand.myWeb.bean.mybean.User;

public interface LoginDaoInterface {
	User getUser(String userName,boolean transactionSurport);
	List<User> queryAllUser(boolean transactionSurport);
	int modifyUserInfo(User user,boolean transactionSurport);
	int addUser(User user,boolean transactionSurport);
	int addUserInBulk(List<User> list,boolean transactionSurport);
	int deleteUserByName(String userName,boolean transactionSurport );
}
