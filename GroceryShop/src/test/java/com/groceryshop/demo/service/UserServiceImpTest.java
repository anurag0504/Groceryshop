package com.groceryshop.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.groceryshop.demo.repository.UserRepository;
import com.groceryshop.demo.service.UserServiceImp;
import com.groceryshop.demo.entitites.UserEntity;

@SpringBootTest
class UserServiceImpTest {

	@InjectMocks
	UserServiceImp userServiceImp;

	@Mock
	UserRepository userRepository;

	@Test
	public void addUserTest() {
		// UserEntity user = new UserEntity("abc","Priyanka","priya@gmail.com",567);
		UserEntity user = new UserEntity();
		user.setLoginId("abc");
		user.setPassword("Priyanka");
		user.setEmailId("priya@gmail.com");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userServiceImp.addUser(user));
	}

	@Test
	public void updateUserTest() {
		UserEntity user = new UserEntity();
		when(userRepository.findById((int) 1)).thenReturn(Optional.of(user));
	}

	@Test
	public void deleteUserTest() {
		UserEntity user = new UserEntity("abc", "Priyanka", "priya@gmail.com", 567);
		userRepository.deleteById(567);
		verify(userRepository, times(1)).deleteById(567);

	}

}
