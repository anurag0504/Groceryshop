package com.groceryshop.demo.entitites;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class OrderEntity extends BaseEntity {

    
    private long productId;
    private String productName;
    private String name;
    private String emailId;
    private String mobileNo;
    private String country;
    private String state;
    private String district;
    private String pincode;
    private String address;
    private long userId;
    private String quantity;
    private String anmount;
    private Date date;

    @OneToOne(targetEntity=UserEntity.class, cascade=CascadeType.ALL)
    private UserEntity userEntity;
    

    public OrderEntity( String createdBy, String modifiedBy, Timestamp createdDateTime,
            Timestamp modifiedDateTime,long productId, String productName, String name, String emailId, String mobileNo,
            String country, String state, String district, String pincode, String address, long userId, String quantity,
            String anmount, Date date) {
        super(createdBy,modifiedBy,createdDateTime,modifiedDateTime);
        this.productId = productId;
        this.productName = productName;
        this.name = name;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
        this.country = country; 
        this.state = state;
        this.district = district;
        this.pincode = pincode;
        this.address = address;
        this.userId = userId;
        this.quantity = quantity;
        this.anmount = anmount;
        this.date = date;
    }

   

    public OrderEntity() {
        super();
        // TODO Auto-generated constructor stub
    }

    

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAnmount() {
        return anmount;
    }

    public void setAnmount(String anmount) {
        this.anmount = anmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "OrderEntity [productId=" + productId + ", productName=" + productName + ", name=" + name
                + ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", country=" + country + ", state=" + state
                + ", district=" + district + ", pincode=" + pincode + ", address=" + address + ", userId=" + userId
                + ", quantity=" + quantity + ", anmount=" + anmount + ", date=" + date + "]";
    }

    @Override
    public String getKey() {
        // TODO Auto-generated method stub
        return String.valueOf(id);
    }

    @Override
    public String getValue() {
        // TODO Auto-generated method stub
        return null;
    }

    
    }
  

  
