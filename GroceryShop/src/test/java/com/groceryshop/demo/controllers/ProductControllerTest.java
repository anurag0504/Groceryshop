package com.cg.gsm.app.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cg.gsm.app.entities.ProductEntity;
import com.cg.gsm.app.exception.DuplicateRecordException;
import com.cg.gsm.app.exception.RecordNotFoundException;

class ProductControllerTest {

    ProductController controller = mock(ProductController.class);

    byte[] image = { (byte) 01234 };
    ProductEntity product = new ProductEntity(1, "admin", "admin", Timestamp.from(Instant.now()), Timestamp.from(Instant.now()), "milk Product", "123", "000", "60", "daily needs",
            "10", image);
    List<ProductEntity> list = new ArrayList<ProductEntity>();

    @Test
    void testAdd() {
        ResponseEntity<ProductEntity> response = new ResponseEntity<ProductEntity>(product, HttpStatus.OK);
        when(controller.addProduct(product)).thenReturn(response);
        assertEquals(response, controller.addProduct(product));

    }

    @Test
    void TestAddException() {
        when(controller.addProduct(product)).thenThrow(new DuplicateRecordException("ID already exists"));
        assertThrows(DuplicateRecordException.class, () -> {
            controller.addProduct(product);
        });
    }

    @Test
    void testUpdate() {
        ResponseEntity<ProductEntity> response = new ResponseEntity<ProductEntity>(product, HttpStatus.OK);
        when(controller.updateProduct(product)).thenReturn(response);
        assertEquals(response, controller.updateProduct(product));
    }

    @Test
    void testUpdateException() {
        when(controller.updateProduct(product)).thenThrow(new RecordNotFoundException("Record not found"));
        assertThrows(RecordNotFoundException.class, () -> {
            controller.updateProduct(product);
        });
    }

    @Test
    void testDelete() {
        ResponseEntity<ProductEntity> response = new ResponseEntity<ProductEntity>(product, HttpStatus.OK);
        when(controller.deleteProduct(product.getId())).thenReturn(response);
        assertEquals(response, controller.deleteProduct(product.getId()));
    }

    @Test
    void testDeleteException() {
        when(controller.deleteProduct(product.getId())).thenThrow(new RecordNotFoundException("Record not found"));
        assertThrows(RecordNotFoundException.class, () -> {
            controller.deleteProduct(product.getId());
        });
    }

    @Test
    void testFindByName() {
        List<ProductEntity> list = new ArrayList<ProductEntity>();
        list.add(product);
        when(controller.findByName(product.getName())).thenReturn(list);
        assertEquals(list, controller.findByName(product.getName()));
    }

    @Test
    void testFindByProductCode() {
        List<ProductEntity> list = new ArrayList<ProductEntity>();
        list.add(product);
        when(controller.findByProductCode(product.getProductCode())).thenReturn(list);
        assertEquals(list, controller.findByProductCode(product.getProductCode()));
    }

    @Test
    void testFindByPk() {
        ResponseEntity<ProductEntity> response = new ResponseEntity<ProductEntity>(product, HttpStatus.OK);
        when(controller.findByPk(product.getId())).thenReturn(response);
        assertEquals(response, controller.findByPk(product.getId()));
    }

    @Test
    void testFindByPkException() {
        when(controller.findByPk(product.getId())).thenThrow(new RecordNotFoundException("Record not found"));
        assertThrows(RecordNotFoundException.class, () -> {
            controller.findByPk(product.getId());
        });
    }

    @Test
    void testSearch() {
        List<ProductEntity> list = new ArrayList<ProductEntity>();
        list.add(product);
        when(controller.search(product)).thenReturn(list);
        assertEquals(list, controller.search(product));
    }

}
