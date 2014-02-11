package com.io;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;
 
@Entity
@Table(name="COMPANY")
public class Company implements Serializable{
	
	private static final long serialVersionUID = -8767337896773261247L;
  	private Long id;
	private String companyName;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String phoneNo;
	private String mobileNo;
	private String email;
	private String website;
 	private String gstNo;
	private String cstNo;
    private Status status;	   
	//private Date createdOn;
 	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	public Long getId() {
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
	/*@Transient
	public String getFullAddress() {
		StringBuffer temp = new StringBuffer();
		temp.append(!StringUtils.isEmpty(addressLine1)?addressLine1:StringUtils.EMPTY);
		temp.append(",").append(!StringUtils.isEmpty(addressLine2)?addressLine2:StringUtils.EMPTY);
		temp.append(",").append(!StringUtils.isEmpty(city)?city:StringUtils.EMPTY);
		temp.append(",").append(!StringUtils.isEmpty(state)?state:StringUtils.EMPTY);
		temp.append(",").append(!StringUtils.isEmpty(country)?state:StringUtils.EMPTY);
		return temp.toString();
	}
	 */
	 
	@Column(name="gstNo")
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	@Column(name="cstNo")
	public String getCstNo() {
		return cstNo;
	}
	public void setCstNo(String cstNo) {
		this.cstNo = cstNo;
	}   
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="companyName")
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@ManyToOne
	@JoinColumn(name="status")
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	/*
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}*/
	@Override
	public String toString() {
		return "Company [id=" + id + ", companyName=" + companyName
				+ ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", phoneNo=" + phoneNo
				+ ", mobileNo=" + mobileNo + ", email=" + email + ", website="
				+ website + ", gstNo=" + gstNo + ", cstNo=" + cstNo
				+ ", status=" +  ", createdOn="    + "]";
	}
 	
	
	 
}
