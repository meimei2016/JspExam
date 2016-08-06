package com.hand.myWeb.bean;

public class Acto_info {
	
	private int actor_id;
	private String first_name;
	private String last_name;
	private String film_info;
	public int getActor_id() {
		return actor_id;
	}
	public void setActor_id(int actor_id) {
		this.actor_id = actor_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFilm_info() {
		return film_info;
	}
	public void setFilm_info(String film_info) {
		this.film_info = film_info;
	}
	public Acto_info(int actor_id, String first_name, String last_name,
			String film_info) {
		super();
		this.actor_id = actor_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.film_info = film_info;
	}
	
	public Acto_info(){}
	
}
