package com.groceryshop.demo.service;

import java.util.List;

import com.groceryshop.demo.entitites.CategoryEntity;

public interface CategoryServiceInt {

	public long addCategory(CategoryEntity bean);
	
	public CategoryEntity updateCategory(CategoryEntity bean);
	
	public boolean deleteCategory(CategoryEntity bean);
	
	public CategoryEntity findByCategoryname(String name);
	
	public CategoryEntity findByCategoryId(Integer id);

	//public List<CategoryEntity> search(String name, long pageNo, int pageSize);
	
	public List<CategoryEntity> search();
	
	//public Blob getImageById(long id) throws SerialException, SQLException;
}
