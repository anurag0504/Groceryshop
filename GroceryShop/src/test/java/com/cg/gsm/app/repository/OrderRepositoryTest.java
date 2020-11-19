package com.cg.gsm.app.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

 

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

 

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.groceryshop.demo.entitites.OrderEntity;
import com.groceryshop.demo.entitites.UserEntity;
import com.groceryshop.demo.repository.OrderRepository;

@SpringBootTest(classes =  OrderRepositoryTest.class)


public class OrderRepositoryTest {

 

    @Mock
   OrderRepository repository;
    OrderEntity orderEntity=new OrderEntity("Admin","admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),12,"dairymilk","shynu","shynu@gmail.com","7989581230","india","malkajgiri","mallampet","500090","abc",2,"6","100",new Date());
  
        @Test 
        void testFindAll() {
            OrderEntity orderEntity=new OrderEntity("Admin","admin",Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),12,"dairymilk","shynu","shynu@gmail.com","7989581230","india","malkajgiri","mallampet","500090","abc",2,"6","100",new Date());
            List<OrderEntity> orders=new ArrayList<OrderEntity>();
            orders.add(orderEntity);
            orders.add(orderEntity);
            when(repository.findAll()).thenReturn((List<OrderEntity>) orders);
            assertEquals(orders,repository.findAll());
        }

       
     

   
  /*   @Test
      void testFindByName() {
          list.add((OrderEntity) repository);
          when(repository.findByName(repository.findByName("shynu"))).thenReturn(list);
          assertEquals(list, repository.findByName(repository.findByName("shynu")));
          assertNotEquals(list1, repository.findByName(repository.findByName("shynu")));
      }*/

      

      @Test
       
      void testSave() {
          when(repository.save(orderEntity)).thenReturn(orderEntity);
          assertEquals(orderEntity,repository.save(orderEntity) );
      }

      @Test 
      void testDelete() {
          repository.delete(orderEntity);
          verify(repository,times(1)).delete(orderEntity);
      }
  }
    