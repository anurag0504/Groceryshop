package com.groceryshop.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.groceryshop.demo.entitites.CategoryEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;


@SpringBootTest
class CategoryServiceImpTest {
 
	@Mock
	CategoryServiceImp categoryServiceImp;
	
	
	
	CategoryEntity categoryEntity=new CategoryEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),1,"Choclate");
	
	
	@Test
	void testAdd() throws DuplicateRecordException {
	    when(categoryServiceImp.addCategory(categoryEntity)).thenReturn(1L);
	    Object response=categoryServiceImp.addCategory(categoryEntity);
		assertEquals(1,response);
	}
 
	@Test
	void testUpdate() throws DuplicateRecordException {
		
		categoryEntity.setCategoryName("biscuits");
		when(categoryServiceImp.updateCategory(categoryEntity)).thenReturn(categoryEntity);
		Object response=categoryServiceImp.updateCategory(categoryEntity);
		assertEquals(categoryEntity,categoryServiceImp.updateCategory(categoryEntity)); 
		

	}

	@Test
	void testDelete() {
		categoryServiceImp.deleteCategory(categoryEntity);
		verify(categoryServiceImp,times(1)).deleteCategory(categoryEntity);
	}
  
	@Test
	void testFindByName() {
		when(categoryServiceImp.findByCategoryname("Choclate")).thenReturn(categoryEntity);
		Object response=categoryServiceImp.findByCategoryname("Choclate");
		assertEquals(categoryEntity,response);
	}

	@Test
	void testFindByCode() {
		when(categoryServiceImp.findByCategoryId(1)).thenReturn(categoryEntity);
		Object response=categoryServiceImp.findByCategoryId(1);
		assertEquals(categoryEntity,response);
	}

	

	@Test
	void testSearchCategoryEntity() {
		CategoryEntity categoryEntity1=new CategoryEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),2,"Stationary");
		List<CategoryEntity> categories=new ArrayList<CategoryEntity>();
		categories.add(categoryEntity1);
		categories.add(categoryEntity);
		when(categoryServiceImp.search()).thenReturn(categories);
		Object response=categoryServiceImp.search();
		assertEquals(categories,response);
	}

	
}
