package com.hand.myWeb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.myWeb.common.Constants;
import com.hand.myWeb.service.FilmsManageService;


public class DeleteFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteFilmServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int filmId=new Integer(request.getParameter(Constants.TABLE_FILM_FILMID));
		int result=new FilmsManageService().deleteFilm(filmId, false);
		if(result>0){
			response.sendRedirect(Constants.SERVLET_URL_PATTEN_DASHBOARD);
		}else{
			String tipMessage=Constants.TIP_MESSAGE_DELTE_FAIL;
			request.setAttribute(Constants.TIP_MESSAGE_NAME, tipMessage);
			response.sendRedirect(Constants.PAGE_RESULT_TIP);
		}
		
	}

}
