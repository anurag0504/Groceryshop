package com.cg.gsm.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.cg.gsm.entities.BookProductEntity;
import com.cg.gsm.exception.DuplicateRecordException;
import com.cg.gsm.util.JPAUtil;
import com.cg.gsm.repository.*;

public class BookProductServiceImplements implements BookProductServiceInt{

	EntityManager entityManager=JPAUtil.getEntityManager();
	EntityTransaction transaction=entityManager.getTransaction();
	BookProductDAOImplementation bookProductImplementation=new BookProductDAOImplementation(entityManager,transaction);
	long primaryKey;
	@Override
	public long add(BookProductEntity bean) throws DuplicateRecordException{
				transaction.begin();
				primaryKey=bookProductImplementation.add(bean);
				transaction.commit();
				return primaryKey;
		
	}

	@Override
	public void update(BookProductEntity bean) {
		// TODO Auto-generated method stub
		BookProductEntity bookProductEntity=entityManager.find(BookProductEntity.class, bean.getId());
		transaction.begin();
		bookProductImplementation.update(bean);
		transaction.commit();
	
	}

	@Override
	public void delete(BookProductEntity bean) {
		BookProductEntity bookProductEntity=entityManager.merge(bean);
		transaction.begin();
		bookProductImplementation.delete(bookProductEntity);
		transaction.commit();
		
	}

	@Override
	public BookProductEntity findByName(String name) {
		
		return bookProductImplementation.findByName(name);
	}

	@Override
	public BookProductEntity findByPk(long id) {
		return bookProductImplementation.findByPk(id);
	}

	@Override
	public List<BookProductEntity> search(BookProductEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookProductEntity> search(BookProductEntity bean) {
		return bookProductImplementation.search(bean);
	}

}