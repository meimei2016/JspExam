package com.hand.myWeb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		int filmId=new Integer(request.getParameter("filmId"));
		int result=new FilmsManageService().deleteFilm(filmId, false);
		if(result>0){
			response.sendRedirect("dashBorad");
		}else{
			String tipMessage="Fail to Delete";
			request.setAttribute("tipMessage", tipMessage);
			response.sendRedirect("resultTip.jsp");
		}
		
	}

}
