package com.groceryshop.demo.controller;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.groceryshop.demo.entitites.CategoryEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;
import com.groceryshop.demo.exception.RecordNotFoundException;

@SpringBootTest
class CategoryControllerTest {
	 

    @Mock
    CategoryController categoryControler;
	
	CategoryEntity categoryEntity=new CategoryEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),1,"Choclate");
	ResponseEntity<CategoryEntity> responseEntity =new ResponseEntity<CategoryEntity>(categoryEntity,HttpStatus.OK);
	 
	
	
	@Test
	void testAddCategory()  {
	    when(categoryControler.addCategory(categoryEntity)).thenReturn(responseEntity);
        Object response=categoryControler.addCategory(categoryEntity);
        assertEquals(responseEntity,response);
	}

    
	@Test
	void testUpdateCategory(){
	    when(categoryControler.updateCategory(categoryEntity)).thenReturn(responseEntity);
	    Object response=categoryControler.updateCategory(categoryEntity);
	    assertEquals(responseEntity,response);
	}
	

	@Test
	void testDeleteCategory() {
	    when(categoryControler.deleteCategory(categoryEntity)).thenReturn(responseEntity); 
	    Object response=categoryControler.deleteCategory(categoryEntity);
	    assertEquals(responseEntity,response);
	}

	
	@Test
	void testFindByName() {
	    when(categoryControler.findByName(categoryEntity.getCategoryName())).thenReturn(responseEntity);
	    Object response=categoryControler.findByName(categoryEntity.getCategoryName());
	    assertEquals(responseEntity,response);
	   
	}

	@Test
	void testFindByCategoryId() {
	    when(categoryControler.findByCategoryId(categoryEntity.getCategoryId())).thenReturn(responseEntity);
	    Object response=categoryControler.findByCategoryId(categoryEntity.getCategoryId());
	    assertEquals(responseEntity,response);
	}

	@Test
	void testSearch() {
	    CategoryEntity categoryEntity1=new CategoryEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),2,"Stationary");
	    List<CategoryEntity> categories=new ArrayList<CategoryEntity>();
	    categories.add(categoryEntity1);
	    categories.add(categoryEntity);
	    when(categoryControler.search()).thenReturn(categories);
	    Object response=categoryControler.search();
	    assertEquals(categories,response);
	}


    @Test
    void testAddCategroyException()  {
        when(categoryControler.addCategory(categoryEntity)).thenThrow(new DuplicateRecordException("Duplicate record found"));
        Assert.assertThrows(DuplicateRecordException.class, ()->{categoryControler.addCategory(categoryEntity);});
    }
    
    @Test
    void testUpdateCategroyException()  {
        when(categoryControler.updateCategory(categoryEntity)).thenThrow(new RecordNotFoundException("Record not found"));
        Assert.assertThrows(RecordNotFoundException.class, ()->{categoryControler.updateCategory(categoryEntity);});
    }

    @Test
    void testDeleteCategoryException() {
        when(categoryControler.deleteCategory(categoryEntity)).thenThrow(new RecordNotFoundException("Record not found"));
        Assert.assertThrows(RecordNotFoundException.class, ()->{categoryControler.deleteCategory(categoryEntity);});
    }
    

    @Test
    void testFindByNameException() {
        when(categoryControler.findByName(categoryEntity.getCategoryName())).thenThrow(new RecordNotFoundException("Record not found"));
        Assert.assertThrows(RecordNotFoundException.class, ()->{categoryControler.findByName(categoryEntity.getCategoryName());});
    }
    
    @Test
    void testFindByCategoryIdException() {
        when(categoryControler.findByCategoryId(categoryEntity.getCategoryId())).thenThrow(new RecordNotFoundException("Record not found"));
        Assert.assertThrows(RecordNotFoundException.class, ()->{categoryControler.findByCategoryId(categoryEntity.getCategoryId());});
    }
    
    @Test
    void testSearchException() {
        when(categoryControler.search()).thenThrow(new RecordNotFoundException("No Records found"));
        Assert.assertThrows(RecordNotFoundException.class, ()->{categoryControler.search();});
    }
    
}
