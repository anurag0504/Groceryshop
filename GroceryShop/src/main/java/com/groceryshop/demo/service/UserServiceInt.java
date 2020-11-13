package com.groceryshop.demo.service;

import com.groceryshop.demo.entitites.UserEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;

public interface UserServiceInt {

	public long add(UserEntity bean) throws DuplicateRecordException;

	public long delete(long id) ;

	public UserEntity update(UserEntity bean) throws DuplicateRecordException;
	public UserEntity authenticate(UserEntity bean);

}
