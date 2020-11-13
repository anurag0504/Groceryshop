package com.groceryshop.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groceryshop.demo.entitites.CategoryEntity;
import com.groceryshop.demo.entitites.CustomerEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;
import com.groceryshop.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerServiceInt{

	@Autowired
	/**
	 * Autowiring feature of spring framework enables you to inject the object dependency implicitly.
	 * It internally uses setter or constructor injection. 
	 
	 */
	CustomerRepository repository;
	
	@Override
	/**
	 * Overriding is a feature that allows a subclass or child class to provide a specific implementation of a method that is already provided.
	 */
	public boolean changePassword(Long id, String oldPassword, String newPassword) {
			CustomerEntity customer= repository.findById(id);
			if(customer!=null)
			{
				customer.getUserEntity().setPassword(newPassword);
				repository.save(customer);
				return true;
			}
			else
			{
				return false;
			}
	}
	/**
	 *  This method is about changing the password of a customer using boolean .
	 *  By using the object customer to the customer entity .
	 *  we are finding customer by findId method if the object is sent and for checking whether the password is changed.
	  
	 */

	@Override
	public CustomerEntity update(CustomerEntity bean) {
		CustomerEntity customer=repository.save(bean);
		return customer;
		
	}
	/**
	 * This method is about updating the details of the customer
	 * By using the object customer to the entity.and we are updating the details of the customer.
	 * 
	 */

	@Override
	public boolean forgetPassword(long id,String password) {
		CustomerEntity customer= repository.findById(id);
		if(customer!=null)
		{
			customer.getUserEntity().setPassword(password);
			return true;
		}
		else
		{
			return false;
		}
		
	}
	/**
	 * This method is about the forgetPassword.
	 * Here the password is obtained by the id and reset password of the customer with boolean data type ,by using the findById.
	 * customer is the object sent to the customer entity that is present in the findById.
	 */

	@Override
	public CustomerEntity authenticate(CustomerEntity bean) {
	
		CustomerEntity customer= repository.findById(bean.getId());
		if((customer.getUserEntity().getId()==bean.getUserEntity().getId())&&
				customer.getUserEntity().getPassword().equals(bean.getUserEntity().getPassword()))
		{
			return customer;
		}
		else
		{
			return null;
		}
	
	}
	/**
	 * This method is about the authenticate .here we  are finding details by findById
	 *  we used the object customer to customer entity to get details the customer using findById.
	 
	 */
	public CustomerEntity findById(Long id)
	{
		CustomerEntity customer= repository.findById(id);
		return customer;
	}
	/**
	 * This method is about finding the Id of the customer.and here the Id is checked by using the object to the entity.whether the id is available or not.
	 *@param bean
	 *@return customer
	 */
	public CustomerEntity add(CustomerEntity bean)
	{
	    CustomerEntity customer= repository.save(bean);
	    return customer;
	}
/**
 * This method is about adding the customer details with help of customer entity by using add method.
 */
}