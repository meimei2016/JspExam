package com.hand.myWeb.bean;

import java.util.Date;
//...................
public class Address {
	private int address_id;
	private String address;
	private String address2;
	private String district;
	private int ciry_id;
	private String postal_code;
	private String phone;	
	private Date last_update;
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getCiry_id() {
		return ciry_id;
	}
	public void setCiry_id(int ciry_id) {
		this.ciry_id = ciry_id;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getLast_update() {
		return last_update;
	}
	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
	public Address(String address, String address2, String district,
			int ciry_id, String postal_code, String phone, Date last_update) {
		super();
		this.address = address;
		this.address2 = address2;
		this.district = district;
		this.ciry_id = ciry_id;
		this.postal_code = postal_code;
		this.phone = phone;
		this.last_update = last_update;
	}
	
	
}
