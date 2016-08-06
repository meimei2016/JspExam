package com.hand.myWeb.jdbc.exception;

public class AbnormaItem extends Exception {
	private static final long serialVersionUID = 6453605281964119399L;
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public AbnormaItem(String message){
		this.message=message;		
	}
	public AbnormaItem(){}
}
