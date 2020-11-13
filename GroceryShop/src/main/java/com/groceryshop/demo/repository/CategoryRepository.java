package com.groceryshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceryshop.demo.entitites.CategoryEntity;


public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>{

	public CategoryEntity findByCategoryName(String name);
	
	public CategoryEntity findByCategoryId(Integer id);
	

}
