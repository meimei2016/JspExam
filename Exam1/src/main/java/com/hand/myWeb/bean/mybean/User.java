package com.hand.myWeb.bean.mybean;

public class User {
	private String userName;
	private String password;
	private int userId;
	private String identity;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
	public User(int userId,String userName, String password,String identity) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.identity = identity;
	}
	
	public User() {
		super();
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
