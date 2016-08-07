package com.hand.myWeb.service;

import java.util.List;

import com.hand.myWeb.bean.Film;
import com.hand.myWeb.jdbc.dao.FilmsManageDao;

public class FilmsManageService {
	public List<Film>getAllFilm(boolean transactionSurport){
		List<Film> list=new FilmsManageDao().getAllFilm(transactionSurport);
		return list;
	}
	
	public int addFilm(Film f,boolean transactionSurport){
		int result=new FilmsManageDao().addFilm(f, transactionSurport);
		return result;
	}
	
	public int deleteFilm(int filmId,boolean transactionSurport){
		int result=new FilmsManageDao().deleteFilmRefer(filmId, transactionSurport);
		return result;
	}
}
