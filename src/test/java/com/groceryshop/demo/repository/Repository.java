package com.groceryshop.demo.repository;




import static org.junit.jupiter.api.Assertions.*;
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
import com.groceryshop.demo.entitites.OrderEntity;
import com.groceryshop.demo.repository.OrderRepository;

@SpringBootTest
class OrderRepositoryTest {
 
    @InjectMocks
    
    @Mock
    OrderRepository repository;
    OrderEntity orderEntity=new OrderEntity("Admin","admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),12,"dairymilk","shynu","shynu@gmail.com","7989581230","india","malkajgiri","mallampet","500090","abc",2,"6","100",new Date());
     
   

//    @Test 
//    void testFindById() {
//        when(repository.findById(orderEntity.getProductId())).thenReturn(orderEntity);
//        assertEquals(orderEntity,repository.findById(orderEntity.getProductId()));
//    }

    @Test
    void testSave() {
        when(repository.save(orderEntity)).thenReturn(orderEntity);
        assertEquals(orderEntity,repository.save(orderEntity));   
    }

    
   

    @Test
    void testDelete() {
        repository.delete(orderEntity);
        verify(repository,times(1)).delete(orderEntity);
    }
}
