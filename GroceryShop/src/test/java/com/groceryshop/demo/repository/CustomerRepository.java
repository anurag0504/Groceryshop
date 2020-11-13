package com.groceryshop.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.groceryshop.demo.entitites.CustomerEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;


@SpringBootTest
/**SpringBootTest annotation, which can be used as an alternative to the standard spring-test 
 * 

 *
 */

	class CustomerRepository {
 
	
	@Mock
	CustomerRepository customerRepository;
	
	@InjectMocks
	/**
	 * @InjectMocks annotations allow us to inject mocked dependencies in the annotated class mocked object.
	 *  This is useful when we have external dependencies in the class we want to mock. 
	 */
	CustomerRepository customeRepository;
	
	
	
	@Test
	void testFindById() {
		when(customerRepository.findById(1L)).thenReturn(1L);
		assertEquals(1L,customerRepository.findById(1L));
	}
/**
 * Find by Id is a method for finding the details of the customer using the customerId and it is tested whether the Id is available or not.
 
 */


	private Object findById(long l) {
		// TODO Auto-generated method stub
		return null;
	}
}


	


