package com.groceryshop.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.groceryshop.demo.entitites.CategoryEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;
import com.groceryshop.demo.repository.CategoryRepository;

@SpringBootTest
class CategoryServiceImpTest {

	
	
	@Test
	void testAdd() throws DuplicateRecordException {
		CategoryServiceImp categoryServiceImp= mock(CategoryServiceImp.class);
		CategoryEntity categoryEntity=new CategoryEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),1,"Choclate");
		when(categoryServiceImp.add(categoryEntity)).thenReturn(categoryEntity.getId());
		assertEquals(categoryEntity.getId(),categoryServiceImp.add(categoryEntity));
	}

	@Test
	void testUpdate() throws DuplicateRecordException {
		CategoryServiceImp categoryServiceImp= mock(CategoryServiceImp.class);
		CategoryEntity categoryEntity=new CategoryEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),1,"Choclate");
		categoryEntity.setCategoryName("biscuits");
		
		when(categoryServiceImp.update(categoryEntity)).thenReturn(categoryEntity);
		assertEquals(categoryEntity,categoryServiceImp.update(categoryEntity));
		

	}

	@Test
	void testDelete() {
		CategoryServiceImp categoryServiceImp= mock(CategoryServiceImp.class);
		CategoryEntity categoryEntity=new CategoryEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),1,"Choclate");
		categoryServiceImp.delete(categoryEntity);
		verify(categoryServiceImp,times(1)).delete(categoryEntity);
	}

	@Test
	void testFindByName() {
		CategoryServiceImp categoryServiceImp= mock(CategoryServiceImp.class);
		CategoryEntity categoryEntity=new CategoryEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),1,"Choclate");
		when(categoryServiceImp.findByCategoryname("Choclate")).thenReturn(categoryEntity);
		assertEquals(categoryEntity,categoryServiceImp.findByCategoryname("Choclate"));
	}

	@Test
	void testFindByCode() {
		CategoryServiceImp categoryServiceImp= mock(CategoryServiceImp.class);
		CategoryEntity categoryEntity=new CategoryEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),1,"Choclate");
		when(categoryServiceImp.findByCategoryId(1)).thenReturn(categoryEntity);
		assertEquals(categoryEntity,categoryServiceImp.findByCategoryId(1));
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
		assertEquals(categories,categoryServiceImp.search(categoryEntity));
	}

	@Test
	void testGetImageById() {
		fail("Not yet implemented");
	}

}
