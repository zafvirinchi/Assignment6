package com.tcs.product.productmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.product.productmanagement.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	
}
