package com.hand.myWeb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.myWeb.bean.Film;
import com.hand.myWeb.bean.Language;
import com.hand.myWeb.common.Constants;
import com.hand.myWeb.service.FilmsManageService;
import com.hand.myWeb.service.LanguageManageService;

public class AddFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddFilmServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Language> languageList=new LanguageManageService().getAllLanguage(false);
		request.setAttribute(Constants.LANGUAGE_LIST, languageList);
		request.getRequestDispatcher(Constants.PAGE_ADD_FILM).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter(Constants.TABLE_FILM_TITLE);
		String language=request.getParameter(Constants.TABLE_FILM_LANGUAGE);
		String description=request.getParameter(Constants.TABLE_FILM_DESCRIPTION);
		Film film=new Film(title,description,language);
		boolean b=!title.isEmpty()&&!language.isEmpty()&&!description.isEmpty();
		int i=0;
		String tipMessage=Constants.TIP_MESSAGE_ADD_FAIL;
		if(b){
			i=new FilmsManageService().addFilm(film, false);
		}
		if(i>0){
			response.sendRedirect(Constants.SERVLET_URL_PATTEN_SHOWFILM);
		}
		request.setAttribute(Constants.TIP_MESSAGE_NAME, tipMessage);
		request.getRequestDispatcher(Constants.PAGE_RESULT_TIP).forward(request, response);
	}

}
