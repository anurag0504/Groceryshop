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
	/**
	 * addAdminEntity
	 * <p>
	 * In This method we are sending adminEntity object as the parameter.
	 * with the help of AdminRepsitory we are finding if the object sent is present in the database or not by using the
	 * method add and saved in bean and returned getLoginId
	 * </p>
	 * @param bean
	 * @return ResponseEntity<AdminEntity>
	 */
	@Override
	public long add(AdminEntity bean) throws DuplicateRecordException {
		AdminEntity adminEntity = adminRepository.save(bean);
		return adminEntity.getLoginId();
	}
	/**
	 * deleteAdminEntity
	 * <p>
	 * In This method we are sending id object as the parameter.
	 * with the help of AdminRepsitory we are finding if the object sent is present in the database or not by using the
	 * method delete in id
	 * </p>
	 * @param bean
	 * @return ResponseEntity<AdminEntity>
	 */
	@Override
	public void delete(int id) {
		adminRepository.deleteById(id);
	}
	/**
	 * updateAdminEntity
	 * <p>
	 * In This method we are sending adminEntity object as the parameter.
	 * with the help of AdminRepsitory we are finding if the object sent is present in the database or not by using the
	 * method update and saved in bean and returned getLoginId
	 * </p>
	 * @param bean
	 * @return ResponseEntity<AdminEntity>
	 */

	@Override
	public void update(AdminEntity bean) throws DuplicateRecordException {
		adminRepository.save(bean);
	}

	@Override
	public AdminEntity authenticate(AdminEntity bean) {
		AdminEntity adminEntity = adminRepository.findById((int) bean.getLoginId()).orElse(null);
		return bean;

	}

	/**
	 * findByLoginId
	 * <p>
	 * In This method we are sending AdminEntity object as the parameter.
	 * with the help of AdminRepsitory we are finding if the object sent is present in the database or not by using the
	 * method findByLoginId in bean and returned admin
	 * </p>
	 * @param bean
	 * @return ResponseEntity<AdminEntity>
	 */
	@Override
	public AdminEntity findByLoginId(long id) {
		AdminEntity admin = adminRepository.findById((int) id).orElse(null);
		System.out.println(admin);
		return admin;

	}
	/**
	 * ListAdminEntity
	 * <p>
	 * In This method we are sending adminEntity object as the parameter.
	 * with the help of AdminRepsitory we are finding if the object sent is present in the database or not by using the
	 * method checks in list in bean and returned bean.
	 * </p>
	 * @param bean
	 * @return ResponseEntity<AdminEntity>
	 */
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
