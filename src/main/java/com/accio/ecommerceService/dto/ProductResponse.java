package com.accio.ecommerceService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {

	@NotNull(message = "Product ID is required.")
	private Long id;

	@NotBlank(message = "Product name is required.")
	private String name;

	@NotBlank(message = "Description is required.")
	private String description;

	@NotNull(message = "Price is required.")
	private Double price;

	@NotNull(message = "Stock is required.")
	private Integer stock;

	@NotBlank(message = "Image URL is required.")
	private String imageUrl;

	@NotBlank(message = "Category name is required.")
	private String categoryName; // Will store category name instead of category ID

}