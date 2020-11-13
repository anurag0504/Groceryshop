package com.groceryshop.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groceryshop.demo.entitites.AdminEntity;
import com.groceryshop.demo.entitites.UserEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;
import com.groceryshop.demo.exception.RecordNotFoundException;
import com.groceryshop.demo.service.UserServiceImp;

@RestController
@RequestMapping("/userEntity")
public class UserController {

	@Autowired
	UserServiceImp userServiceImp;
	/**
	 * addUserEntity
	 * <p>
	 * In This method we are sending userEntity object as the parameter.
	 * with the help of UserServiceImp we are finding if the object sent is present in the database or not by using the
	 * method findbyId().If the
	 * id is present then we are throwing the duplicate record Exception or
	 * else we are adding the id object to database using add()and returning the ResponseEntity.  
	 * </p>
	 * @param bean
	 * @return ResponseEntity<UserEntity>
	 */
	@PostMapping("/addUserEntity")
	public ResponseEntity<UserEntity> addUserEntity(@RequestBody UserEntity bean)  {
		long userEntityId = userServiceImp.add(bean);
		if (userEntityId != 0) {
			return new ResponseEntity<UserEntity>(bean, HttpStatus.OK);
		} else {
			throw new DuplicateRecordException("ID already exists");
		}
	}
	/**
	 * deleteUserEntity
	 * <p>
	 * In This method we are sending userEntity object as the parameter.
	 * with the help of OrderServiceImp we are finding if the object sent is present in the database or not by using the
	 * method findById().If the
	 * user is present then we are throwing the duplicate record Exception or
	 * else we are deleting the id object to database using delete()and returning the ResponseEntity.  
	 * </p>
	 * @param bean
	 * @return ResponseEntity<UserEntity>
	 */
	@DeleteMapping("/deleteUserEntity/{id}")
	public ResponseEntity<UserEntity> deleteUserEntity(@PathVariable long id){
		userServiceImp.delete(id);
		return new ResponseEntity<UserEntity>(HttpStatus.OK);
	}
	/**
	 * updateUserEntity
	 * <p>
	 * In This method we are sending userEntity object as the parameter.
	 * with the help of UserServiceImp we are finding if the object sent is present in the database or not by using the
	 * method findByLoginId().If the order is present then we are throwing the duplicate record Exception or
	 * else we are deleting the id object to database using update()and returning the ResponseEntity.  
	 * </p>
	 * @param bean
	 * @return ResponseEntity<UserEntity>
	 */
	@PutMapping("/updateUserEntity")
	public ResponseEntity<UserEntity> updateUserEntity(@RequestBody UserEntity bean) {

		UserEntity user = userServiceImp.update(bean);
		if (user != null) {
			userServiceImp.update(bean);
			return new ResponseEntity<UserEntity>(bean, HttpStatus.OK);
		}

		else {
			throw new RecordNotFoundException("Login not available with ID:" + bean.getLoginId());
		}
	}
	/**
	 * authenticateUserEntity
	 * <p>
	 * In This method we are sending userEntity object as the parameter.
	 * with the help of UserServiceImp we are finding if the object sent is present in the database or not by using the
	 * method findById().If the
	 * user is present then we are throwing the duplicate record Exception or
	 * else we are deleting the id object to database using getPassword and returning the ResponseEntity.  
	 * </p>
	 * @param bean
	 * @return ResponseEntity<UserEntity>
	 */
	@GetMapping("/authenticateUserEntity")
	public ResponseEntity<UserEntity> authenticateUserEntity(@RequestBody UserEntity bean) {
		UserEntity userEntity = userServiceImp.authenticate(bean);
		if(userEntity!=null)
		{
			if(userEntity.getPassword().equals(bean.getPassword()))
			{
				return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
			}else {
				throw new RecordNotFoundException("Invalid Password");
			}
		}else {
			throw new RecordNotFoundException("Invalid userName");
		}
	}




}
