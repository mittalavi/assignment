package com.product.task1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.task1.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("SELECT p FROM ProductEntity p WHERE p.productPrice > :minprice and p.productPrice < :maxprice")
    List<ProductEntity> findProductsByPriceBetween(double maxprice, double minprice);
    
    @Query("SELECT p FROM ProductEntity p WHERE p.productPrice > :price")
    List<ProductEntity> findProductsByPriceGreaterThan(double price);
	
}
