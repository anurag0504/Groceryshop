package com.groceryshop.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.groceryshop.demo.entitites.AdminEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;
import com.groceryshop.demo.repository.AdminRepository;

@Component
public class AdminServiceImp implements AdminServiceInt {
	@Autowired
	public AdminRepository adminRepository;

	@Override
	public long add(AdminEntity bean) throws DuplicateRecordException {
		AdminEntity adminEntity = adminRepository.save(bean);
		return adminEntity.getLoginId();
		// return adminRepository.save(admin);

	}

	@Override
	public void delete(int id) {
		adminRepository.deleteById(id);
	}

	@Override
	public void update(AdminEntity bean) throws DuplicateRecordException {
		 adminRepository.save(bean);
	}

	@Override
	public AdminEntity authenticate(AdminEntity bean) {
		AdminEntity adminEntity = adminRepository.findById((int) bean.getLoginId()).orElse(null);
		return bean;

	}

	
	@Override
	public AdminEntity findByLoginId(long id) {
		AdminEntity admin = adminRepository.findById((int) id).orElse(null);
		System.out.println(admin);
		return admin;

	}

	@Override
	public List<AdminEntity> search(AdminEntity bean) {
		return (List<AdminEntity>) adminRepository.findAll();
	}

//	@Override
//	public List search(AdminEntity bean, int pageNo, int pageSize) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	/*public AdminEntity findByLoginId(long loginId) {
		// TODO Auto-generated method stub
		return adminRepository.findByLoginId(loginId).get();
	}*/

	

}
