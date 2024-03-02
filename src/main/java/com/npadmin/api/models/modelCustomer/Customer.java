package com.npadmin.api.models.modelCustomer;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String password;
	private String confirmpassword;
	private String firstname;
	private String lastname;
	private String moblieno;
	private String city;
	private String state;
	private String pincode;
	private String text;
	private Date date;
	
	public Customer() {
		super();
	}

	public Customer(int id, String email, String password, String confirmpassword, String firstname, String lastname,
			String moblieno, String city, String state, String pincode, String text, Date date) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.firstname = firstname;
		this.lastname = lastname;
		this.moblieno = moblieno;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.text = text;
		this.date = date;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMoblieno() {
		return moblieno;
	}

	public void setMoblieno(String moblieno) {
		this.moblieno = moblieno;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
