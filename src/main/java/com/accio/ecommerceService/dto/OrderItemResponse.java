package com.accio.ecommerceService.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemResponse {

	private Long id;
	private Long productId;
	private String productName;
	private Integer quantity;
	private BigDecimal totalPrice;
}
