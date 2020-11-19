package com.groceryshop.demo.repository;

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

import com.groceryshop.demo.entitites.AdminEntity;
import com.groceryshop.demo.entitites.UserEntity;

@SpringBootTest
public class AdminRepositoryTest {


	@Mock
	AdminRepository repository;
	AdminEntity adminEntity=new AdminEntity(2,"Priyanka","Priya@567","priya@gmail.com");

	/*@Test 
	void testFindById() {
		when(repository.findById((int) adminEntity.getLoginId()).thenReturn(adminEntity);
		assertEquals(adminEntity,repository.findById((int) adminEntity.getLoginId()));

	}*/
	@Test 
	void testFindAll() {
		AdminEntity adminEntity1=new AdminEntity(2,"Priyanka","Priya@567","priya@gmail.com");
		List<AdminEntity> admins=new ArrayList<AdminEntity>();
		admins.add(adminEntity1);
		admins.add(adminEntity);
		when(repository.findAll()).thenReturn(admins);
		assertEquals(admins,repository.findAll());
	}
	@Test 
	void testSave() {
		when(repository.save(adminEntity)).thenReturn(adminEntity);
		assertEquals(adminEntity,repository.save(adminEntity) );
	}

	@Test 
	void testDelete() {
		repository.delete(adminEntity);
		verify(repository,times(1)).delete(adminEntity);
	}
}
