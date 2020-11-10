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

import com.groceryshop.demo.entitites.UserEntity;
import com.groceryshop.demo.service.UserServiceImp;

@RestController
public class UserController {
	
	@Autowired
	public UserServiceImp service;
	
    @PostMapping("/user/add")
	public ResponseEntity<UserEntity> addUserDetails(@RequestBody UserEntity user)
	{
		UserEntity res=service.addUser(user);
		return new ResponseEntity<UserEntity>(res,HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteUser(@PathVariable int id)
	{
		service.deleteUserById(id);						
	}
	
	@PutMapping("user/update")
    public String updateUser(UserEntity user)
    {
        return service.updateUser(user);                   
    }
	

}
