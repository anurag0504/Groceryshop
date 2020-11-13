package com.groceryshop.demo.controller;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.groceryshop.demo.controller.OrderController;
import com.groceryshop.demo.entitites.OrderEntity;

@SpringBootTest
class OrderControllerTest {
     

    @Mock
 OrderController orderController;
    
    OrderEntity orderEntity=new OrderEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),1,"Choclate", null, null, null, null, null, null, null, null, 0, null, null, null);
    ResponseEntity<OrderEntity> responseEntity =new ResponseEntity<OrderEntity>(orderEntity,HttpStatus.OK);
     
    
    
    @Test
    void testAddOrder()  {
        when(orderController.addOrderEntity(orderEntity)).thenReturn(responseEntity);
        Object response=orderController.addOrderEntity(orderEntity);
        assertEquals(responseEntity,response);
    }

    
    @Test
    void testUpdateOrder(){
        when(orderController.updateOrderEntity(orderEntity)).thenReturn(responseEntity);
        Object response=orderController.updateOrderEntity(orderEntity);
        assertEquals(responseEntity,response);
    }
    

    @Test
    void testDeleteOrder() {
        when(orderController.addOrderEntity(orderEntity)).thenReturn(responseEntity); 
        Object response=orderController.addOrderEntity(orderEntity);
        assertEquals(responseEntity,response);
    }

    
    @Test
    void testFindByName() {
        when(orderController.findByNameOrderEntity(orderEntity.getName())).thenReturn(orderEntity);
        Object response=orderController.findByNameOrderEntity(orderEntity.getName());
        assertEquals(responseEntity,response);
       
    }

    @Test
    void testFindByOrderId1() {
        when(orderController.FindByOrderId1(orderEntity.getId())).thenReturn(responseEntity);
        Object response=orderController.FindByOrderId1(orderEntity.getId());
        assertEquals(responseEntity,response);
    }

    @Test
    void testSearch() {
        OrderEntity orderEntity1=new OrderEntity("Admin","Admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),2,"Stationary", null, null, null, null, null, null, null, null, 0, null, null, null);
        List<OrderEntity> orders=new ArrayList<OrderEntity>();
        orders.add(orderEntity1);
       orders.add(orderEntity);
        when(orderController.search()).thenReturn(orders);
        Object response=orderController.search();
        assertEquals(orders,response);
    }

}