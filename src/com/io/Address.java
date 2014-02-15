package com.io;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
 

@Component
@Entity
@Table(name="ADDRESS")
public class Address implements Serializable{
	
	//private static final long serialVersionUID = -8767337896773261247L;

  	private long id;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String phoneNo;
	private String mobileNo;
	private String email;
	private String website;
 
	@Id
	@GeneratedValue
	@Column(name="id")
	public long getId() {
		return id;
	}
	@Column(name="addressLine1") 
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	@Column(name="addressLine2")
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	@Column(name="city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name="country")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Column(name="phoneNo")
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Column(name="mobileNo")
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Column(name="state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="website")
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	 
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", phoneNo="
				+ phoneNo + ", mobileNo=" + mobileNo + ", email=" + email
				+ ", website=" + website + "]";
	} 
	
	 
}
