package com.cg.gsm.app.service;

import java.awt.print.Pageable;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gsm.app.entities.ProductEntity;
import com.cg.gsm.app.repository.ProductDAOInt;

@Service
public class ProductServiceImplements implements ProductServiceInt {

    @Autowired
    ProductDAOInt repo;

    /**
     * addProduct
     * <p>
     * It adds a product into table and returns primary key
     * </p>
     * 
     * @param bean
     * @return long
     */
    public long add(ProductEntity bean) {
        if (repo.existsById(bean.getId())) {
            return 0;
        } else {
            return repo.save(bean).getId();
        }
    }

    /**
     * updateProduct
     * <p>
     * It updates a product which is already exists
     * </p>
     * 
     * @param bean
     * @return ProductEntity
     */

    public ProductEntity update(ProductEntity bean) {
        if (repo.existsById(bean.getId())) {
            return repo.save(bean);
        } else {
            return new ProductEntity();
        }
    }

    /**
     * DeleteProduct
     * <p>
     * It updates a product which is already exists
     * </p>
     * 
     * @param bean
     * @return ProductEntity
     */
    public boolean delete(Long id) {

        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * findByName
     * <p>
     * Retrieving the products with name as a parameter
     * </p>
     * 
     * @param bean
     * @return List<ProductEntity>
     */

    public List<ProductEntity> findByName(String name) {

        List<ProductEntity> products;
        products = repo.findByName(name);
        return products;
    }

    /**
     * findByProductCode
     * <p>
     * Retrieving the products with productCode as a parameter
     * </p>
     * 
     * @param bean
     * @return List<ProductEntity>
     */
    public List<ProductEntity> findByProductCode(String code) {

        List<ProductEntity> products;
        products = repo.findByProductCode(code);
        return products;
    }

    /**
     * findByPk
     * <p>
     * finding a product with its primary key
     * </p>
     * 
     * @param bean
     * @return ProductEntity
     */
    public ProductEntity findByPk(long id) {
        return repo.findById(id).orElse(null);
    }

    /**
     * search
     * <p>
     * searching for products with product as a parameter
     * </p>
     * 
     * @param bean
     * @return List<ProductEntity>
     */
    public List<ProductEntity> search(ProductEntity bean) {
        List<ProductEntity> products = repo.findByName(bean.getName());
        return products;
    }

    /**
     * getImageById
     * <p>
     * Retrieving an image associated with primary key
     * </p>
     * 
     * @param id
     * @return Blob(Binary large object)
     * @throws SerialException
     * @throws SQLException
     */
    public Blob getImageById(long id) throws SerialException, SQLException {
        Blob blob = new SerialBlob(repo.findById(id).get().getImage());
        return blob;
    }

    @Override
    public List<ProductEntity> search(ProductEntity bean, Pageable page) {
        return null;
    }

}
