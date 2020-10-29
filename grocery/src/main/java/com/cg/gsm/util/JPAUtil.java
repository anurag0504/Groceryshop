package com.cg.gsm.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAUtil {
	
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("myPU");
	EntityManager entityManager=factory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public JPAUtil() {
		
	}
	
	private static JPAUtil instance = new JPAUtil();
	public static JPAUtil getInstance() {
		return instance;
	}
	public static EntityManager getEntityManager() {
		return instance.entityManager;
	}

	public static EntityTransaction getTransaction() {
		return instance.entityTransaction;
	}

}
