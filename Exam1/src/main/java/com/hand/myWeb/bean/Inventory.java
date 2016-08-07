package com.hand.myWeb.bean;

import java.util.Date;

public class Inventory {
	private int inventory_id;
	private int film_id;
	private int store_id;
	private Date last_update;
	public int getInventory_id() {
		return inventory_id;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public void setInventory_id(int inventory_id) {
		this.inventory_id = inventory_id;
	}
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
	public Date getLast_update() {
		return last_update;
	}
	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
	public Inventory(int inventory_id, int film_id, int store_id,Date last_update) {
		super();
		this.inventory_id = inventory_id;
		this.film_id = film_id;
		this.store_id = store_id;
		this.last_update=last_update;
	}
}
