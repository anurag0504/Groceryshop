package com.groceryshop.demo.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.groceryshop.demo.entitites.AdminEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;
@SpringBootTest
class AdminServiceImpTest {
	@Mock
	AdminServiceImp adminServiceImp;

	AdminEntity adminEntity=new AdminEntity(2,"Priyanka","Priya@567","priya@gmail.com");

	@Test
	void testAdd() throws DuplicateRecordException {
		when(adminServiceImp.add(adminEntity)).thenReturn(adminEntity.getLoginId());
		assertEquals(adminEntity.getLoginId(),adminServiceImp.add(adminEntity));
	}

	@Test
	void testUpdate() throws DuplicateRecordException {
		adminServiceImp.update(adminEntity);
		verify(adminServiceImp,times(1)).update(adminEntity);
	} 

	@Test
	void testDelete()  {
		adminServiceImp.delete(2);
		verify(adminServiceImp,times(1)).delete(2);
	} 



	@Test
	void testFindByLogin() {
		when(adminServiceImp.findByLoginId(2)).thenReturn(adminEntity);
		assertEquals(adminEntity,adminServiceImp.findByLoginId(2));
	}


	@Test
	void testSearchUserEntity() {
		AdminEntity adminEntity1=new AdminEntity(2,"Priyanka","Priya@567","priya@gmail.com");
		List<AdminEntity> admins=new ArrayList<AdminEntity>();
		admins.add(adminEntity1);
		admins.add(adminEntity);
		when(adminServiceImp.search(adminEntity)).thenReturn(admins);
		assertEquals(admins,adminServiceImp.search(adminEntity));
	}



}
