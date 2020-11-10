package com.cg.gsm.app.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import com.cg.gsm.app.entities.ProductEntity;
import com.cg.gsm.app.exception.DuplicateRecordException;

public interface ProductServiceInt {

public long add(ProductEntity bean) throws DuplicateRecordException;
	
	public ProductEntity update(ProductEntity bean) throws DuplicateRecordException;
	
	public boolean delete(ProductEntity bean);
	
	public List<ProductEntity> findByName(String name);
	
	public List<ProductEntity> findByProductCode(String code);
	
	public ProductEntity findByPk(long id);
	
	public List<ProductEntity> search(ProductEntity bean, long pageNo, int pageSize);
	
	public List<ProductEntity> search(ProductEntity bean);
	
	public Blob getImageById(long id) throws SerialException, SQLException;
	
}
