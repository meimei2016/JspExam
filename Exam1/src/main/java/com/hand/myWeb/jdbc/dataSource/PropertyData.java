package com.hand.myWeb.jdbc.dataSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.hand.myWeb.common.Constants;

 final class PropertyData {
	static Map<String,String> getParam(){
		Map<String,String> map=new HashMap<String,String>();
		Properties property = new Properties();
		try {						 
			InputStream in =PropertyData.class.getClassLoader().getResourceAsStream(Constants.PROPERTY_FILE_URL);					      
			property.load(in);
			String driver=property.getProperty(Constants.PROPERTY_DRIVER).trim();
			String url=property.getProperty(Constants.PROPERTY_DRIVER_URL).trim();			
			String userName=property.getProperty(Constants.TABLE_USERS_USERNAME).trim();
			String password=property.getProperty(Constants.TABLE_USERS_PASSWORD).trim();			
			map.put(Constants.PROPERTY_DRIVER, driver);
			map.put(Constants.PROPERTY_DRIVER_URL, url);
			map.put(Constants.TABLE_USERS_USERNAME, userName);
			map.put(Constants.TABLE_USERS_PASSWORD, password);
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return map;		
	}
}
