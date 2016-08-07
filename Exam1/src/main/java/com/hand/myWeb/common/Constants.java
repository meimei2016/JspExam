package com.hand.myWeb.common;

public  class Constants {
	public static String SESSION_USER="userName";
	public static String TIP_MESSAGE_NAME="tipMessage";
	public static String NULL="";
	public static String FILM_LIST="filmList";
	public static String LANGUAGE_LIST="languageList";
	
	public static String PAGE_LOGIN="login.jsp";
	public static String PAGE_RESULT_TIP="resultTip.jsp";
	public static String PAGE_SHOW_FILM="showFilm.jsp";
	public static String PAGE_DELETE_FILM="deleteFilm.jsp";
	public static String PAGE_ADD_FILM="addFilm.jsp";
	
	public static String SERVLET_URL_PATTEN_DASHBOARD="dashBoard";
	public static String SERVLET_URL_PATTEN_SHOWFILM="showFilm";
	
	public static String TIP_MESSAGE_USER_NOT_EXIST="This user is not exist.";
	public static String TIP_MESSAGE_USER_INFO_WRONG="UserName or password is wrong.";
	public static String TIP_MESSAGE_USER_INFO_RIGHT="User's information is right.";
	public static String TIP_MESSAGE_USER_USERNAME_NULL="UserName is required";
	public static String TIP_MESSAGE_USER_PASSWORD_NULL="Password is required";
	public static String TIP_MESSAGE_USER_USERNAME_PASSWORD_NULL="Both userName and password are required";
	public static String TIP_MESSAGE_DELTE_FAIL="Fail to Delete";
	public static String TIP_MESSAGE_LOGIN_SUCCESS="Login Success";
	public static String TIP_MESSAGE_ADD_FAIL="Add Fail";
	
	
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
	
	public static String TABLE_FILM_FILMID="film_id";
	public static String TABLE_FILM_TITLE="title";
	public static String TABLE_FILM_NAME="name";
	public static String TABLE_FILM_DESCRIPTION="description";
	
	public static String TABLE_FILM_LANGUAGE="language";
	
	public static String TABLE_LANGUAGE_LANGUAGEID="language_id";
	
	
	public static String TABLE_INVENTORY_INVENTORYID="inventory_id";
	public static String TABLE_INVENTORY_STOREID="store_id";
	public static String TABLE_INVENTORY_LASTUPDATE="last_update";
	
	public static String SQL_GET_USER_BY_NAME="select userId,userName,password,identity from users where userName=?;";
	public static String SQL_GET_ALL_USER="select userId,userName,password,identity from users;";
	public static String SQL_ADD_USER="insert into users (userName,password,identity) values(?,?,?);";
	public static String SQL_DELETE_USER_BY_NAME="delete from users where userName=?;";
	public static String SQL_MODIFY_USER_BY_NAME="update users set userName=?,password=?,identity=? where userName=?;";
	public static String[] SQL_DELETE_Film_REFER={
		"delete from film_actor where film_id=?",
		"delete from film_category where film_id=?",
		"delete from inventory where film_id=?",
		"delete from film where film_id=?"
		};
	public static String SQL_DELETE_RENTAL_BY_INVENTORYID="delete from rental where inventory_id=?";
	public static String SQL_SELECT_INVENTORY_BY_FILMID="select inventory_id,film_id, store_id,last_update from inventory where film_id=?";
	public static String SQL_INSERT_FILM="insert into film (title,description,language_id) values(?,?,?)";
	public static String SQL_SELECT_ALL_FILM="select f.film_id,title,description,l.name from film f, language l where f.language_id=l.language_id";
	public static String SQL_SELECT_CUSTOMER_BY_NAME="select count(customer_id) from customer where first_name=?";
	public static String SQL_SELECT_ALL_LANGUAGE="select * from language";
	public static String SQL_SELECT_LANGUAGE_BY_NAME="select * from language where name=?";
	
	public static String TIP_MESSAGE_COLLECTION_WRONG="Fail to get connection";
	public static String TIP_MESSAGE_SQL_WRONG="There are some problem in sql";		
	
}
