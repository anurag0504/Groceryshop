package com.groceryshop.demo.service;


import com.groceryshop.demo.entitites.CustomerEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;

public interface CustomerServiceInt {

	public boolean changePassword(Long id, String oldPassword, String newPassword) ;
	public CustomerEntity update(CustomerEntity bean) throws DuplicateRecordException;
	 public boolean forgetPassword(long login,String password);
	 public CustomerEntity authenticate(CustomerEntity bean);
}