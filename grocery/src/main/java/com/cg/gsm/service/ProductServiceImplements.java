package com.cg.gsm.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import com.cg.gsm.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.sql.rowset.serial.SerialException;

import com.cg.gsm.entities.ProductEntity;
import com.cg.gsm.exception.DuplicateRecordException;
import com.cg.gsm.repository.ProductDAOImplements;

public class ProductServiceImplements implements ProductServiceInt{
	
	EntityManager entityManager=JPAUtil.getEntityManager();
	EntityTransaction transaction=entityManager.getTransaction();
	ProductDAOImplements productDAO=new ProductDAOImplements(entityManager);
	Long pk;
	
	public long add(ProductEntity bean) throws DuplicateRecordException{
		
		try {
			
			ProductEntity productEntity=entityManager.find(ProductEntity.class, bean.getId());
		 	if(productEntity!=null)
			{
				throw new DuplicateRecordException("Product already exists.");
			}
			else
			{
				transaction.begin();
				pk=productDAO.add(bean);
				transaction.commit();
			}
		}catch(DuplicateRecordException exception)
		{
			System.out.println(exception.getMessage());
		}
		return pk;
	}
	
	public void update(ProductEntity bean) throws DuplicateRecordException{
		
		try {
			ProductEntity productEntity=entityManager.find(ProductEntity.class, bean.getId());
			if(productEntity!=null)
			{
				throw new DuplicateRecordException("Product not found.");
			}
			else
			{
				transaction.begin();
				productDAO.add(bean);
				transaction.commit();
			}
		}catch(DuplicateRecordException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public void delete(ProductEntity bean){
		ProductEntity productEntity=entityManager.find(ProductEntity.class, bean.getId());
		
		transaction.begin();
		productDAO.delete(productEntity);
		transaction.commit();
	}
	
	public ProductEntity findByName(String name) {
		
		return productDAO.findByName(name);
	}
	
	public ProductEntity findByCode(String code) {
		
		return productDAO.findByCode(code);
		
	}
	
	public ProductEntity findByPk(long id) {
		
		return productDAO.findByPk(id);
		
	}
	
	public List<ProductEntity> search(ProductEntity bean, long pageNo, int pageSize){
		return null;
	}
	
	public List<ProductEntity> search(ProductEntity bean){
		
		return productDAO.search(bean);
		 
	}
	
	public Blob getImageById(long id) throws SerialException, SQLException{
	
		return productDAO.getImageById(id);
	
	}

}