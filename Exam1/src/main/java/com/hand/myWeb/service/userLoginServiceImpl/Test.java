package com.hand.myWeb.service.userLoginServiceImpl;

import com.hand.myWeb.bean.mybean.User;
import com.hand.myWeb.jdbc.dao.LoginDaoInterface;
import com.hand.myWeb.jdbc.dao.userLoginDaoImpl.LoginDaoImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginDaoInterface loginDao=new LoginDaoImpl();
		User user=loginDao.getUser("Jack", false);
		System.out.println(user.getUserId());
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		System.out.println(user.getIdentity());
		String a="";
		System.out.println(a.length());

	}
}
