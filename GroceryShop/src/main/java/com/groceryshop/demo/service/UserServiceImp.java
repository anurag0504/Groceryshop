package com.groceryshop.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groceryshop.demo.entitites.CustomerEntity;
import com.groceryshop.demo.entitites.UserEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;
import com.groceryshop.demo.repository.UserRepository;

@Service
public class UserServiceImp implements UserServiceInt {

    @Autowired
    UserRepository repository;
    
    @Override
    public UserEntity add(UserEntity bean) {
        
        UserEntity user= repository.save(bean);
        return user;
    }

    @Override
    public void delete(UserEntity bean) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(UserEntity bean) throws DuplicateRecordException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public UserEntity authenticate(UserEntity bean) {
        // TODO Auto-generated method stub
        return null;
    }

}
