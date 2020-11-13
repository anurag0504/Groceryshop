package com.groceryshop.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.groceryshop.demo.entitites.CategoryEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;
import com.groceryshop.demo.exception.RecordNotFoundException;
import com.groceryshop.demo.repository.CategoryRepository;
import com.groceryshop.demo.service.CategoryServiceImp;

@RestController
public class CategoryController {

    @Autowired
    public CategoryServiceImp categoryServiceImp;

    @Autowired
    public CategoryRepository repository;

    /**
     * addCategory.
     * <p>
     * In this method we are sending the categoryEntity object as the parameter.
     * With the help of CategoryServiceImp we are finding if the object sent is
     * present in the database or not by using the method findByCategoryId(). If the
     * category is present then we are throwing the Duplicate Record Exception or
     * else we are adding the category object to the database using add() and
     * returning the ResponseEntity.
     * 
     * </p>
     * 
     * @param bean
     * @return ResponseEntity<CategoryEntity>
     */
    @PostMapping(path = "/addCategory")
    public ResponseEntity<CategoryEntity> addCategory(@RequestBody CategoryEntity bean) {
        CategoryEntity category = categoryServiceImp.findByCategoryId(bean.getCategoryId());
        if (category != null) {
            throw new DuplicateRecordException("Category already exists with ID: " + bean.getCategoryId());
        } else {
            categoryServiceImp.addCategory(bean);
            return new ResponseEntity<CategoryEntity>(bean, HttpStatus.OK);
        }
    }

    /**
     * updateCategory.
     * <p>
     * In this method we are sending the categoryEntity object as the parameter.
     * With the help of CategoryServiceImp we are finding if the object sent is
     * present in the database or not by using the method findByCategoryId(). If the
     * category is present then we are throwing the Duplicate Record Exception or
     * else we are adding the category object to the database using add() and
     * returning the ResponseEntity.
     * 
     * </p>
     * 
     * @param bean
     * @return ResponseEntity<CategoryEntity>
     */

    @PutMapping(path = "/updateCategory")
    public ResponseEntity<CategoryEntity> updateCategory(@RequestBody CategoryEntity bean) {
        CategoryEntity category = categoryServiceImp.findByCategoryId(bean.getCategoryId());
        if (category != null) {
            categoryServiceImp.updateCategory(bean);
            return new ResponseEntity<CategoryEntity>(bean, HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("Category does not exists with ID: " + bean.getCategoryId());
        }

    }

    /**
     * deleteCategory
     * 
     * <p>
     * In this method we are sending the categoryEntity object as the parameter.
     * With the help of CategoryServiceImp we are calling the delete method to delete the category.
     * If the category is deleted then return value is true else the return value is false
     * If the value is true then we are returning the ResponseEntity or else we are throwing the  
     * RecordNotfound Exception .
     * </p>
     * @param bean
     * @return ResponseEntity<CategoryEntity>
     */
    @DeleteMapping(path = "/delete")
    public ResponseEntity<CategoryEntity> deleteCategory(@RequestBody CategoryEntity bean) {

        boolean delete = categoryServiceImp.deleteCategory(bean);
        if (delete) {
            return new ResponseEntity<CategoryEntity>(bean, HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("No record found with the given details");
        }

    }

    /**
     * findByName
     * <p>
     * In this method we are giving the category name as the parameter.
     * With the help of CategoryServiceImp we are calling the findByCategoryname,
     * if the category is found then we return ResponseEntity<CategoryEntity> else
     * then we throw the RecordNotFoundException with message "No category is present with name".  
     * </p>
     * 
     * @param name
     * @return ResponseEntity<CategoryEntity>
     */
    @GetMapping(path = "/categoryname/{name}")
    public ResponseEntity<CategoryEntity> findByName(@PathVariable String name) {

        CategoryEntity category = categoryServiceImp.findByCategoryname(name);
        if (category != null) {
            return new ResponseEntity<CategoryEntity>(category, HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("No category is present with name: " + name);
        }
    }

    /**
     * findByCategoryId
     * <p>
     * In this method we are giving the category id as the parameter.
     * With the help of CategoryServiceImp we are calling the findByCategoryId,
     * if the category is found then we return ResponseEntity<CategoryEntity> else
     * then we throw the RecordNotFoundException with message "No category is present with categoryId". 
     * </p>
     * @param id
     * @return ResponseEntity<CategoryEntity>
     */
    @GetMapping(path = "/categorycode/{id}")
    public ResponseEntity<CategoryEntity> findByCategoryId(@PathVariable Integer id) {
        CategoryEntity category = categoryServiceImp.findByCategoryId(id);
        if (category != null) {
            return new ResponseEntity<CategoryEntity>(category, HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("No category is present with catgoryId: " + id);
        }
    }

    
    /**
     * search
     * <p>
     * In this method we are displaying all the categories with the help of search method from categoryServiceImp.
     * This search method data is stored in the list. 
     * If the list is empty then we throw RecordNotFoundException else we return category list.
     * </p>
     * 
     * @return List<CategoryEntity>
     */
    @GetMapping(path = "/category")
    public List<CategoryEntity> search() {
        List<CategoryEntity> category = categoryServiceImp.search();
        if (category.isEmpty()) {
            throw new RecordNotFoundException("No records found");
        } else {
            return category;
        }

    }
   
}
