package com.groceryshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groceryshop.demo.entitites.OrderEntity;
/**
 * OrderRepository
 * <p>
 * In This method we are sending orderEntity object as the parameter.
  * with the help of JpaRepository we are finding if the object sent findByName is present in the database or not by using the
 * String.
 * </p>
 * @param bean
 * @return ResponseEntity<OrderEntity>
 */

public interface OrderRepository extends JpaRepository<OrderEntity, Long> 
{
    OrderEntity findByName(String name);

    Object findByName(OrderEntity findByName);

}
