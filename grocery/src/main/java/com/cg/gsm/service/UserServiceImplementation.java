package com.cg.gsm.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import com.cg.gsm.entities.UserEntity;
import com.cg.gsm.exception.DuplicateRecordException;

import com.cg.gsm.repository.UserDAOImplementation;
import com.cg.gsm.util.JPAUtil;

public class UserServiceImplementation implements UserServiceInt {
	
	EntityManager entityManager=JPAUtil.getEntityManager();
	EntityTransaction transaction=entityManager.getTransaction();
	UserDAOImplementation userDAO=new UserDAOImplementation(entityManager, transaction);
	

	@Override
	public long add(UserEntity bean) throws DuplicateRecordException{
		// TODO Auto-generated method stub
		long primaryKey=0;
		
			UserEntity userEntity=entityManager.find(UserEntity.class, bean.getId());
			if(userEntity!=null)
			{
				throw new DuplicateRecordException("User already exists. ");
			}
			else 
			{
				
				primaryKey=userDAO.add(bean);
				//System.out.println(primaryKey+" "+userDAO.add(bean));
				
			}
		
		return primaryKey;
		
	
	}

	@Override
	public void delete(UserEntity bean) {
		// TODO Auto-generated method stub
		//UserEntity entityToBeDeleted=entityManager.merge(bean);
		UserEntity entityToBeDeleted=entityManager.find(UserEntity.class, bean.getId());
		transaction.begin();
		userDAO.delete(entityToBeDeleted);
		transaction.commit();
		
	}

	@Override
	public void update(UserEntity bean) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		try {
			UserEntity userEntity=entityManager.find(UserEntity.class, bean.getId());
			if(userEntity!=null)
			{
				transaction.begin();
				userDAO.update(bean);
				transaction.commit();
			}
			else 
			{
				throw new DuplicateRecordException("User not found.");
			}
		}catch(DuplicateRecordException e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public UserEntity findByPK(long pk) {
		// TODO Auto-generated method stub
		
		return userDAO.findByPk(pk);
	}

	@Override
	public UserEntity findByLogin(String login) {
		// TODO Auto-generated method stub
		return userDAO.findByLogin(login);
	}

	@Override
	public List<UserEntity> search(UserEntity bean) {
		// TODO Auto-generated method stub
		List<UserEntity> searchResult=userDAO.search(bean);
		return searchResult;
	}

	@Override
	public List search(UserEntity bean, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public boolean changePassword(Long id, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		UserEntity userEntity=entityManager.find(UserEntity.class, id);
		transaction.begin();
		boolean changePasswordSuccess=false;
		if(userEntity.getPassword().equals(oldPassword))
		{
			userDAO.update(userEntity);
			changePasswordSuccess=true;
		}
		transaction.commit();
		return changePasswordSuccess;
	}

	@Override
	public UserEntity authenticate(UserEntity bean) {
		// TODO Auto-generated method stub
		System.out.println(bean);
		transaction.begin();
		
		UserEntity userEntity=userDAO.authenticate(bean);
		
		transaction.commit();
		System.out.println(userEntity);
		return userEntity;
	}

	@Override
	public long registerUser(UserEntity bean) throws DuplicateRecordException {
		// TODO Auto-generated method stub
			transaction.begin();
			userDAO.add(bean);
			transaction.commit();
	 		return bean.getId();
	 }
 
	@Override
	public boolean forgetPassword(String login) {
		// TODO Auto-generated method stub
		UserEntity userEntity=userDAO.findByLogin(login);
		String newPassword="";
		boolean passwordBoolean=changePassword(userEntity.getId(),userEntity.getPassword(), newPassword);
		return passwordBoolean;
	}

}
