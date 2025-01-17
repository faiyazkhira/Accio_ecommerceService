package com.accio.ecommerceService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accio.ecommerceService.dto.ProductRequest;
import com.accio.ecommerceService.dto.ProductResponse;
import com.accio.ecommerceService.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<ProductResponse>> getAllProducts() {
		List<ProductResponse> productResponse = productService.getAllProducts();
		return ResponseEntity.ok(productResponse);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
		ProductResponse productResponse = productService.getProductById(id);
		return ResponseEntity.ok(productResponse);
	}

	@GetMapping("/category/{categoryId}")
	public ResponseEntity<List<ProductResponse>> getProductsByCategoryId(@PathVariable Long categoryId) {
		List<ProductResponse> productResponses = productService.getProductsByCategoryId(categoryId);
		return ResponseEntity.ok(productResponses);
	}

	@GetMapping("/category/name/{categoryName}")
	public ResponseEntity<List<ProductResponse>> getProductsByCategoryName(@PathVariable String categoryName) {
		List<ProductResponse> productResponses = productService.getProductsByCategoryName(categoryName);
		return ResponseEntity.ok(productResponses);
	}

	@PostMapping
	public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest productRequest) {
		ProductResponse createdProduct = productService.createProduct(productRequest);
		return ResponseEntity.ok(createdProduct);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id,
			@Valid @RequestBody ProductRequest productRequest) {
		ProductResponse updatedProduct = productService.updateProduct(id, productRequest);
		return ResponseEntity.ok(updatedProduct);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.ok("Product with ID " + id + " deleted successfully.");
	}
}
