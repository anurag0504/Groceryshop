package com.groceryshop.demo.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.groceryshop.demo.entitites.UserEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;
import com.groceryshop.demo.repository.UserRepository;

@Service
@Transactional
public class UserServiceImp implements UserServiceInt  {
	@Autowired
	UserRepository userRepository;

	/**
	 * addUserEntity
	 * <p>
	 * In This method we are sending userEntity object as the parameter.
	 * with the help of UserRepsitory we are finding if the object sent is present in the database or not by using the
	 * method add and saved in bean and returned getId
	 * </p>
	 * @param bean
	 * @return ResponseEntity<UserEntity>
	 */
	@Override
	public long add(UserEntity bean) throws DuplicateRecordException {
		UserEntity userEntity = userRepository.save(bean);
		return userEntity.getId();
	}
	/**
	 * deleteUserEntity
	 * <p>
	 * In This method we are sending id object as the parameter.
	 * with the help of userRepsitory we are finding if the object sent is present in the database or not by using the
	 * method delete in id and returned id
	 * </p>
	 * @param bean
	 * @return ResponseEntity<UserEntity>
	 */
	@Override
	public long delete(long id) {
		userRepository.deleteById(id);	
		return id;
	}
	/**
	 * updateUserEntity
	 * <p>
	 * In This method we are sending userEntity object as the parameter.
	 * with the help of UserRepsitory we are finding if the object sent is present in the database or not by using the
	 * method update and saved in bean and returned getId
	 * </p>
	 * @param bean
	 * @return ResponseEntity<UserEntity>
	 */
	@Override
	public UserEntity update(UserEntity bean) throws DuplicateRecordException {
		userRepository.save(bean);
		return bean;
	}
	/**
	 * authenticateUserEntity
	 * <p>
	 * In This method we are sending userEntity object as the parameter.
	 * with the help of UserRepsitory we are finding if the object sent is present in the database or not by using the
	 * method findById and returned getId
	 * </p>
	 * @param bean
	 * @return ResponseEntity<UserEntity>
	 */
	@Override
	public UserEntity authenticate(UserEntity bean) {
		return userRepository.findById(bean.getId()).orElse(null);
	}






}
