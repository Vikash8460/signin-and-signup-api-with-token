package com.npadmin.api.models.modelUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="loginuser")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	 @Column(nullable = false,unique =true)
	private String userId;
	 @Column(nullable = false)
	private String password;
	 
	@Column(nullable = false)
	private String email;
	
    @Column(nullable = true)
	private String mobile;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String userId, String password, String email, String mobile) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
    
    

}
