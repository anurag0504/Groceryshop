package com.groceryshop.demo.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groceryshop.demo.entitites.CategoryEntity;
import com.groceryshop.demo.repository.CategoryRepository;

@Service
public class CategoryServiceImp implements CategoryServiceInt {
    @Autowired 
    public CategoryRepository categoryRepository; 

    /**
     * addCategory
     * <p>
     * We are giving CategoryEntity object as input.
     * Using CategoryRepository we call the save method which saves(add) the given entity. 
     * Returning the categoryId .
     * </p>
     * return category.getId() [long]
     */
    public long addCategory(CategoryEntity bean) 
    {

        CategoryEntity category=categoryRepository.save(bean);
        return category.getId(); 

    }

    /**
     * updateCategory
     * <p>
     * We are giving CategoryEntity object as input.
     * Using CategoryRepository we call the save method which saves(update) the given entity. 
     * Returning the category
     * </p>
     * return category[CategoryEntity]
     */
    public CategoryEntity updateCategory(CategoryEntity bean) 
    {
        CategoryEntity category=categoryRepository.save(bean);
        return category;

    }

    /**
     * deleteCategory
     * <p>
     * We are giving CategoryEntity object as input.
     * Using CategoryRepository we call the delete method which deletes the given entity. 
     * If deleted successfully then it return true else it returns false, we check this by using 
     * findByCategoryName method from repository giving the category name as the input which we have deleted.
     * </p>
     * return boolean
     */
    public boolean deleteCategory(CategoryEntity bean)
    {
        categoryRepository.delete(bean);

        CategoryEntity category=categoryRepository.findByCategoryName(bean.getCategoryName());
        if(category==null)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    /**
     * findByCategoryname
     * <p>
     * We are giving name of the category as input.
     * Using CategoryRepository we call the method findByCategoryName which searches for the category with that
     * name and return the category.
     * </p>
     * return category [CategoryEntity]
     */
    public CategoryEntity findByCategoryname(String name) {
        CategoryEntity category=categoryRepository.findByCategoryName(name);
        return category; 

    }

    /**
     * findByCategoryId
     * <p>
     * We are giving id of the category as input.
     * Using CategoryRepository we call the method findByCategoryId which searches for the category with that
     * Id and return the category.
     * </p>
     * return category [CategoryEntity]
     */
    public CategoryEntity findByCategoryId(Integer id)
    {
        CategoryEntity category=categoryRepository.findByCategoryId(id);
        return category;

    }

    /**
     * search
     * <p>
     * Using CategoryRepository we call the method findAll which Returns all instances of the category as a list.
     * </p>
     * return List<CategoryEntity>
     */
    public List<CategoryEntity> search()
    {
        return (List<CategoryEntity>) categoryRepository.findAll();

    }

   
}
