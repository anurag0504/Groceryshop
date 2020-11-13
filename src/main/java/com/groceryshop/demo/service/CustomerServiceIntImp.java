package com.groceryshop.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groceryshop.demo.entitites.CategoryEntity;
import com.groceryshop.demo.entitites.CustomerEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;
import com.groceryshop.demo.repository.CustomerRepository;

@Service
public class CustomerServiceIntImp implements CustomerServiceInt{

	@Autowired
	CustomerRepository repository;
	
	@Override
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

	@Override
	public CustomerEntity update(CustomerEntity bean) {
		CustomerEntity customer=repository.save(bean);
		return customer;
		
	}

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

	@Override
	public CustomerEntity authenticate(CustomerEntity bean) {
	
		CustomerEntity customer= repository.findById(bean.getId());
		if((customer.getUserEntity().getUserId()==bean.getUserEntity().getUserId())&&
				customer.getUserEntity().getPassword().equals(bean.getUserEntity().getPassword()))
		{
			return customer;
		}
		else
		{
			return null;
		}
	
	}
	public CustomerEntity findById(Long id)
	{
		CustomerEntity customer= repository.findById(id);
		return customer;
	}

	public CustomerEntity add(CustomerEntity bean)
	{
	    CustomerEntity customer= repository.save(bean);
	    return customer;
	}
}
