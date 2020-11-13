package com.cg.gsm.app.controllers;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import javax.sql.rowset.serial.SerialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.gsm.app.entities.ProductEntity;
import com.cg.gsm.app.exception.DuplicateRecordException;
import com.cg.gsm.app.exception.RecordNotFoundException;
import com.cg.gsm.app.service.ProductServiceImplements;

@RestController
public class ProductController {

    @Autowired
    ProductServiceImplements service;

    @RequestMapping("/")
    public String check() {
        return "home";
    }

    /**
     * addProduct
     * <p>
     * It adds a product
     * </p>
     * 
     * @param bean
     * @return ResponseEntity<ProductEntity>
     * @Throws DuplicateRecordException in case if we add the product with same
     *         primary key
     */
    @PostMapping("/add")
    public ResponseEntity<ProductEntity> addProduct(@RequestBody ProductEntity bean) {
        Long id = service.add(bean);
        if (id != 0) {
            return new ResponseEntity<ProductEntity>(service.findByPk(id), HttpStatus.OK);
        } else {
            throw new DuplicateRecordException("ID already exists");
        }
    }

    /**
     * updateProduct
     * <p>
     * It updates a product which is already exists
     * </p>
     * 
     * @param bean
     * @return ResponseEntity<ProductEntity>
     * @Throws RecordNotFoundException in case if the product is not available
     */
    @PutMapping("/update")
    public ResponseEntity<ProductEntity> updateProduct(@RequestBody ProductEntity bean) {
        if (service.update(bean).getId() == 0) {
            throw new RecordNotFoundException("Record not found");
        } else {
            return new ResponseEntity<ProductEntity>(service.update(bean), HttpStatus.OK);
        }
    }

    /**
     * DeleteProduct
     * <p>
     * It updates a product which is already exists
     * </p>
     * 
     * @param bean
     * @return ResponseEntity<ProductEntity>
     * @Throws RecordNotFoundException in case if the product is not available with
     *         the specified key
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProductEntity> deleteProduct(@PathVariable Long id) {
        ProductEntity product = service.findByPk(id);
        if (service.delete(id)) {
            return new ResponseEntity<ProductEntity>(product, HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("Record not found with id:" + id);
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
    @GetMapping("/findByName/{name}")
    public List<ProductEntity> findByName(@PathVariable String name) {
        return service.findByName(name);
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
    @GetMapping("/findByProductCode/{code}")
    public List<ProductEntity> findByProductCode(@PathVariable String code) {
        System.out.println(code);
        return service.findByProductCode(code);
    }

    /**
     * findByPk
     * <p>
     * finding a product with its primary key
     * </p>
     * 
     * @param bean
     * @return Response<ProductEntity>
     * @Throws RecordNotFoundException in case if the product is not available with
     *         the specified key
     */
    @GetMapping("/findByPk/{id}")
    public ResponseEntity<ProductEntity> findByPk(@PathVariable Long id) {
        if (service.findByPk(id) == null) {
            throw new RecordNotFoundException("Record not found with id:" + id);
        } else {
            return new ResponseEntity<ProductEntity>(service.findByPk(id), HttpStatus.OK);
        }
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
    @GetMapping("/search")
    public List<ProductEntity> search(@RequestBody ProductEntity bean) {
        return service.search(bean);
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
    @GetMapping("/image/{id}")
    public Blob getImageById(@PathVariable Long id) throws SerialException, SQLException {
        return service.getImageById(id);
    }
}
