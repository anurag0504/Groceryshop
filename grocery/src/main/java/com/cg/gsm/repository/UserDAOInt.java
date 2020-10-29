package com.cg.gsm.repository;

import java.util.List;

import com.cg.gsm.entities.UserEntity;


public interface UserDAOInt {

	public long add(UserEntity bean);
	
	public void update(UserEntity bean);
	
	public void delete(UserEntity bean);
	
	public UserEntity findByLogin(String login);
	
	public UserEntity findByPk(long id);
	
	public List<UserEntity> search(UserEntity bean, long pageNo, int pageSize);
	
	public List<UserEntity> search(UserEntity bean);
	
	public UserEntity authenticate(UserEntity bean);
	
}
