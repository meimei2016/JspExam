package com.hand.myWeb.bean;

public class Film {
	private String description;
	private String title;
	private int film_id;
	private String language;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Film( int film_id,String title,String description, String language) {
		super();
		this.description = description;
		this.title = title;
		this.film_id = film_id;
		this.language = language;
	}
	public Film( String title,String description, String language) {
		super();
		this.description = description;
		this.title = title;
		this.language = language;
	}
}
