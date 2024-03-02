package com.npadmin.api.dtos;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.npadmin.api.models.modelUser.User;



public class UserResponse2 {
	private Date timestamp;
	private int status;
	private String message;
	private User encryptedData;

	public UserResponse2(Date timestamp, int status, String message, User decryptedData) {
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
		this.encryptedData = decryptedData;
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

	public User getEncryptedData() {
		return encryptedData;
	}

	public void setEncryptedData(User encryptedData) {
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
