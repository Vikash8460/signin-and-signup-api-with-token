package com.npadmin.api.dtos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserResponse {
	
	private Date timestamp;
	private int status;
	private String message;
//	private User registeredUser;
	
	private String encryptedData;
	
	public UserResponse(Date timestamp, int status, String message, String encryptedData) {
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
		this.encryptedData = encryptedData;
		//this.registeredUser = registeredUser;
	}

	public String getTimestamp() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(timestamp);
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEncryptedData() {
		return encryptedData;
	}

	public void setEncryptedData(String encryptedData) {
		this.encryptedData = encryptedData;
	}

	
	
	
//	public User getRegisteredUser() {
//		return registeredUser;
//	}
//
//	public void setRegisteredUser(User registeredUser) {
//		this.registeredUser = registeredUser;
//	}
	
}



