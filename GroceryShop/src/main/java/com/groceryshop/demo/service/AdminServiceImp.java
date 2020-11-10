package com.groceryshop.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groceryshop.demo.entitites.AdminEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;
import com.groceryshop.demo.repository.AdminRepository;

@Service
public class AdminServiceImp {
@Autowired
	 public AdminRepository adminRepository;
@Transactional
		public long add(AdminEntity bean) throws DuplicateRecordException
		{
			return adminRepository.save(admin);
			
		}

		public void delete(AdminEntity bean)
		{
			
		}
		
		public void update(AdminEntity bean) throws DuplicateRecordException
		{
			return adminRepository.save(admin).getLoginId();
		}
		
		public AdminEntity authenticate(AdminEntity bean)
		{
			return bean;
			
		}
		public AdminEntity findByLogin(String login) 
		{
			return null;
			
		}
		
		public List<AdminEntity> search(AdminEntity bean)
		{
			return null;
		}
		
		public List search(AdminEntity bean, Long pageNo, int pageSize)
		{
			return null;
		}
}
