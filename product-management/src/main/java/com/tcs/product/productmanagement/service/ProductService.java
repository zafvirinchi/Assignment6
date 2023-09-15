package com.tcs.product.productmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tcs.product.productmanagement.entity.ProductEntity;
import com.tcs.product.productmanagement.model.Product;
import com.tcs.product.productmanagement.repo.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	public void addProduct(Product product) {

		ProductEntity productEntity = new ProductEntity();
		productEntity.setName(product.name());
		productEntity.setPrice(product.price());

		productRepository.save(productEntity);
	}

	public Product updateProduct(Long id, Product product) {

		ProductEntity retrievedProduct = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product with id " + id + " does not exist."));

		retrievedProduct.setName(product.name());
		retrievedProduct.setPrice(product.price());

		ProductEntity updatedProduct = productRepository.save(retrievedProduct);

		return new Product(id, updatedProduct.getName(), updatedProduct.getPrice());
	}

	public List<Product> getAllProduct() {

		var productsEntityList = productRepository.findAll();

		List<Product> products = new ArrayList<Product>();

		productsEntityList.forEach(productEntity -> {
			Product product = new Product(productEntity.getId(), productEntity.getName(), productEntity.getPrice());
			products.add(product);
		});

		return products;
	}

	public ProductEntity getProductById(Long id) {

		return productRepository.findById(id).orElseGet(null);
	}

	public void deleteById(Long id) {
		ProductEntity retrievedProduct = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product with id " + id + " does not exist."));

		productRepository.delete(retrievedProduct);

	}

}
