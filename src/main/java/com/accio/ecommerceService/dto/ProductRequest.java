package com.accio.ecommerceService.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {

	@NotBlank(message = "Product name is required.")
	@Size(max = 100, message = "Product name cannot exceed 100 characters.")
	private String name;

	@NotBlank(message = "Description is required.")
	@Size(max = 500, message = "Description cannot exceed 500 characters.")
	private String description;

	@NotNull(message = "Price is required.")
	@DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0.")
	private Double price;

	@NotNull(message = "Stock is required.")
	@Min(value = 0, message = "Stock cannot be negative.")
	private Integer stock;

	@NotBlank(message = "Image URL is required.")
	@Size(max = 255, message = "Image URL cannot exceed 255 characters.")
	private String imageUrl;

	@NotNull(message = "Category ID is required.")
	private Long categoryId; // For referencing the Category entity by ID

}
