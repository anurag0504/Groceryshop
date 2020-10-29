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
	public ProductDAOImplements(EntityManager entityManager)
	{
		this.entityManager=entityManager;
	}
	
	public long add(ProductEntity bean) throws DuplicateRecordException {
		
		entityManager.persist(bean);
		Query query=entityManager.createQuery("SELECT productEntity from ProductEntity productEntity where prodcutEntity.getEmailId="+bean.getCode());
	    UserEntity userEntity=(UserEntity)query.getSingleResult();
	    return userEntity.getId();	
	}
	
	public void update(ProductEntity bean) throws DuplicateRecordException {
		
		ProductEntity productEntity=entityManager.find(ProductEntity.class, bean.getId());
		entityManager.merge(productEntity);
		
		//productEntity.setId(bean.getId());
		/*productEntity.setCreatedBy(bean.getCreatedBy());
		productEntity.setModifiedBy(bean.getModifiedBy());
		productEntity.setCreatedDateTime(bean.getCreatedDateTime());
		productEntity.setModifiedDateTime(bean.getModifiedDateTime());
		productEntity.setName(bean.getName());
		productEntity.setCode(bean.getCode());
		productEntity.setPrice(bean.getPrice());
		productEntity.setDescription(bean.getDescription());
		productEntity.setQuantity(bean.getQuantity());
		productEntity.setImage(bean.getImage());
		*/
		
	}
	
	public void delete(ProductEntity bean) {
		
		entityManager.remove(bean);
		
	}
	
	public ProductEntity findByName(String name) {
		
		Query query=entityManager.createQuery("SELECT productEntity from ProductEntity productEntity where productEntity.getName()==name",ProductEntity.class);
		return (ProductEntity)query.getSingleResult();
	}
	
	public ProductEntity findByCode(String code) {
		
		Query query=entityManager.createQuery("SELECT productEntity from ProductEntity productEntity where productEntity.getCode()==code",ProductEntity.class);
		return (ProductEntity)query.getSingleResult();
		
	}
	
	public ProductEntity findByPk(long id) {
		
		return entityManager.find(ProductEntity.class, id);
		
	}
	
	public List<ProductEntity> search(ProductEntity bean, long pageNo, int pageSize){
		return null;
	}
	
	public List<ProductEntity> search(ProductEntity bean){
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