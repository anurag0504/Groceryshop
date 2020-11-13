package com.groceryshop.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.groceryshop.demo.entitites.AdminEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;
import com.groceryshop.demo.exception.RecordNotFoundException;

@SpringBootTest
public class AdminControllerTest {
	@Mock
    AdminController adminController;
	
	AdminEntity adminEntity=new AdminEntity(2,"Priyanka","Priya@567","priya@gmail.com");
	ResponseEntity<AdminEntity> responseEntity =new ResponseEntity<AdminEntity>(adminEntity,HttpStatus.OK);
	
	@Test
	void testAddAdmin()  {
	    when(adminController.addAdminEntity(adminEntity)).thenReturn(responseEntity);
        Object response=adminController.addAdminEntity(adminEntity);
        assertEquals(responseEntity,response);
	}
	@Test
	void testUpdateAdmin(){
	    when(adminController.updateAdminEntity(adminEntity)).thenReturn(responseEntity);
	    Object response=adminController.updateAdminEntity(adminEntity);
	    assertEquals(responseEntity,response);
	}
	@Test
	void testDeleteAdmin() {
	    when(adminController.deleteAdminEntity(2)).thenReturn(responseEntity); 
	    Object response=adminController.deleteAdminEntity(2);
	    assertEquals(responseEntity,response);
	}
	@Test
	void testFindByLogin() {
		when(adminController.findByLogin(adminEntity.getLoginId())).thenReturn(responseEntity);
	    Object response=adminController.findByLogin(adminEntity.getLoginId());
	    assertEquals(responseEntity,response);
	}
	@Test
	void testSearch() {
	    AdminEntity adminEntity1=new AdminEntity(2,"Priyanka","Priya@567","priya@gmail.com");
	    List<AdminEntity> admin=new ArrayList<AdminEntity>();
	    admin.add(adminEntity1);
	    admin.add(adminEntity);
	    when(adminController.search(adminEntity)).thenReturn(admin);
	    Object response=adminController.search(adminEntity);
	    assertEquals(admin,response);
	}

	@Test
    void testAddAdminException()  {
        when(adminController.addAdminEntity(adminEntity)).thenThrow(new DuplicateRecordException("Duplicate record found"));
        assertThrows(DuplicateRecordException.class, ()->{adminController.addAdminEntity(adminEntity);});
    }
    
    @Test
    void testUpdateAdminException()  {
        when(adminController.updateAdminEntity(adminEntity)).thenThrow(new RecordNotFoundException("Record not found"));
        assertThrows(RecordNotFoundException.class, ()->{adminController.updateAdminEntity(adminEntity);});
    }

    @Test
    void testDeleteAdminException() {
        when(adminController.deleteAdminEntity(2)).thenThrow(new RecordNotFoundException("Record not found"));
        assertThrows(RecordNotFoundException.class, ()->{adminController.deleteAdminEntity(2);});
    }
    @Test
    void testFindByLoginException() {
        when(adminController.findByLogin(adminEntity.getLoginId())).thenThrow(new RecordNotFoundException("Record not found"));
        assertThrows(RecordNotFoundException.class, ()->{adminController.findByLogin(adminEntity.getLoginId());});
    }
    @Test
    void testSearchException() {
        when(adminController.search(adminEntity)).thenThrow(new RecordNotFoundException("No Records found"));
        assertThrows(RecordNotFoundException.class, ()->{adminController.search(adminEntity);});
    }

}
