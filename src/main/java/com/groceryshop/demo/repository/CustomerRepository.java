package com.groceryshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceryshop.demo.entitites.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
	CustomerEntity findById(Long id);
}
