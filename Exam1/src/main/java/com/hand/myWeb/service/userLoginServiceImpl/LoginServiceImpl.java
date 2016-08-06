package com.hand.myWeb.service.userLoginServiceImpl;

import java.util.List;

import com.hand.myWeb.bean.mybean.User;
import com.hand.myWeb.common.Constants;
import com.hand.myWeb.jdbc.dao.LoginDaoInterface;
import com.hand.myWeb.jdbc.dao.userLoginDaoImpl.LoginDaoImpl;
import com.hand.myWeb.service.LoginServiceInterface;

public class LoginServiceImpl implements LoginServiceInterface{
	String tipMessage=Constants.NULL;
	public boolean userInfoCheck(String userName,String password,boolean transactionSurport){		
		boolean result=false;
		if(userName.isEmpty()&&password.isEmpty()){
			tipMessage=Constants.TIP_MESSAGE_USER_USERNAME_PASSWORD_NULL;
			return result;
		}else{
			if(userName.isEmpty()){
				tipMessage=Constants.TIP_MESSAGE_USER_USERNAME_NULL;
				return result;
			}else if(password.isEmpty()){
				tipMessage=Constants.TIP_MESSAGE_USER_PASSWORD_NULL;
				return result;
			}else{
				User user=getUser(userName,transactionSurport);
				if(user==null){
					tipMessage=Constants.TIP_MESSAGE_USER_NOT_EXIST;
					return result;
				}else{
					if(password.equals(user.getPassword())&&userName.equals(user.getUserName())){
						result=true;					
					}
				}
				return result;
			}
		}		
	}
	public String getTipMessage(String userName,String password,boolean transactionSurport){
		
		boolean b= userInfoCheck(userName,password,transactionSurport);
		if(b){
			return "";
		}else{
			if(!tipMessage.isEmpty()){
				return tipMessage;
			}else{
				return Constants.TIP_MESSAGE_USER_INFO_WRONG;
			}			
		}
		/*if(user==null){
			tipMessage="This user don't register so far.";
		}*/		
	}
	
	public User getUser(String userName,boolean transactionSurport){
		LoginDaoInterface loginDao=new LoginDaoImpl();
		User user=loginDao.getUser(userName,transactionSurport);
		return user;
	}
	public List<User> queryAllUser(boolean transactionSurport) {
		LoginDaoInterface loginDao=new LoginDaoImpl();
		List<User> list=loginDao.queryAllUser(transactionSurport);
		return list;
	}
	public int modifyUserInfo(User user, boolean transactionSurport) {
		LoginDaoInterface loginDao=new LoginDaoImpl();
		int result=loginDao.modifyUserInfo(user, transactionSurport);
		return result;
	}
	public int addUser(User user, boolean transactionSurport) {
		LoginDaoInterface loginDao=new LoginDaoImpl();
		int result=loginDao.addUser(user, transactionSurport);
		return result;
	}
	public int addUserInBulk(List<User> list, boolean transactionSurport) {
		LoginDaoInterface loginDao=new LoginDaoImpl();
		int result=loginDao.addUserInBulk(list, transactionSurport);
		return result;
	}
	public int deleteUserByName(String userName, boolean transactionSurport) {
		LoginDaoInterface loginDao=new LoginDaoImpl();
		int result=loginDao.deleteUserByName(userName, transactionSurport);
		return result;
	}
}
