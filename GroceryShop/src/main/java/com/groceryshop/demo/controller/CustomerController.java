package com.groceryshop.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.groceryshop.demo.entitites.CategoryEntity;
import com.groceryshop.demo.entitites.CustomerEntity;
import com.groceryshop.demo.exception.DatabaseException;
import com.groceryshop.demo.exception.DuplicateRecordException;
import com.groceryshop.demo.exception.RecordNotFoundException;
import com.groceryshop.demo.repository.CustomerRepository;

import com.groceryshop.demo.service.CustomerServiceIntImp;

@RestController
public class CustomerController {

	@Autowired
	CustomerServiceIntImp service;
	
	 
	
	@PutMapping(path="/changePassword")
	public ResponseEntity<CustomerEntity> changePassword(@PathVariable Long id,@PathVariable String oldPassword,@PathVariable String newPassword) {
		boolean auth=service.changePassword(id, oldPassword, newPassword);
		if(auth)
		{
			CustomerEntity customer=service.findById(id);
			ResponseEntity<CustomerEntity> responseEntity =new ResponseEntity<CustomerEntity>(customer,HttpStatus.OK);
			return responseEntity;
		}
		else
		{
			throw new DatabaseException("Id or password incorrect");
		}
	}
	
	@PutMapping(path="/updateCustomer")
	public ResponseEntity<CustomerEntity> update(@RequestBody CustomerEntity bean) 
	{
		CustomerEntity customer=service.update(bean);
		if(customer!=null)
		{
			
			return new ResponseEntity<CustomerEntity>(bean,HttpStatus.OK); 
		}
		else
		{
			 throw new RecordNotFoundException("Customer does not exists with ID: "+bean.getUserEntity().getId());
		} 
	}
	
	@PutMapping(path="/forgetPass/{login}{password}")
	 public ResponseEntity<CustomerEntity> forgetPassword(@PathVariable long login,@PathVariable String password)
	 {
		 boolean bol=service.forgetPassword(login,password);
		 if(bol)
		 {
			 CustomerEntity customer=service.findById(login);
			 return new ResponseEntity<CustomerEntity>(customer,HttpStatus.OK);
		 }
		 else
		 {
			 throw new RecordNotFoundException("User does not exists");
		 }
	 }
	
	@PutMapping(path="/authenticate")
	 public ResponseEntity<CustomerEntity> authenticate(@RequestBody CustomerEntity bean)
	 {
		 CustomerEntity customer=service.authenticate(bean);
		 if(customer!=null)
		 {
			 ResponseEntity<CustomerEntity> responseEntity =new ResponseEntity<CustomerEntity>(customer,HttpStatus.OK);
			 return responseEntity;
		 }
		 else
		 {
			 throw new RecordNotFoundException("No user found");
		 }
	 }
	
	@PostMapping(path="/addCustomer")
	public ResponseEntity<CustomerEntity> addCustomer(CustomerEntity bean)
	{
	    CustomerEntity customer=service.add(bean);
	    System.out.println(customer);
	        ResponseEntity<CustomerEntity> responseEntity =new ResponseEntity<CustomerEntity>(customer,HttpStatus.OK);
            return responseEntity;
	   
	}
}
