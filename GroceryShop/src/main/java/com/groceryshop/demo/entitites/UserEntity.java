package com.groceryshop.demo.entitites;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class UserEntity extends BaseEntity {


	private String loginId;
	private String password;
	private String emailId;
	private long roleId;

	
	public UserEntity(String loginId, String password, String emailId, long roleId) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.emailId = emailId;
		this.roleId = roleId;
	}

	public UserEntity() {
		super();
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
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

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
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
	
	public UserEntity(String createdBy, String modifiedBy, Timestamp createdDateTime, Timestamp modifiedDateTime,String loginId, String password, String emailId, long roleId) {
		super(createdBy, modifiedBy, createdDateTime, modifiedDateTime);
		this.loginId = loginId;
		this.password = password;
		this.emailId = emailId;
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserEntity [loginId=" + loginId + ", password=" + password + ", emailId=" + emailId + ", roleId="
				+ roleId + ", id=" + id + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy
				+ ", createdDateTime=" + createdDateTime + ", modifiedDateTime=" + modifiedDateTime + "]";
	}

	
	
}
