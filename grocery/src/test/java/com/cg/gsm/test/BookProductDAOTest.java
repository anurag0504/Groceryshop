package com.cg.gsm.test;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.cg.gsm.entities.BookProductEntity;

import com.cg.gsm.repository.BookProductDAOImplementation;


import junit.framework.Assert;
import junit.framework.TestCase;

public class BookProductDAOTest extends TestCase {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	
	/*public void testAdd() {
		
		UserDAOImplementation user=mock(UserDAOImplementation.class);
		UserEntity userobj=new UserEntity("createdBy","modifiedBy",Timestamp.from(Instant.now()),
				Timestamp.from(Instant.now()),"Anurag","Domala","anurag","123","8790145405","anurag@gmail.com",2L);
		
		
		when(user.add(userobj)).thenReturn(userobj.getId());
		
		Assert.assertEquals(userobj.getId(),user.add(userobj));
		
	 }*/
	

	
	BookProductEntity bean=new BookProductEntity("createdBy","modifiedBy",Timestamp.from(Instant.now()),
			Timestamp.from(Instant.now()),2L,"Dairy Milk","Anurag","anurag@gmail.com","8790145405","India",
			"Telangana","Hyderabad","500072","Kkp",100L,"2","1000",new Date());
	
	BookProductDAOImplementation bookProductDAOImplementation;
	
	
	@Test
	public void testAdd() {
		
		Assert.assertEquals(bean.getId(),bookProductDAOImplementation.add(bean));
		
	}

	@Test
	public void testUpdate() {
		
		
		Assert.assertEquals(bean,bookProductDAOImplementation.findByName(bean.getName()));
		
	}

	@Test
	public void testDelete() {
	
		Assert.assertEquals(null,bookProductDAOImplementation.findByName(bean.getName()));
		
	} 

	@Test
	public void testfindByName() {
		
		Assert.assertEquals(bean,bookProductDAOImplementation.findByName(bean.getName()));
		
	} 
		@Test
	public void testfindByPk() {
		
		
		Assert.assertEquals(bean,bookProductDAOImplementation.findByPk(bean.getId()));
		
	} 
	
	
}
