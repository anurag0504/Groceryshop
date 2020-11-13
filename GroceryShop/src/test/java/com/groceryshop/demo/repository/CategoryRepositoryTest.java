package com.groceryshop.demo.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.groceryshop.demo.entitites.CategoryEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;

@SpringBootTest
class CategoryRepositoryTest {
 
 
    
	@Mock
	CategoryRepository categoryRepository;
	CategoryEntity categoryEntity=new CategoryEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),1,"Choclate");
	

	@Test
	void testFindByCategoryName() {
		when(categoryRepository.findByCategoryName(categoryEntity.getCategoryName())).thenReturn(categoryEntity);
		Object response= categoryRepository.findByCategoryName(categoryEntity.getCategoryName());
		assertEquals(categoryEntity,response);
	}

	@Test 
	void testFindByCategoryId() {
		when(categoryRepository.findByCategoryId(categoryEntity.getCategoryId())).thenReturn(categoryEntity);
		Object response=categoryRepository.findByCategoryId(categoryEntity.getCategoryId());
		assertEquals(categoryEntity,response);
	}

	@Test
	void testSave() {
		when(categoryRepository.save(categoryEntity)).thenReturn(categoryEntity);
		Object response=categoryRepository.save(categoryEntity);
		assertEquals(categoryEntity,response);	
	}

	
	@Test
	void testFindAll() {
		CategoryEntity categoryEntity1=new CategoryEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),2,"Stationary");
		List<CategoryEntity> categories=new ArrayList<CategoryEntity>();
		categories.add(categoryEntity1);
		categories.add(categoryEntity);
		when(categoryRepository.findAll()).thenReturn(categories);
		Object response=categoryRepository.findAll();
		assertEquals(categories,response);
	}

	@Test
	void testDelete() {
	    categoryRepository.delete(categoryEntity);
		verify(categoryRepository,times(1)).delete(categoryEntity);
	}

	@Test
	void testFindByCategroyNameException()  {
	    when(categoryRepository.findByCategoryName(categoryEntity.getCategoryName())).thenThrow(new DuplicateRecordException("Duplicate record found"));
	    Assert.assertThrows(DuplicateRecordException.class, ()->{categoryRepository.findByCategoryName(categoryEntity.getCategoryName());});
	}
	
	@Test 
	void testFindByCategoryIdException() 
	{
	    when(categoryRepository.findByCategoryId(categoryEntity.getCategoryId())).thenThrow(new DuplicateRecordException("Duplicate record found"));
	    Assert.assertThrows(DuplicateRecordException.class, ()->{categoryRepository.findByCategoryId(categoryEntity.getCategoryId());});
	}
	   
	   

}
