package com.hand.myWeb.common;

public  class Constants {
	public static String SESSION_USER="userName";
	public static String TIP_MESSAGE_USER_LOGIN="tipMessage";
	public static String NULL="";
	
	public static String PAGE_LOGIN="login.jsp";
	
	public static String TIP_MESSAGE_USER_NOT_EXIST="This user is not exist.";
	public static String TIP_MESSAGE_USER_INFO_WRONG="UserName or password is wrong.";
	public static String TIP_MESSAGE_USER_INFO_RIGHT="User's information is right.";
	public static String TIP_MESSAGE_USER_USERNAME_NULL="UserName is required";
	public static String TIP_MESSAGE_USER_PASSWORD_NULL="Password is required";
	public static String TIP_MESSAGE_USER_USERNAME_PASSWORD_NULL="Both userName and password are required";
	
	public static String PROPERTY_DRIVER="driver";
	public static String PROPERTY_DRIVER_URL="url";
	public static String PROPERTY_FILE_URL="config/jdbcConn.properties";
	
	public static String STATIC_SOURCE[]={"png","jpg","js","css"};
	public static String DONOT_LOHIN="notLoginPage";
	public static String DONOT_LOHIN_SEPERATOR=",";
	public static String ENCODING="UTF-8";
	public static String ENCODING_PARAM_NAME="encoding";
	
	public static String TABLE_USERS_USERNAME="userName";
	public static String TABLE_USERS_USERID="userId";
	public static String TABLE_USERS_PASSWORD="password";
	public static String TABLE_USERS_IDENTITY="identity";
	
	public static String SQL_GET_USER_BY_NAME="select userId,userName,password,identity from users where userName=?;";
	public static String SQL_GET_ALL_USER="select userId,userName,password,identity from users;";
	public static String SQL_ADD_USER="insert into users (userName,password,identity) values(?,?,?);";
	public static String SQL_DELETE_USER_BY_NAME="delete from users where userName=?;";
	public static String SQL_MODIFY_USER_BY_NAME="update users set userName=?,password=?,identity=? where userName=?;";
	
	public static String TIP_MESSAGE_COLLECTION_WRONG="Fail to get connection";
	public static String TIP_MESSAGE_SQL_WRONG="There are some problem in sql";		
	
}
