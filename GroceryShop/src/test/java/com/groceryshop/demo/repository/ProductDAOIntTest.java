package com.cg.gsm.app.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.gsm.app.entities.ProductEntity;

@SpringBootTest
class ProductDAOIntTest {

    ProductDAOInt productDao = mock(ProductDAOInt.class);

    byte[] image = { (byte) 01234 };
    ProductEntity product = new ProductEntity(1, "admin", "admin", Timestamp.from(Instant.now()), Timestamp.from(Instant.now()), "milk Product", "123", "000", "60", "daily needs",
            "10", image);
    List<ProductEntity> list = new ArrayList<ProductEntity>();
    List<ProductEntity> list1 = new ArrayList<ProductEntity>();
    Optional<ProductEntity> productEntity = Optional.of(product);

    @Test
    void testFindByName() {
        list.add(product);
        when(productDao.findByName(product.getName())).thenReturn(list);
        assertEquals(list, productDao.findByName(product.getName()));
        assertNotEquals(list1, productDao.findByName(product.getName()));
    }

    @Test
    void testFindByProductCode() {
        list.add(product);
        when(productDao.findByProductCode(product.getProductCode())).thenReturn(list);
        assertEquals(list, productDao.findByProductCode(product.getProductCode()));
        assertNotEquals(list1, productDao.findByProductCode(product.getProductCode()));
    }

    @Test
    void testSave() {
        when(productDao.save(product)).thenReturn(product);
        assertEquals(product, productDao.save(product));
        assertNotEquals(new ProductEntity(), productDao.save(product));
    }

    @Test
    void testFindById() {
        when(productDao.findById(product.getId())).thenReturn(productEntity);
        assertEquals(productEntity, productDao.findById(product.getId()));
        assertNotEquals(new ProductEntity(), productDao.findById(product.getId()));
    }

    @Test
    void deleteById() {
        productDao.deleteById(product.getId());
        verify(productDao, times(1)).deleteById(product.getId());
    }

}
