package com.accio.ecommerceService.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

	private Long id;
	private Long userId;
	private BigDecimal totalPrice;
	private String status;
	private List<OrderItemResponse> items;
}
