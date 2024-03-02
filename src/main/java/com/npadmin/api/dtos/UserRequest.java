package com.npadmin.api.dtos;

public class UserRequest {

	private String userId;

	private String password;

	private String token;

	private String email;

	private String mobile;

	public UserRequest(String userId, String password, String email, String mobile) {
		super();
		this.userId = userId;
		this.password = password;

		this.email = email;
		this.mobile = mobile;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
