package com.groceryshop.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.groceryshop.demo.entitites.UserEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;
import com.groceryshop.demo.exception.RecordNotFoundException;


@SpringBootTest
 class UserControllerTest {
	@Mock
    UserController userController;
	
	UserEntity userEntity=new UserEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),"2","Priya@567","priya@gmail.com",765);
	ResponseEntity<UserEntity> responseEntity =new ResponseEntity<UserEntity>(userEntity,HttpStatus.OK);
	
	
	@Test
	void testAddUser()  {
	    when(userController.addUserEntity(userEntity)).thenReturn(responseEntity);
        Object response=userController.addUserEntity(userEntity);
        assertEquals(responseEntity,response);
	}

    
	@Test
	void testUpdateUser(){
	    when(userController.updateUserEntity(userEntity)).thenReturn(responseEntity);
	    Object response=userController.updateUserEntity(userEntity);
	    assertEquals(responseEntity,response);
	}
	

	@Test
	void testDeleteUser() {
	    when(userController.deleteUserEntity(2)).thenReturn(responseEntity); 
	    Object response=userController.deleteUserEntity(2);
	    assertEquals(responseEntity,response);
	}
	@Test
    void testAddUserException()  {
        when(userController.addUserEntity(userEntity)).thenThrow(new DuplicateRecordException("Duplicate record found"));
        assertThrows(DuplicateRecordException.class, ()->{userController.addUserEntity(userEntity);});
    }
    
    @Test
    void testUpdateUserException()  {
        when(userController.updateUserEntity(userEntity)).thenThrow(new RecordNotFoundException("Record not found"));
        assertThrows(RecordNotFoundException.class, ()->{userController.updateUserEntity(userEntity);});
    }

    @Test
    void testDeleteUserException() {
        when(userController.deleteUserEntity(2)).thenThrow(new RecordNotFoundException("Record not found"));
        assertThrows(RecordNotFoundException.class, ()->{userController.deleteUserEntity(2);});
    }
    
	

	
}
