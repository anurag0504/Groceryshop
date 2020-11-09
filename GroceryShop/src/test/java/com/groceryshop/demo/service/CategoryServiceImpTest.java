package com.groceryshop.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.groceryshop.demo.entitites.CategoryEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;
import com.groceryshop.demo.repository.CategoryRepository;

class CategoryServiceImpTest {

	
	
	@Test
	void testAdd() throws DuplicateRecordException {
		CategoryServiceImp categoryServiceImp= mock(CategoryServiceImp.class);
		CategoryEntity categoryEntity=new CategoryEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),1,"Choclate");
		when(categoryServiceImp.add(categoryEntity)).thenReturn(categoryEntity.getId());
		assertEquals(0,categoryServiceImp.add(categoryEntity));
	}

	@Test
	void testUpdate() {
		CategoryServiceImp categoryServiceImp= mock(CategoryServiceImp.class);
		CategoryEntity categoryEntity=new CategoryEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),1,"Choclate");
		categoryEntity.setCategoryName("bisucits");
		CategoryEntity categoryEntity1=new CategoryEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),1,"Choclate");
		
		

	}

	@Test
	void testDelete() {
		CategoryServiceImp categoryServiceImp= mock(CategoryServiceImp.class);
		CategoryEntity categoryEntity=new CategoryEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),1,"Choclate");
		CategoryEntity categoryEntity1=new CategoryEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),2,"Stationary");
		List<CategoryEntity> categories=new ArrayList<CategoryEntity>();
		categories.add(categoryEntity1);
		categories.add(categoryEntity);
		int size=categories.size();
		categoryServiceImp.delete(categoryEntity1);
		int size2=categories.size();
		assertEquals(1, size2);
	}

	@Test
	void testFindByName() {
		CategoryServiceImp categoryServiceImp= mock(CategoryServiceImp.class);
		CategoryEntity categoryEntity=new CategoryEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),1,"Choclate");
		when(categoryServiceImp.findByName("Choclate")).thenReturn(categoryEntity);
		assertEquals(categoryEntity,categoryServiceImp.findByName("Choclate"));
	}

	@Test
	void testFindByCode() {
		CategoryServiceImp categoryServiceImp= mock(CategoryServiceImp.class);
		CategoryEntity categoryEntity=new CategoryEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),1,"Choclate");
		when(categoryServiceImp.findByCode(1)).thenReturn(categoryEntity);
		assertEquals(categoryEntity,categoryServiceImp.findByCode(1));
	}

	

	@Test
	void testSearchCategoryEntity() {
		CategoryServiceImp categoryServiceImp= mock(CategoryServiceImp.class);
		CategoryEntity categoryEntity=new CategoryEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),1,"Choclate");
		CategoryEntity categoryEntity1=new CategoryEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),2,"Stationary");
		List<CategoryEntity> categories=new ArrayList<CategoryEntity>();
		categories.add(categoryEntity1);
		categories.add(categoryEntity);
		when(categoryServiceImp.search(categoryEntity)).thenReturn(categories);
		assertEquals(categories.get(0),categoryServiceImp.search(categoryEntity));
	}

	@Test
	void testGetImageById() {
		fail("Not yet implemented");
	}

}
