package com.groceryshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceryshop.demo.entitites.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}
