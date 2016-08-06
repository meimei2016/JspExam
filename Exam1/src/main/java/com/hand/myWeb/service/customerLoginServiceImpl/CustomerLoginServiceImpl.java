package com.hand.myWeb.service.customerLoginServiceImpl;

import com.hand.myWeb.jdbc.dao.CustomerLoginDao;
import com.hand.myWeb.jdbc.dao.loginDaoImpl.CustomerLoginImpl;
import com.hand.myWeb.service.CustomerLoginService;

public class CustomerLoginServiceImpl implements CustomerLoginService{
	@Override
	public int getUserName(String userName, boolean transactionSurport) {
		CustomerLoginDao login=new CustomerLoginImpl();
		int count=login.getUserName(userName, transactionSurport);
		return count;
	}
	

}
