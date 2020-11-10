package com.groceryshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceryshop.demo.entitites.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>{

	CategoryEntity findByCategoryName(String name);

	CategoryEntity findByCategoryId(Integer id);

}
