package com.groceryshop.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groceryshop.demo.entitites.OrderEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;
import com.groceryshop.demo.exception.RecordNotFoundException;
import com.groceryshop.demo.service.OrderServiceImp;

@RestController

public class OrderController {

    @Autowired
    public OrderServiceImp orderServiceImp;

    
    /**
     * addOrderEntity
     * <p>
     * In This method we are sending orderEntity object as the parameter.
     * with the help of OrderServiceImp we are finding if the object sent is present in the database or not by using the
     * method findbyname().Ifthe
     * order is present then we are throwing the duplicate record Exception or
     * else we are adding the order object to database using add()and returning the ResponseEntity.  
     * </p>
     * @param bean
     * @return ResponseEntity<OrderEntity>
     */
    @PostMapping("/addOrderEntity")
    public ResponseEntity<OrderEntity> addOrderEntity(@RequestBody OrderEntity bean) {
        long id = orderServiceImp.add(bean);
        OrderEntity order = orderServiceImp.findByName(bean.getName());
        if (order != null) {
            return new ResponseEntity<OrderEntity>(bean, HttpStatus.OK);
        } else {
            throw new DuplicateRecordException("Order available with ID:" + bean.getId());

        }

    }
    /**
     * deleteOrderEntity
     * <p>
     * In This method we are sending orderEntity object as the parameter.
     * with the help of OrderServiceImp we are finding if the object sent is present in the database or not by using the
     * method findByPk().Ifthe
     * order is present then we are throwing the duplicate record Exception or
     * else we are deleting the order object to database using delete()and returning the ResponseEntity.  
     * </p>
     * @param bean
     * @return ResponseEntity<OrderEntity>
     */

    @DeleteMapping("/deleteOrderEntity/{id}")
    public ResponseEntity<OrderEntity> deleteOrderEntity(@PathVariable long id)  {
        OrderEntity order = orderServiceImp.findByPk(id);
        if (order != null) {
            return new ResponseEntity<OrderEntity>(order, HttpStatus.OK);
        } else {

            throw new RecordNotFoundException("NotFound");
        }
    }
    
    /**
     * updateOrderEntity
     * <p>
     * In This method we are sending orderEntity object as the parameter.
     * with the help of OrderServiceImp we are finding if the object sent is present in the database or not by using the
     * method findByPk().Ifthe order is present then we are throwing the duplicate record Exception or
     * else we are deleting the order object to database using update()and returning the ResponseEntity.  
     * </p>
     * @param bean
     * @return ResponseEntity<OrderEntity>
     */

    @PutMapping("/updateOrderEntity")
    public ResponseEntity<OrderEntity> updateOrderEntity(@RequestBody OrderEntity bean) 
    {
        OrderEntity order = orderServiceImp.findByPk(bean.getId());
        try {
            if (order == null) {
                throw new RecordNotFoundException("order can not be empty....");
            }
        } catch (RecordNotFoundException recordNotFoundException) {
            System.out.println(recordNotFoundException.getMessage());
        }
        orderServiceImp.update(bean);
        return new ResponseEntity<OrderEntity>(bean, HttpStatus.OK);
    }
    /**
     * findByNameOrderEntity
     * <p>
     * In This method we are sending orderEntity object as the parameter.
     * with the help of OrderServiceImp we are finding if the object sent is present in the database or not by using the
     * method findByName().Ifthe order is present then we are throwing the duplicate record Exception or
     * else we are deleting the order object to database using delete()and returning the ResponseEntity.  
     * </p>
     * @param bean
     * @return ResponseEntity<OrderEntity>
     */


    @PutMapping("/findByNameOrderEntity")
    public OrderEntity findByNameOrderEntity(@RequestBody String name) {
        OrderEntity order = orderServiceImp.findByName(name);
        try {
            if (order == null) {
                throw new RecordNotFoundException("Not Null Value allowed");
            }
        } catch (RecordNotFoundException recordNotFoundException) {
            System.out.println(recordNotFoundException.getMessage());
        }
        return order;
    }
    /**
     * findByPkOrderEntity
     * <p>
     * In This method we are sending orderEntity object as the parameter.
     * with the help of OrderServiceImp we are finding if the object sent is present in the database or not by using the
     * method findByPk().Ifthe order is present then we are throwing the duplicate record Exception or
     * else we are deleting the order object to database using delete()and returning the ResponseEntity.  
     * </p>
     * @param bean
     * @return ResponseEntity<OrderEntity>
     */


    @PutMapping("/findByPkOrderEntity")
    public OrderEntity findByIdOrderEntity(@RequestBody long id) {
        OrderEntity order = orderServiceImp.findByPk(id);
        try {
            if (order == null) {
                throw new RecordNotFoundException("Not Null Value allowed");
            }
        } catch (RecordNotFoundException recordNotFoundException) {
            System.out.println(recordNotFoundException.getMessage());
        }
        return order;
    }

    public Object search() {
        // TODO Auto-generated method stub
        return null;
    }

    public Object FindByOrderId11(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object FindByOrderId(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object FindByOrderId1(long id) {
        // TODO Auto-generated method stub
        return null;
    }
}
