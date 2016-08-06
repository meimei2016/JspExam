package com.hand.myWeb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.myWeb.bean.Film;
import com.hand.myWeb.bean.Language;
import com.hand.myWeb.service.FilmsManageService;
import com.hand.myWeb.service.LanguageManageService;

public class AddFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddFilmServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Language> languageList=new LanguageManageService().getAllLanguage(false);
		request.setAttribute("languageList", languageList);
		request.getRequestDispatcher("addFilm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		String language=request.getParameter("language");
		String description=request.getParameter("description");
		Film film=new Film(title,description,language);
		boolean b=!title.isEmpty()&&!language.isEmpty()&&!description.isEmpty();
		int i=0;
		String tipMessage="Add Fail";
		if(b){
			i=new FilmsManageService().addFilm(film, false);
		}
		if(i>0){
			response.sendRedirect("showFilm");
		}
		request.setAttribute("tipMessage", tipMessage);
		request.getRequestDispatcher("resultTip.jsp").forward(request, response);
	}

}
