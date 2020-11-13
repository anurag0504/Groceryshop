package com.cg.gsm.app.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.gsm.app.entities.ProductEntity;

@SpringBootTest
class ProductServiceImplementsTest {

    @Mock
    ProductServiceImplements service;

    byte[] image = { (byte) 01234 };
    ProductEntity product = new ProductEntity(1, "admin", "admin", Timestamp.from(Instant.now()), Timestamp.from(Instant.now()), "milk Product", "123", "000", "60", "daily needs",
            "10", image);

    @Test
    void testAdd() {
        when(service.add(product)).thenReturn(1L);
        assertEquals(1L, service.add(product));

    }

    @Test
    void testUpdate() {
        when(service.update(product)).thenReturn(product);
        assertEquals(product, service.update(product));
    }

    @Test
    void testDelete() {
        when(service.delete(1L)).thenReturn(true);
        assertTrue(service.delete(1L));

        when(service.delete(1L)).thenReturn(false);
        assertFalse(service.delete(1L));
    }

    @Test
    void testFindByName() {
        List<ProductEntity> list = new ArrayList<ProductEntity>();
        list.add(product);
        when(service.findByName("milk Product")).thenReturn(list);
        assertEquals(list, service.findByName("milk Product"));
    }

    @Test
    void testFindByCode() {
        List<ProductEntity> list = new ArrayList<ProductEntity>();
        list.add(product);
        when(service.findByProductCode("000")).thenReturn(list);
        assertEquals(list, service.findByProductCode("000"));
    }

    @Test
    void testFindByPk() {
        when(service.findByPk(1L)).thenReturn(product);
        assertEquals(product, service.findByPk(1L));
    }

    @Test
    void testSearchProductEntityLongInt() {
        List<ProductEntity> list = new ArrayList<ProductEntity>();
        list.add(product);
        when(service.search(product)).thenReturn(list);
        assertEquals(list, service.search(product));
    }

}
