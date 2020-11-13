package com.groceryshop.demo.entitites;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


@Entity
public class CategoryEntity extends BaseEntity{

 
	private int categoryId;
	private String categoryName;
	
	@OneToMany
	private Collection<ProductEntity> products;
	
	public int getCategoryId() {
	 	return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		return "CategoryEntity [categoryId=" + categoryId + ", categoryName=" + categoryName + ", id=" + id
				+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", createdDateTime=" + createdDateTime
				+ ", modifiedDateTime=" + modifiedDateTime + "]";
	}
	public CategoryEntity(String createdBy, String modifiedBy, Timestamp createdDateTime, Timestamp modifiedDateTime,int categoryId, String categoryName) {
		super(createdBy, modifiedBy, createdDateTime, modifiedDateTime);
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	public CategoryEntity() {
		super(); 
		// TODO Auto-generated constructor stub
	}
	
}
