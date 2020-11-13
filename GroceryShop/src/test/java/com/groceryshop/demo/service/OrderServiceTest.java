package com.groceryshop.demo.service;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.groceryshop.demo.entitites.OrderEntity;
import com.groceryshop.demo.exception.DuplicateRecordException;


@SpringBootTest
class OrderServiceImpTest {
 
    
    @Mock
    
    @InjectMocks
    OrderServiceImp orderServiceImp;
    
    OrderEntity orderEntity=new OrderEntity("Admin","admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),12,"dairymilk","shynu","shynu@gmail.com","7989581230","india","malkajgiri","mallampet","500090","abc",2,"6","100",new Date());
    
    
    @Test
    void testAdd() throws DuplicateRecordException {
        when(orderServiceImp.add(orderEntity));
        assertEquals(orderEntity.getId(),orderServiceImp.add(orderEntity));
    }
 
    @Test
    void testUpdate() throws DuplicateRecordException {
        
        orderEntity.setName("biscuits");
        when(orderServiceImp.update(orderEntity)).thenReturn(orderEntity.getId());
        assertEquals(orderEntity.getId(),orderServiceImp.update(orderEntity)); 
        

    }

    @Test
    void testDelete() {
        orderServiceImp.delete(orderEntity);
        verify(orderServiceImp,times(1)).delete(orderEntity);
    }
  
    @Test
    void testFindByName() {
        when(orderServiceImp.findByName("Choclate")).thenReturn(orderEntity);
        assertEquals(orderEntity,orderServiceImp.findByName("Choclate"));
    }

    @Test
    void testFindById() {
        when(orderServiceImp.findByOrderId(1)).thenReturn(orderEntity);
        assertEquals(orderEntity,orderServiceImp.findByOrderId(1));
    }

    

    @Test
    void testSearchOrderEntity() {
        OrderEntity orderEntity1=new OrderEntity("Admin","admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),12,"dairymilk","shynu","shynu@gmail.com","7989581230","india","malkajgiri","mallampet","500090","abc",2,"6","100",new Date());
        List<OrderEntity> order=new ArrayList<OrderEntity>();
        order.add(orderEntity);
        order.add(orderEntity1);
        when(orderServiceImp.search(orderEntity)).thenReturn(order);
        assertEquals(order,orderServiceImp.search(orderEntity));
    }

    @Test
    void testGetImageById() {
        fail("Not yet implemented");
    }

}