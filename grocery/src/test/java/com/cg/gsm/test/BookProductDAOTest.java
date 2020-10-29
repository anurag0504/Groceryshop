package com.cg.gsm.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.cg.gsm.entities.BookProductEntity;
import com.cg.gsm.entities.UserEntity;
import com.cg.gsm.repository.BookProductDAOImplementation;
import com.cg.gsm.repository.UserDAOImplementation;

import junit.framework.Assert;
import junit.framework.TestCase;

public class BookProductDAOTest extends TestCase {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	//BookProductDAOImplementation bookProductDAOImplementation =new BookProductDAOImplementation(entityManager, entityTransaction);
	
	
	public void testAdd() {
		
		UserDAOImplementation user=mock(UserDAOImplementation.class);
		UserEntity userobj=new UserEntity("createdBy","modifiedBy",Timestamp.from(Instant.now()),
				Timestamp.from(Instant.now()),"Anurag","Domala","anurag","123","8790145405","anurag@gmail.com",2L);
		
		
		when(user.add(userobj)).thenReturn(userobj.getId());
		
		Assert.assertEquals(userobj.getId(),user.add(userobj));
		
	 }

	/*public void testUpdate() {
		fail("Not yet implemented");
	}

	public void testDelete() {
		fail("Not yet implemented");
	}

	public void testFindByName() {
		fail("Not yet implemented");
	}

	public void testFindByPk() {
		fail("Not yet implemented");
	}

	public void testSearchBookProductEntityLongInt() {
		fail("Not yet implemented");
	}

	public void testSearchBookProductEntity() {
		fail("Not yet implemented");
	}

	
*/
}
