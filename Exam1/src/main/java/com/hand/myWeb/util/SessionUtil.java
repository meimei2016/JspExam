package com.hand.myWeb.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class SessionUtil {
	private Map<String,HttpSession> map=new HashMap<String,HttpSession>();
	private static HttpSession session;

	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		
		if(session!=null){
			this.session = session;
		}
	}
	public void addSession(String name,HttpSession session){
		map.put(name, session);
	}
	
	public HttpSession getSession(String key){	
		return map.get(key);
	}
}
