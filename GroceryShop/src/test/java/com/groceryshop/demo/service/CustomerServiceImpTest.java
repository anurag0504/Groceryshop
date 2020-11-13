package com.groceryshop.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.groceryshop.demo.entitites.CustomerEntity;
import com.groceryshop.demo.repository.CustomerRepository;
import com.groceryshop.demo.service.CustomerServiceImp;

@SpringBootTest
/**With the @SpringBootTest annotation, Spring Boot provides a convenient way to start up an application context to be used in a test.
 
 */
class CustomerServiceImpTest {

	@InjectMocks
	/**
	 * @InjectMocks creates an instance of the class and injects the mocks that are created with the @Mock annotations into this instance.
	 */
	CustomerServiceImp CustomerServiceImp;

	@Mock
	CustomerRepository CustomerRepository;
	CustomerEntity user= new CustomerEntity(1,"chaithu","84669745967","india","Telangana","hyd","50043","mbnr");
	
	@Test
	public void updateCustomerTest() {
		
		
		when(CustomerServiceImp.update(user)).thenReturn(user);
		assertEquals(user,CustomerServiceImp.update(user));
	}
	/**
	 * we are testing whether the customer details are updated are not using update method
	 * assertEquals means Asserts that two object arrays are equal.
	 *  If they are not, an AssertionError is thrown with the given message.
	 *  If expected and actuals are null , they are considered equal.
	 * 
	 */
	@Test
	/**
	 * @SpringBootTest annotation, which can be used as an alternative to the standard spring-test.
	 */
	public void changePasswordTest() 
	{
	when(CustomerServiceImp.changePassword(user.getId(),user.getUserEntity().getPassword(),"chaithu"));
	verify(CustomerServiceImp,times(1)).changePassword(user.getId(),user.getUserEntity().getPassword(),"chaithu"); 

		
	}
	/**
	 * This method is about the changing the password.and we tested the details by using the users getId and getPassword of the users entity.
	 
	 */
	public void forgetPasswordTest() 
	{
	
	when(CustomerServiceImp.forgetPassword(user.getId(),"chaithu"));
	verify(CustomerServiceImp,times(1)).forgetPassword(user.getId(),"chaithu"); 


		
	}
	/**
	 * This method is about forgetPassword and we tested using the getId and hence the password is reset.
	 */
	public void addTest() 
	{
		
	when(CustomerServiceImp.add(user)).thenReturn(user);
	assertEquals(user,CustomerServiceImp.add(user));
	}
	/**Here the details are added are not are tested by using the add method of the customer users
	 * The user method is added about finding the Id of the customer.and here the Id is checked by using the object to the entity.
	 * whether the id is available or not.
	 * Here the details are added are not are tested by using the add method of the customer users
	 */
}


	
	


