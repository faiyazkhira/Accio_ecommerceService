package com.accio.ecommerceService.controller;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return ResponseEntity.ok("Ecommerce Service is available now " + new Date(System.currentTimeMillis()));
	}

}
