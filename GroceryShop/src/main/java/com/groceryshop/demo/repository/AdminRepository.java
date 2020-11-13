package com.groceryshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceryshop.demo.entitites.AdminEntity;
/**
 * AdminRepository
 * <p>
 * In This method we are sending adminEntity object as the parameter.
 * with the help of JpaRepository we are finding if the object sent findByLoginId is present in the database or not by using the
 * Integer.
 * </p>
 * @param bean
 * @return ResponseEntity<AdminEntity>
 */
public interface AdminRepository extends JpaRepository<AdminEntity, Integer>{




}
