package com.accio.ecommerceService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "addresses")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "City is required")
	@Column(nullable = false)
	private String city;

	@NotBlank(message = "Street is required")
	@Column(nullable = false)
	private String street;

	@NotNull(message = "User ID is required")
	@Column(nullable = false)
	private Long userId;

	@NotBlank(message = "First name is required")
	@Column(nullable = false)
	private String firstName;

	@NotBlank(message = "Last name is required")
	@Column(nullable = false)
	private String lastName;

	private String state;
	private String country;
	private String zipCode;
	private String phoneNumber;
}
