package com.cg.gsm.app.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gsm.app.entities.ProductEntity;
import com.cg.gsm.app.exception.DuplicateRecordException;
import com.cg.gsm.app.exception.RecordNotFoundException;
import com.cg.gsm.app.repository.ProductDAOInt;

@Service
public class ProductServiceImplements implements ProductServiceInt{
	
	@Autowired
	ProductDAOInt repo;
	
	public long add(ProductEntity bean) throws DuplicateRecordException {
		ProductEntity product;
		if(repo.existsById(bean.getId()))
		{
			throw new DuplicateRecordException("Duplicate record found");
		}
		else {
			product=repo.save(bean);
		}
		return product.getId();
	}

	
	public ProductEntity update(ProductEntity bean){
		ProductEntity product;
		if(repo.existsById(bean.getId()))
		{
			product=repo.save(bean);
		}
		else
		{
			throw new RecordNotFoundException("No record found with id:"+bean.getId());
		}
		return product;
	}

	
	public boolean delete(ProductEntity bean) {
		
		if(repo.existsById(bean.getId()))
		{
			repo.deleteById(bean.getId());
			return true;
		}
		else
		{
			throw new RecordNotFoundException("No record found with id:"+bean.getId()+"to delete");
		}
	}

	
	public List<ProductEntity> findByName(String name) {
		
		List<ProductEntity> products;
		products=repo.findByName(name);
		return products;
	}

	
	public List<ProductEntity> findByProductCode(String code) {
		
		List<ProductEntity> products;
		products=repo.findByProductCode(code);
		return products;
	}

	
	public ProductEntity findByPk(long id) {
		return repo.findById(id).orElseThrow(()->new RecordNotFoundException("No Record found with id:"+id));
	}

	public List<ProductEntity> search(ProductEntity bean, long pageNo, int pageSize) {
		
		return null;
	}

	
	public List<ProductEntity> search(ProductEntity bean) {
		List<ProductEntity> products=repo.findByName(bean.getName());
		return products;
	}

	
	public Blob getImageById(long id) throws SerialException, SQLException {
		Blob blob=new SerialBlob(repo.findById(id).get().getImage());
		return blob;
	}

}
