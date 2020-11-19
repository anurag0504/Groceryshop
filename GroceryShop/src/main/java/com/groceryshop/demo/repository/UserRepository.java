package com.groceryshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groceryshop.demo.entitites.UserEntity;
/**
 * UserRepository
 * <p>
 * In This method we are sending userEntity object as the parameter.
 * with the help of JpaRepository we are finding if the object sent findById is present in the database or not by using the
 * Long.
 * </p>
 * @param bean
 * @return ResponseEntity<UserEntity>
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


}
