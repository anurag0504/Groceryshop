package com.cg.gsm.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.cg.gsm.entities.ProductEntity;
import com.cg.gsm.entities.UserEntity;
import com.cg.gsm.exception.DuplicateRecordException;

public class UserDAOImplementation implements UserDAOInt{

	EntityManager entityManager;
	EntityTransaction transaction;
	

	public UserDAOImplementation(EntityManager entityManager, EntityTransaction transaction) {
		// TODO Auto-generated constructor stub
		this.entityManager=entityManager;
		this.transaction=transaction;
	}



	@Override
	public long add(UserEntity bean) {
		// TODO Auto-generated method stub
		entityManager.persist(bean);
		Query query=entityManager.createQuery("SELECT userEntity from UserEntity userEntity where userEntity.getEmailId="+bean.getEmailId());
	 UserEntity userEntity=(UserEntity)query.getSingleResult();
	 return userEntity.getId();
	}

	@Override
	public void update(UserEntity bean) {
		// TODO Auto-generated method stub
		UserEntity userEntity=entityManager.find(UserEntity.class, bean.getId());
		
			entityManager.merge(userEntity);
			
			//userEntity.setId(bean.getId());
		/*	userEntity.setCreatedBy(bean.getCreatedBy());
			userEntity.setCreatedDateTime(bean.getCreatedDateTime());
			
			userEntity.setEmailId(bean.getEmailId());
			
			userEntity.setFirstName(bean.getFirstName());
			userEntity.setLastName(bean.getLastName());
			userEntity.setMobileNo(bean.getMobileNo());
			userEntity.setPassword(bean.getPassword());
			userEntity.setRoleId(bean.getRoleId());
			//userEntity.setLoginId(bean.getLoginId());
			userEntity.setModifiedBy(bean.getModifiedBy());
			userEntity.setModifiedDateTime(bean.getModifiedDateTime());
		*/
		
	}

	@Override
	public void delete(UserEntity bean) {
		// TODO Auto-generated method stub
		entityManager.remove(bean);
	}

	@Override
	public UserEntity findByLogin(String login) {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("SELECT userEntity from UserEntity userEntity where userEntity.getLoginId()="+login,UserEntity.class);
		return (UserEntity)query.getSingleResult();
	}

	@Override
	public UserEntity findByPk(long id) {
		// TODO Auto-generated method stub
		return entityManager.find(UserEntity.class, id);
	}

	@Override
	public List<UserEntity> search(UserEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEntity> search(UserEntity bean) {
		// TODO Auto-generated method stub
		//List<UserEntity> userEntityList=new ArrayList<UserEntity>();
		Query query=entityManager.createQuery("SELECT userEntity from UserEntity userEntity",UserEntity.class);
		ArrayList<UserEntity> userList=new ArrayList<UserEntity>(query.getResultList());
		
		return userList;

	}

	@Override
	public UserEntity authenticate(UserEntity bean) {
		// TODO Auto-generated method stub
		
		Query query=entityManager.createQuery("SELECT userEntity from  UserEntity userEntity where loginId="+bean.getLoginId()+" and password="+ bean.getPassword());
		return (UserEntity)query.getSingleResult();
	}
	

}
