package com.groceryshop.demo.entitites;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

//localhost:8020/addCustomer?id=5&country=ind&customerName=raj&district=hyd&phoneNumber=9876543210&pincode=500078&state=ts&id=4&createdBy=admin&createdDateTime=2020-10-11 16:22:01&modifiedBy=admin&modifiedDateTime=2020-10-11 16:22:01&password=abc&roleId=1&userId=15
//{
//    "id": 5,
//    "customerName": "raj",
//    "phoneNumber": "9876543210",
//    "country": "ind",
//    "state": "ts",
//    "district": "hyd",
//    "pincode": "500078",
//    "address": null,
//    "userEntity": {
//        "id":4,
//        "createdBy":"admin",
//        "createdDateTime":"2020-10-11 16:22:01",
//        "modifiedBy":"admin",
//        "modifiedDateTime":"2020-10-11 16:22:01",
//        "password":"abc",
//        "roleId":1,
//        "userId":15

    
@Entity
public class CustomerEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String customerName;
	private String phoneNumber;
	private String country;
	private String state;
	private String district;
	private String pincode;
	private String address;
	
	
	@OneToOne(targetEntity=UserEntity.class, cascade=CascadeType.ALL)
	private UserEntity userEntity;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	 
	public CustomerEntity(Long id, String customerName, String phoneNumber, String country, String state, String district, String pincode, String address, UserEntity userEntity) {
        super();
        this.id = id;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.state = state;
        this.district = district;
        this.pincode = pincode;
        this.address = address;
        this.userEntity = userEntity;
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
	
	public CustomerEntity() {
		super();
	
	}
	
	public UserEntity getUserEntity() {
		return userEntity;
	}
	
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
    @Override
    public String toString() {
        return "CustomerEntity [id=" + id + ", customerName=" + customerName + ", phoneNumber=" + phoneNumber + ", country=" + country + ", state=" + state + ", district="
                + district + ", pincode=" + pincode + ", address=" + address + ", userEntity=" + userEntity + "]";
    }
	
	
	
}
