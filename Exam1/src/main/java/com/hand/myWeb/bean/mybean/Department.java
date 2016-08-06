package com.hand.myWeb.bean.mybean;

public class Department {
	private int dedpartmentId;
	private int managerId;
	private int locationId;
	private String dedpartmentName;
	public int getDedpartmentId() {
		return dedpartmentId;
	}
	public void setDedpartmentId(int dedpartmentId) {
		this.dedpartmentId = dedpartmentId;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getDedpartmentName() {
		return dedpartmentName;
	}
	public void setDedpartmentName(String dedpartmentName) {
		this.dedpartmentName = dedpartmentName;
	}
	
	public Department(){}
	public Department(int deptId,String deptName,int locationId,int managerId){
		this.dedpartmentId=deptId;
		this.dedpartmentName=deptName;
		this.locationId=locationId;
		this.managerId=managerId;	
	}
}

