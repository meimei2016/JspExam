package com.hand.myWeb.bean.mybean;

public class City {
	private int ID;
	private String Name;
	private String CountryCode;
	private String District;
	private int Population;
	
	public City(int ID,String name,String CountryCode,String District,int Population){
		this.CountryCode=CountryCode;
		this.ID=ID;
		this.Name=name;
		this.Population=Population;
		this.District=District;
	}
	public int getID() {
		return ID;
	}
	public void setID(int id) {
		ID = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(String countryCode) {
		this.CountryCode = countryCode;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public int getPopulation() {
		return Population;
	}
	public void setPopulation(int population) {
		Population = population;
	}
}

