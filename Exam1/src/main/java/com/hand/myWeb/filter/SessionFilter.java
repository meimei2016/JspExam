package com.hand.myWeb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.hand.myWeb.common.Constants;

public class SessionFilter implements Filter {
	private String notLoginPages[];
 
    public SessionFilter() {}
    
	public void destroy() {}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest request = (HttpServletRequest) servletRequest;  
		 HttpServletResponse response = (HttpServletResponse) servletResponse; 
		 String uri = request.getServletPath();
		 uri = uri.substring(uri.lastIndexOf("/")+1);
		 boolean pass=false;
		 for(String str:Constants.STATIC_SOURCE){//过滤静态资源
			 if(uri.endsWith(str)){
				 pass=true;
				 break;
			 }
		 }
		 for(String str:notLoginPages){//过滤不用登陆的即可访问的页面
			 if(uri.equals(str.trim())){				 
				 pass=true;
				 break;
			 }
		 }
		 if(pass){
			 chain.doFilter(request, response);
		 }else{
			//判断是否有session，即用户是否已登录状态；
			//SessionUtil sessionUtil=new SessionUtil();
			 //sessionUtil.getSession(Constants.SESSION_USER)
			HttpSession session = request.getSession();
			String name = (String) session.getAttribute(Constants.SESSION_USER);  
			if(name==null) {  
			    response.sendRedirect(Constants.PAGE_LOGIN);  
			} else {
				/*//可将servlet中的session信息在此处添加
				HttpSession session = request.getSession();
				session.setAttribute(Constants.SESSION_USER, user);
				sessionUtil.addSession(Constants.SESSION_USER, session);*/
				chain.doFilter(request, response);  
			}  
		}     		
	}	
	public void init(FilterConfig filterConfig) throws ServletException {
		String notLogin=filterConfig.getInitParameter(Constants.DONOT_LOHIN);
		notLoginPages=notLogin.split(Constants.DONOT_LOHIN_SEPERATOR);
	}

}
