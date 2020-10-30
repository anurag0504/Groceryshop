/*package com.cg.gsm.test;

import junit.framework.TestCase;

public class UserEntityTest extends TestCase {

}*/
package com.cg.gsm.test;


import java.sql.Timestamp;
import java.time.Instant;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cg.gsm.entities.UserEntity;

import com.cg.gsm.repository.UserDAOImplementation;
import com.cg.gsm.service.UserServiceImplementation;

import junit.framework.Assert;

public class UserServiceTest {
	
	UserDAOImplementation userDAO=new UserDAOImplementation();
	UserServiceImplementation userService=new UserServiceImplementation();
	
	UserEntity user=new UserEntity("admin","admin",Timestamp.from(Instant.now()),
			Timestamp.from(Instant.now()),"chatrapathi","kesaram","chatrapathi14361","123","9182720288","chatrapathi14361@gmail.com",2L);
	
	
	
	
	@Test
	public void testAdd()  {
		String firstName ="chatrapathi";
		String userEmail ="chatrapathi14361@gmail.com";
		String pass = "123";
		userDAO.add(user);
	
		Assertions.assertEquals(firstName, user.getFirstName());
		Assertions.assertEquals(pass, user.getPassword());
		Assertions.assertEquals(userEmail, user.getEmailId());
	}


	@Test
	public void testfindByLogin() {
		
		Assert.assertEquals(user.getLoginId(),userDAO.findByLogin(user.getLoginId()));
		
	}
	
	@Test
	public void testfindByPk() {
			
		Assert.assertEquals(user.getKey(),userDAO.findByPk(user.getId()));
	}
	
	
}

