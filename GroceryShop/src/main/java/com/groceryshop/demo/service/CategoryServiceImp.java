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
public class CategoryServiceImp implements CategoryServiceInt {
@Autowired
 public CategoryRepository categoryRepository;

	public long add(CategoryEntity bean) throws DuplicateRecordException
	{
		CategoryEntity category=categoryRepository.save(bean);
		System.out.println(category);
		return category.getId();
		
	}

	public CategoryEntity update(CategoryEntity bean) throws DuplicateRecordException
	{
		CategoryEntity category=categoryRepository.save(bean);
		return category;
		
	}

	public boolean delete(CategoryEntity bean)
	{
		categoryRepository.delete(bean);
		if(categoryRepository.existsById(bean.getCategoryId()))
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	public CategoryEntity findByCategoryname(String name) {
		CategoryEntity category=categoryRepository.findByCategoryName(name);
		return category;
		
	}

	public CategoryEntity findByCategoryId(Integer id)
	{
		CategoryEntity category=categoryRepository.findByCategoryId(id);
		System.out.println(category);
		return category;
		
	}

	public List<CategoryEntity> search(CategoryEntity bean, long pageNo, int pageSize){
		return null;
		
	}
	
	public List<CategoryEntity> search(CategoryEntity bean)
	{
		return categoryRepository.findAll();
		
	}

	public Blob getImageById(long id) throws SerialException, SQLException
	{
		return null;
		
	}

	


	
}
