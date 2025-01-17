package com.accio.ecommerceService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accio.ecommerceService.dto.ProductRequest;
import com.accio.ecommerceService.dto.ProductResponse;
import com.accio.ecommerceService.entity.Product;
import com.accio.ecommerceService.mapper.ProductMapper;
import com.accio.ecommerceService.repository.ProductRepository;

import jakarta.validation.Valid;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductMapper productMapper;

	public List<ProductResponse> getAllProducts() {
		List<Product> products = productRepository.findAll();
		productMapper.toProductResponseList(products);
	}

	public ProductResponse getProductById(Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
		return productMapper.toProductResponse(product);
	}

	public List<ProductResponse> getProductsByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProductResponse> getProductsByCategoryName(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductResponse createProduct(@Valid ProductRequest productRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductResponse updateProduct(Long id, @Valid ProductRequest productRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub

	}

}
