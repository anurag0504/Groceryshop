package com.cg.gsm.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.cg.gsm.entities.UserEntity;

public class UserDAOImplementation implements UserDAOInt{

	EntityManager entityManager;
	EntityTransaction transaction;
	
	
	
	public UserDAOImplementation(EntityManager entityManager, EntityTransaction transaction) {
		// TODO Auto-generated constructor stub
		this.entityManager=entityManager;
		this.transaction=transaction;
	}



	public UserDAOImplementation() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public long add(UserEntity bean) {
		/*
		 *  This method is called from UserServiceImplementation class.
		 *  This method has the UserEntity object (bean) as the parameter.
		 *  Merge here helps to copies the state of a  UserEntity.
		 *  
		 */
		UserEntity user=entityManager.merge(bean);
		
		transaction.begin();
		entityManager.persist(user); 
		transaction.commit();
		
	//	Query query=entityManager.createQuery("SELECT userEntity from UserEntity userEntity where id=:id",UserEntity.class);
		//query.setParameter("id", bean.getId());
		//UserEntity userEntity= entityManager.find(UserEntity.class,bean.getId());
		
		//System.out.println(userEntity);
	//   user=(UserEntity)query.getSingleResult();
		
	 return bean.getId(); 
	}

	@Override
	public void update(UserEntity bean) {
		// 
		UserEntity userEntity=entityManager.find(UserEntity.class, bean.getId());
		
			entityManager.merge(userEntity);
		
	}

	@Override
	public void delete(UserEntity bean) {
		// TODO Auto-generated method stub
		entityManager.remove(bean);
	}



	@Override
	public UserEntity findByPk(long id) {
		// TODO Auto-generated method stub
		return entityManager.find(UserEntity.class, id);
	}
//
	@Override
	public UserEntity findByLogin(String login) {
		/* 
		 *  This method is called from UserServiceImplementation class.
		 *  This method has loginId as the parameter.
		 * 	Writing a query to check if the user exists in the userEntity table. 
		 * 
		 */
		Query query=entityManager.createQuery("SELECT userEntity from UserEntity userEntity  where loginId=:login",UserEntity.class).setParameter("login", login);
		
		return (UserEntity)query.getSingleResult(); 
	}
	@Override
	public List<UserEntity> search(UserEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEntity> search(UserEntity bean) {
		/* 
		 *  This method is called from UserServiceImplementation class.
		 *  This method has UserEntity object (bean) as the parameter.
		 * 	Writing a query to check if the user exists in the userEntity table. 
		 * 
		 */
		Query query=entityManager.createQuery("SELECT UserEntity from UserEntity userEntity",UserEntity.class);
		ArrayList<UserEntity> userList=new ArrayList<UserEntity>(query.getResultList());
		return userList;

	}

	@Override
	public UserEntity authenticate(UserEntity bean) {
		/* 
		 *  This method is called from UserServiceImplementation class.
		 *  This method has UserEntity object (bean) as the parameter.
		 * 	Writing a query to verify if  emailId and password are matching.
		 * 
		 */
		
		Query query=entityManager.createQuery("SELECT userEntity from  UserEntity userEntity where loginId=?1 and password=?2",UserEntity.class);
		query.setParameter(1,bean.getEmailId());
		query.setParameter(2,bean.getPassword());
		System.out.println(query.getFirstResult());
		
		return (UserEntity)query.getSingleResult();
	}
	
	

}
