package com.hand.myWeb.service;

import java.util.List;

import com.hand.myWeb.bean.Language;
import com.hand.myWeb.jdbc.dao.LanguageManageDao;

public class LanguageManageService {
	public List<Language> getAllLanguage(boolean transactionSurport){
		List<Language> list=new LanguageManageDao().getAllLanguage(transactionSurport);
		return list;
	}

}
