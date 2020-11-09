package com.groceryshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceryshop.demo.entitites.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity, Integer>{

}
