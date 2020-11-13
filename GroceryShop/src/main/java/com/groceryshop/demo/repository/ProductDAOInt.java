package com.cg.gsm.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.gsm.app.entities.ProductEntity;

public interface ProductDAOInt extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByName(String name);

    List<ProductEntity> findByProductCode(String code);

}
