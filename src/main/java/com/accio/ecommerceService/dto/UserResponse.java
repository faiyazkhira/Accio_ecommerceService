package com.accio.ecommerceService.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

	private String id;
	private String username;
	private String name;
	private String email;
	private List<String> roles;

}
