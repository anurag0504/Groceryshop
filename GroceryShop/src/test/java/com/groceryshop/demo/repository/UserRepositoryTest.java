package com.groceryshop.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.groceryshop.demo.entitites.UserEntity;
@SpringBootTest
public class UserRepositoryTest {
	@InjectMocks

	@Mock
	UserRepository repository;
	UserEntity userEntity=new UserEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),"2","Priya@567","priya@gmail.com",765);
	@Test 
	void testFindById() {
		when(repository.findById(userEntity.getId())).thenReturn(userEntity.getId());
		assertEquals(userEntity,repository.findById(userEntity.getId()));

	}

	@Test
	void testSave() {
		when(repository.save(userEntity)).thenReturn(userEntity);
		assertEquals(userEntity,repository.save(userEntity));	
		
	}
	@Test
	void testDeleteById() {
		repository.delete(userEntity);
		verify(repository,times(1)).delete(userEntity);
	}
}
