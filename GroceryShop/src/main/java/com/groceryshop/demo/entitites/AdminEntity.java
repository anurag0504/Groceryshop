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
	private int adminId;
	private String adminName;
	
	@OneToOne(targetEntity=UserEntity.class, cascade=CascadeType.ALL)
	private UserEntity userEntity;
	
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	public AdminEntity(int adminId, String adminName) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		
	}
	public AdminEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AdminEntity [adminId=" + adminId + ", adminName=" + adminName + "]";
	}
	
	
}
