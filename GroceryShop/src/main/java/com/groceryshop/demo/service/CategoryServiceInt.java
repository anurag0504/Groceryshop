package com.groceryshop.demo.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import com.groceryshop.demo.entitites.CategoryEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;

public interface CategoryServiceInt {

	public long add(CategoryEntity bean) throws DuplicateRecordException;
	
	public CategoryEntity update(CategoryEntity bean) throws DuplicateRecordException;
	
	public boolean delete(CategoryEntity bean);
	
	public CategoryEntity findByCategoryname(String name);
	
	public CategoryEntity findByCategoryId(Integer id);

	public List<CategoryEntity> search(CategoryEntity bean, long pageNo, int pageSize);
	
	public List<CategoryEntity> search(CategoryEntity bean);
	
	public Blob getImageById(long id) throws SerialException, SQLException;
}
