package com.hand.myWeb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.hand.myWeb.common.Constants;
import com.hand.myWeb.service.CustomerLoginService;
import com.hand.myWeb.service.customerLoginServiceImpl.CustomerLoginServiceImpl;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName=request.getParameter(Constants.TABLE_USERS_USERNAME);
		CustomerLoginService login=new CustomerLoginServiceImpl();		
		int count=login.getUserName(userName, false);
		if(count>0){
			HttpSession session =request.getSession();
			session.setAttribute(Constants.SESSION_USER, userName);
			String tipMessage=Constants.TIP_MESSAGE_LOGIN_SUCCESS;
			request.setAttribute(Constants.TIP_MESSAGE_NAME, tipMessage);
			request.getRequestDispatcher(Constants.PAGE_RESULT_TIP).forward(request, response);
		}else{
			response.sendRedirect(Constants.PAGE_LOGIN);
		}		
	}
}
