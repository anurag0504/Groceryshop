package com.groceryshop.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.groceryshop.demo.controller.CustomerController;
import com.groceryshop.demo.entitites.CustomerEntity;

@SpringBootTest
/**
 * @SpringBootTest annotation, which can be used as an alternative to the standard spring-test
 
 *
 */
class CustomerControllerTest {


	@Mock
	CustomerController customerController;

	CustomerEntity customerEntity=new CustomerEntity(1,"chaithu","84669745967","india","Telangana","hyd","50043","mbnr");


	ResponseEntity<CustomerEntity> responseEntity =new ResponseEntity<CustomerEntity>(customerEntity,HttpStatus.OK);



	@Test
	/**
	 * Test annotation, which can be used as an alternative to the standard spring-test 
	 */
	void testCustomer()  {
		when(customerController.addCustomer(customerEntity)).thenReturn(responseEntity);
		Object response=customerController.addCustomer(customerEntity);
		assertEquals(customerEntity, response);
	}
	/**This method is about adding the customer details are tested whether it is added or not with help of customer entity by using add method.
	 * assertEquals means Asserts that two object arrays are equal.
	 *  If they are not, an AssertionError is thrown with the given message.
	 *  If expected and actuals are null , they are considered equal.
	 */
	@Test
			void testupdate()  {
				when(customerController.update(customerEntity)).thenReturn(responseEntity);
				Object response=customerController.update(customerEntity);
				assertEquals(customerEntity, response);

				/**This method is about updating the customer details are tested whether it is updated or not with help of customer entity by using update method.
				 * assertEquals means Asserts that two object arrays are equal.
				 *  If they are not, an AssertionError is thrown with the given message.
				 *  If expected and actuals are null , they are considered equal.
				 */
		}
	@Test
	void testchangePassword()  {
		when(customerController.changePassword(1L,"chaithu","chaithanya")).thenReturn(responseEntity);
		
		assertEquals(customerEntity, responseEntity);
	}
	/**This method is about changing the password of the customer and the details are tested whether it changed  or not with help of customer entity by using changePassword method.
	 * assertEquals means Asserts that two object arrays are equal.
	 *  If they are not, an AssertionError is thrown with the given message.
	 *  If expected and actuals are null , they are considered equal.
	 */
	
	@Test
	void testforgetpassword()  {
	when(customerController.forgetPassword(1L,"chaithu")).thenReturn(responseEntity);
	Object response=customerController.forgetPassword(1l,"chaithu");
	assertEquals(customerEntity, response);


	}

	/**This method is about forget password of the customer and the details are tested whether password got reset  or not with help of customer entity by using changePassword method.
	 * assertEquals means Asserts that two object arrays are equal.
	 *  If they are not, an AssertionError is thrown with the given message.
	 *  If expected and actuals are null , they are considered equal.
	 */
}
