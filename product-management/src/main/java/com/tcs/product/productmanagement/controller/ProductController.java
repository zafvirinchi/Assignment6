package com.tcs.product.productmanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.product.productmanagement.entity.ProductEntity;
import com.tcs.product.productmanagement.model.Product;
import com.tcs.product.productmanagement.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/product-service")
@RequiredArgsConstructor
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/product")
	@ResponseStatus(HttpStatus.CREATED)
	public void addProduct(@RequestBody Product product) {

		productService.addProduct(product);

	}
	
	@GetMapping("/product")
	public List<Product> getAllProduct() {
		
		return productService.getAllProduct();
	}

	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {

		var updatedProduct = productService.updateProduct(id, product);

		return ResponseEntity.ok(updatedProduct);
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {

		ProductEntity productDetails = productService.getProductById(id);

		if (productDetails != null) {

			Product product = new Product(id, productDetails.getName(), productDetails.getPrice());
			return ResponseEntity.ok(product);
		} else
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);

	}

	@DeleteMapping("/product/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteBookById(@PathVariable Long id) {

		productService.deleteById(id);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}

}
