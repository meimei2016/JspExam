package com.hand.myWeb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.myWeb.bean.Film;
import com.hand.myWeb.common.Constants;
import com.hand.myWeb.service.FilmsManageService;

public class DashBoradServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DashBoradServlert() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Film> filmList=new FilmsManageService().getAllFilm(false);
		request.setAttribute(Constants.FILM_LIST, filmList);
		request.getRequestDispatcher(Constants.PAGE_DELETE_FILM).forward(request, response);
	}

}
