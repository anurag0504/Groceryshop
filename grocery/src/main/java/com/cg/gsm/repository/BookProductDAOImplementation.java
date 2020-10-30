package com.cg.gsm.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.cg.gsm.entities.BookProductEntity;


public class BookProductDAOImplementation implements BookProductDAOInt {

	EntityManager entityManager;
	EntityTransaction entityTransaction;
	public BookProductDAOImplementation(EntityManager entityManager,EntityTransaction entityTransaction)
	{
		this.entityManager=entityManager;
		this.entityTransaction=entityTransaction;
	}
	
	@Override
	public long add(BookProductEntity bean)  {
		// TODO Auto-generated method stub
		entityTransaction.begin();
		entityManager.persist(bean);
		entityTransaction.commit();
		return bean.getId();
	}

	@Override
	public void update(BookProductEntity bean) {
		// TODO Auto-generated method stub
		BookProductEntity bookProductEntity=entityManager.find(BookProductEntity.class,bean.getId());
		entityManager.merge(bookProductEntity);
	}

	@Override
	public void delete(BookProductEntity bean) {
		entityManager.remove(bean);	
	}

	@Override
	public BookProductEntity findByName(String name) {
		Query query=entityManager.createQuery("SELECT bookProductEntity from BookProductEntity bookProductEntity where bookProductEntity.getName() ="+name,BookProductEntity.class);
		return (BookProductEntity)query.getSingleResult();

	}

	@Override
	public BookProductEntity findByPk(long id) {
		return entityManager.find(BookProductEntity.class, id);
	}

	@Override
	public List<BookProductEntity> search(BookProductEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookProductEntity> search(BookProductEntity bean) {
		Query query=entityManager.createQuery("SELECT bookProductEntity from BookProductEntity bookProductEntity ",BookProductEntity.class);
		ArrayList<BookProductEntity> bookProductList=new ArrayList<BookProductEntity>(query.getResultList());
		return bookProductList;
	}

}