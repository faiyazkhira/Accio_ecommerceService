package com.accio.ecommerceService.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemRequest {

	@NotNull
	private Long productId;

	@NotNull
	private Integer quantity;
}
