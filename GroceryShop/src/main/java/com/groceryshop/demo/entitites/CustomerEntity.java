package com.groceryshop.demo.entitites;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CustomerEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String loginId;
	private String customerName;
	private String emailId;
	private String password;
	private String phoneNumber;
	private String country;
	private String state;
	private String district;
	private String pincode;
	private String address;
	
	@OneToOne(targetEntity=UserEntity.class, cascade=CascadeType.ALL)
	private UserEntity userEntity;
	
	
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public CustomerEntity(String loginId, String customerName, String emailId, String password, String phoneNumber,
			String country, String state, String district, String pincode, String address) {
		super();
		this.loginId = loginId;
		this.customerName = customerName;
		this.emailId = emailId;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.country = country;
		this.state = state;
		this.district = district;
		this.pincode = pincode;
		this.address = address;
	}
	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CustomerEntity [loginId=" + loginId + ", customerName=" + customerName + ", emailId=" + emailId
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + ", country=" + country + ", state="
				+ state + ", district=" + district + ", pincode=" + pincode + ", address=" + address + "]";
	}
	
	
	
}
