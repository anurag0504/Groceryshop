package com.groceryshop.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.groceryshop.demo.service.UserServiceImp;
import com.groceryshop.demo.entitites.UserEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;

@SpringBootTest
class UserServiceImpTest {

	@Mock
	UserServiceImp userServiceImp;
	
		UserEntity userEntity=new UserEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),"2","Priya@567","priya@gmail.com",765);
		
		@Test
		void testAdd() throws DuplicateRecordException {
		    when(userServiceImp.add(userEntity)).thenReturn(userEntity.getId());
			assertEquals(userEntity.getId(),userServiceImp.add(userEntity));
		}
	 
		@Test
		void testUpdate() throws DuplicateRecordException {
			
			userEntity.setId(2);
			when(userServiceImp.update(userEntity)).thenReturn(userEntity);
			assertEquals(userEntity,userServiceImp.update(userEntity)); 
			

		}

		@Test
		void testDelete() {
			userServiceImp.delete(2);
			verify(userServiceImp,times(1)).delete(2);
		}
}