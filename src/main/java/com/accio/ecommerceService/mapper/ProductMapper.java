package com.accio.ecommerceService.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.accio.ecommerceService.dto.ProductRequest;
import com.accio.ecommerceService.dto.ProductResponse;
import com.accio.ecommerceService.entity.Category;
import com.accio.ecommerceService.entity.Product;

@Component
public class ProductMapper {

	public ProductResponse toProductResponse(Product product) {
		return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice(),
				product.getStock(), product.getImageUrl(),
				product.getCategory() != null ? product.getCategory().getName() : null

		);
	}

	public Product toProductEntity(ProductRequest productRequest, Category category) {
		return Product.builder().name(productRequest.getName()).description(productRequest.getDescription())
				.price(productRequest.getPrice()).stock(productRequest.getStock())
				.imageUrl(productRequest.getImageUrl()).category(category) //
				.build();
	}

	public List<ProductResponse> toProductResponseList(List<Product> products) {
		return products.stream().map(this::toProductResponse).toList();
	}
}
