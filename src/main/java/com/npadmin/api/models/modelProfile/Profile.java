package com.npadmin.api.models.modelProfile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "profile")
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String surname;
	private String mobilenumber;
	private String postcode;
	private String enailid;
	private String destiging;
	private int experince;
	private String country;
	private String state;
	private String addressline1;
	private String addressline2;
	private String skills;
	private String area;
	private String eduction;

	public Profile() {
		super();
	}

	public Profile(int id, String name, String surname, String mobilenumber, String postcode, String enailid,
			String destiging, int experince, String country, String state, String addressline1, String addressline2,
			String skills, String area, String eduction) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.mobilenumber = mobilenumber;
		this.postcode = postcode;
		this.enailid = enailid;
		this.destiging = destiging;
		this.experince = experince;
		this.country = country;
		this.state = state;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.skills = skills;
		this.area = area;
		this.eduction = eduction;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getEnailid() {
		return enailid;
	}

	public void setEnailid(String enailid) {
		this.enailid = enailid;
	}

	public String getDestiging() {
		return destiging;
	}

	public void setDestiging(String destiging) {
		this.destiging = destiging;
	}

	public int getExperince() {
		return experince;
	}

	public void setExperince(int experince) {
		this.experince = experince;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddressline1() {
		return addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getEduction() {
		return eduction;
	}

	public void setEduction(String eduction) {
		this.eduction = eduction;
	}

}
