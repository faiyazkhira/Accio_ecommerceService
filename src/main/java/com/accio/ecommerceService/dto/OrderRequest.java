package com.accio.ecommerceService.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

	@NotNull
	private Long userId;

	@NotNull
	private List<OrderItemRequest> items;
}
