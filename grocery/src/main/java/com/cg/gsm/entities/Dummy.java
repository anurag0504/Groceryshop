package com.cg.gsm.entities;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.gsm.repository.BookProductDAOImplementation;

public class Dummy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		BookProductDAOImplementation bookProductDAOImplementation =new BookProductDAOImplementation(entityManager, entityTransaction);
		
		UserEntity userEntity=new UserEntity(1L,"createdBy","modifiedBy",Timestamp.from(Instant.now()),
				Timestamp.from(Instant.now()),"Anurag","Domala","anurag","123","8790145405","anurag@gmail.com",1L);
		
		
		byte[] dummybyte=new byte[10];
		ProductEntity productEntity=new ProductEntity(1L,"createdBy","modifiedBy",Timestamp.from(Instant.now()),
				Timestamp.from(Instant.now()),"Dairy Milk","100","10","Choclate","1",dummybyte);
		
		
		BookProductEntity bean=new BookProductEntity(1L,"createdBy","modifiedBy",Timestamp.from(Instant.now()),
				Timestamp.from(Instant.now()),1L,"Dairy Milk","Anurag","anurag@gmail.com","8790145405","India",
				"Telangana","Hyderabad","500072","Kkp",100L,"1","1000",new Date());
		
		entityTransaction.begin();
		entityManager.persist(bean);
		entityTransaction.commit();
		
		entityTransaction.begin();
		entityManager.persist(userEntity);
		entityTransaction.commit();
		
		entityTransaction.begin();
		entityManager.persist(productEntity);
		entityTransaction.commit();
		
	}

}
