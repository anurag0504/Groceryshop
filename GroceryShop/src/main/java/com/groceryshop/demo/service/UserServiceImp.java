package com.groceryshop.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.groceryshop.demo.entitites.UserEntity;
import com.groceryshop.demo.repository.UserRepository;

@Component
public class UserServiceImp {
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public UserEntity addUser(UserEntity user)
	{
	return userRepository.save(user);
	}
	
	@Transactional
    public String updateUser(UserEntity user) {
        return userRepository.save(user).getLoginId();
    }
     
	@Transactional
	public void deleteUserById(long loginId) {
		userRepository.deleteById((int) loginId);
	}

}
