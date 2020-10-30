package com.cg.gsm.repository;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import com.cg.gsm.entities.ProductEntity;
import com.cg.gsm.entities.UserEntity;
import com.cg.gsm.exception.DuplicateRecordException;

public class ProductDAOImplements implements ProductDAOInt{
	
	EntityManager entityManager;
	public ProductDAOImplements(){
		
	}
	public ProductDAOImplements(EntityManager entityManager)
	{
		this.entityManager=entityManager;
	}
	
	public long add(ProductEntity bean) throws DuplicateRecordException {
		
		
		/*
		 * adding a product into product entity if the entity is present in table then throw a user defined DeplicatRecordException
		 */
		
		entityManager.persist(bean);
		Query query=entityManager.createQuery("SELECT productEntity from ProductEntity productEntity where prodcutEntity.getEmailId="+bean.getCode());
	    UserEntity userEntity=(UserEntity)query.getSingleResult();
	    return userEntity.getId();	
	}
	
	public void update(ProductEntity bean) throws DuplicateRecordException {
		
		
		/*
		 * updating a parameter of product entity
		 */
		
		ProductEntity productEntity=entityManager.find(ProductEntity.class, bean.getId());
		entityManager.merge(productEntity);	
		
	}
	
	public boolean delete(ProductEntity bean) {
		
		/*
		 * deleting a record of product entity
		 */
		
		entityManager.remove(bean);
		
		ProductEntity productEntity=entityManager.find(ProductEntity.class, bean.getId());
		if(productEntity==null)
		{
			return true;
		}
		return false;
		
	}
	
	public ProductEntity findByName(String name) {
		
		
		/*
		 * searching a record by using name as a parameter
		 */
		
		Query query=entityManager.createQuery("SELECT productEntity from ProductEntity productEntity where name=:name",ProductEntity.class);
		query.setParameter("name", name);
		
		ProductEntity productEntity=(ProductEntity)query.getSingleResult();
		if(productEntity!=null)
		{
			return productEntity;
		}else
		{
			return null;
		}
		
		
	}
	
	public ProductEntity findByCode(String code) {
		
		/*
		 * searching a record by using code as a parameter
		 */
		
		Query query=entityManager.createQuery("SELECT productEntity from ProductEntity productEntity where productEntity.getCode()=:code",ProductEntity.class);
		query.setParameter("code", code);
		ProductEntity productEntity=(ProductEntity)query.getSingleResult();
		if(productEntity!=null)
		{
			return productEntity;
		}else
		{
			return null;
		}
		
	}
	
	public ProductEntity findByPk(long id) {
		
		/*
		 * searching a record by using passing primary key 
		 */
		
		ProductEntity productEntity= entityManager.find(ProductEntity.class, id);
		if(productEntity!=null)
		{
			return productEntity;
		}else
		{
			return null;
		}
		
	}
	
	public List<ProductEntity> search(ProductEntity bean, long pageNo, int pageSize){
		return null;
	}
	
	public List<ProductEntity> search(ProductEntity bean){
		
		/*
		 * searching a list of records by using any parameter of the object
		 */
		
		Query query=entityManager.createQuery("SELECT productEntity from ProductEntity productEntity",ProductEntity.class);
		ArrayList<ProductEntity> productList=new ArrayList<ProductEntity>(query.getResultList());
		return productList;
	}
	
	public Blob getImageById(long id) throws SerialException, SQLException{
		
		ProductEntity productEntity=entityManager.find(ProductEntity.class,id);
		Blob blob=new SerialBlob(productEntity.getImage());
		return blob;
		
	}

}