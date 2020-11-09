package com.groceryshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceryshop.demo.entitites.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{

}
