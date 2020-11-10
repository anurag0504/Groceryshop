package com.cg.gsm.app.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.gsm.app.entities.ProductEntity;
import com.cg.gsm.app.service.ProductServiceImplements;

@RestController
public class ProductController {
	
	@Autowired
	ProductServiceImplements service;
	
	@RequestMapping("/")
	public String check() {
		return "home";
	}

	@PostMapping("/add")
	public ResponseEntity<ProductEntity> add(ProductEntity bean)
	{
		Long id=service.add(bean);
		return new ResponseEntity<ProductEntity>(service.findByPk(id),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ProductEntity> update(ProductEntity bean)
	{
		return new ResponseEntity<ProductEntity>(service.update(bean),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<ProductEntity> delete(ProductEntity bean)
	{
		service.delete(bean);
		return new ResponseEntity<ProductEntity>(service.findByPk(bean.getId()),HttpStatus.OK);
	}
	
	@GetMapping("/findByName/{name}")
	public List<ProductEntity> findByName(@PathVariable String name)
	{
		return service.findByName(name);
	}
	
	@GetMapping("/findByProductCode/{code}")
	public List<ProductEntity> findByProductCode(@PathVariable String code)
	{
		System.out.println(code);
		return service.findByProductCode(code);
	}
	
	@GetMapping("/findByPk/{id}")
	public ResponseEntity<ProductEntity> findByCode(@PathVariable Long id)
	{
		return new ResponseEntity<ProductEntity>(service.findByPk(id),HttpStatus.OK);
	}
	
	@GetMapping("/search/{bean}")
	public List<ProductEntity> search(@PathVariable ProductEntity bean)
	{
		return service.search(bean);
	}
	
	@GetMapping("/image/{id}")
	public Blob getImageById(@PathVariable Long id) throws SerialException, SQLException
	{
		return service.getImageById(id);
	}
}
