package com.groceryshop.demo.controller;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.groceryshop.demo.entitites.CategoryEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;

import com.groceryshop.demo.service.CategoryServiceImp;

@RestController
public class CategoryController {

	@Autowired
	public CategoryServiceImp categoryServiceImp;
	
	@PostMapping(path="/addCategory")
	public ResponseEntity<CategoryEntity> add(@RequestBody CategoryEntity bean) throws DuplicateRecordException
	{
		
		long id=categoryServiceImp.add(bean);
		return new ResponseEntity<CategoryEntity>(HttpStatus.OK);
	}
	
	@PutMapping(path="/updateCategory")
	public ResponseEntity<CategoryEntity> update(@RequestBody CategoryEntity bean) throws DuplicateRecordException
	{
		long id=categoryServiceImp.add(bean);
		return new ResponseEntity<CategoryEntity>(HttpStatus.OK);
	}
	
	@DeleteMapping(path="/delete")
	public ResponseEntity<CategoryEntity> delete(@RequestBody CategoryEntity bean)
	{
		boolean delete=categoryServiceImp.delete(bean);
		if(delete)
		{
			return new ResponseEntity<CategoryEntity>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<CategoryEntity>(bean,HttpStatus.OK);
		}
	}
	
	@GetMapping(path="/categoryname/{name}")
	public ResponseEntity<CategoryEntity> findByName(@PathVariable String name)
	{
		CategoryEntity category= categoryServiceImp.findByCategoryname(name);
		return new ResponseEntity<CategoryEntity>(category,HttpStatus.OK);	
	}
	
	@GetMapping(path="/categorycode/{id}")
	public ResponseEntity<CategoryEntity> findByCategoryId(@PathVariable Integer id)
	{
		CategoryEntity category= categoryServiceImp.findByCategoryId(id);
		return new ResponseEntity<CategoryEntity>(category,HttpStatus.OK);	
	}

	//public List<CategoryEntity> search(CategoryEntity bean, long pageNo, int pageSize);
	
	@GetMapping(path="/category")
	public List<CategoryEntity> search(@RequestBody CategoryEntity bean)
	{
		List<CategoryEntity> category=categoryServiceImp.search(bean);
		return category;
		
	}
	
	//public Blob getImageById(long id) throws SerialException, SQLException;
}
