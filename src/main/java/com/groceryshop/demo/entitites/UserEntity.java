package com.groceryshop.demo.entitites;

import java.sql.Timestamp;

import javax.persistence.Entity;

@Entity
public class UserEntity extends BaseEntity {


	private int userId;
	private String password;
	private long roleId;

	
	public UserEntity() {
		super();
	} 
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	public UserEntity(String createdBy, String modifiedBy, Timestamp createdDateTime, Timestamp modifiedDateTime,int userId, String password, String emailId, long roleId) {
		super(createdBy, modifiedBy, createdDateTime, modifiedDateTime);
		this.userId = userId;
		this.password = password;
		
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", password=" + password + ", roleId="
				+ roleId + ", id=" + id + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy
				+ ", createdDateTime=" + createdDateTime + ", modifiedDateTime=" + modifiedDateTime + "]";
	}

	
	
}
