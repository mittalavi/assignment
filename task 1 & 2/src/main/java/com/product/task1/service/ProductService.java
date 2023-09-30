package com.product.task1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.task1.entity.ProductEntity;
import com.product.task1.repository.ProductRepository;

import jakarta.validation.ValidationException;

@Service
public class ProductService {

	
	@Autowired
	private ProductRepository productRepository;

	public List<ProductEntity> getProductsByPriceBetween(double maxprice, double minprice) {
		 
	        return productRepository.findProductsByPriceBetween(maxprice,minprice);
	}
	
	
	public List<ProductEntity> getProductsByPriceGreaterThan(double price) {
		 
        return productRepository.findProductsByPriceGreaterThan(price);
}
}
