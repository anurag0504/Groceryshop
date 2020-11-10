package com.groceryshop.demo.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groceryshop.demo.entitites.CategoryEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;
import com.groceryshop.demo.repository.CategoryRepository;

@Service
public class CategoryServiceImp {
@Autowired
 public CategoryRepository categoryRepository;

	public long add(CategoryEntity bean) throws DuplicateRecordException
	{
		return 0;
		
	}

	public void update(CategoryEntity bean) throws DuplicateRecordException
	{
		
	}

	public void delete(CategoryEntity bean)
	{
		
	}
	public CategoryEntity findByName(String name) {
		return null;
		
	}

	public CategoryEntity findByCode(String id)
	{
		return null;
		
	}

	public List<CategoryEntity> search(CategoryEntity bean, long pageNo, int pageSize){
		return null;
		
	}
	
	public List<CategoryEntity> search(CategoryEntity bean)
	{
		return null;
		
	}

	public Blob getImageById(long id) throws SerialException, SQLException
	{
		return null;
		
	}
}
