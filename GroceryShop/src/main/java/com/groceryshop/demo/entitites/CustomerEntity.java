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
	private String customerId;
	private String customerName;
	private String phoneNumber;
	private String country;
	private String state;
	private String district;
	private String pincode;
	private String address;
	
	@OneToOne(targetEntity=UserEntity.class, cascade=CascadeType.ALL)
	private UserEntity userEntity;
	
	
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	public CustomerEntity(String customerId, String customerName, String phoneNumber,
			String country, String state, String district, String pincode, String address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		
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
		return "CustomerEntity [custoemerId=" + customerId + ", customerName=" + customerName 
				 + ", phoneNumber=" + phoneNumber + ", country=" + country + ", state="
				+ state + ", district=" + district + ", pincode=" + pincode + ", address=" + address + "]";
	}
	
	
	
}
