package com.groceryshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceryshop.demo.entitites.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    
}