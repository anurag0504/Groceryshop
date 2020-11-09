package com.groceryshop.demo.entitites;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AdminEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String loginId;
	private String adminName;
	private String password;
	private String emailId;
	
	@OneToOne(targetEntity=UserEntity.class, cascade=CascadeType.ALL)
	private UserEntity userEntity;
	
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public AdminEntity(String loginId, String adminName, String password, String emailId) {
		super();
		this.loginId = loginId;
		this.adminName = adminName;
		this.password = password;
		this.emailId = emailId;
	}
	public AdminEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AdminEntity [loginId=" + loginId + ", adminName=" + adminName + ", password=" + password + ", emailId="
				+ emailId + "]";
	}
	
	
}
