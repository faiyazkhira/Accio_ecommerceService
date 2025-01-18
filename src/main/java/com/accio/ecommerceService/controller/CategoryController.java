package com.accio.ecommerceService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accio.ecommerceService.dto.CategoryRequest;
import com.accio.ecommerceService.dto.CategoryResponse;
import com.accio.ecommerceService.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	// Create a new category
	@PostMapping
	public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest) {
		CategoryResponse categoryResponse = categoryService.createCategory(categoryRequest);
		return new ResponseEntity<>(categoryResponse, HttpStatus.CREATED);
	}

	// Retrieve a category by ID
	@GetMapping("/{id}")
	public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Long id) {
		try {
			CategoryResponse categoryResponse = categoryService.getCategoryById(id);
			return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Retrieve all categories
	public ResponseEntity<List<CategoryResponse>> getAllCategories() {
		List<CategoryResponse> categoryResponses = categoryService.getAllCategories();
		if (!categoryResponses.isEmpty()) {
			return new ResponseEntity<>(categoryResponses, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	// Update a category
	@PutMapping("/{id}")
	public ResponseEntity<CategoryResponse> updateCategory(@PathVariable Long id,
			@RequestBody CategoryRequest categoryRequest) {
		CategoryResponse categoryResponse = categoryService.updateCategory(id, categoryRequest);
		return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
	}

	// Delete a category
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
		String message = categoryService.deleteCategory(id);
		return ResponseEntity.ok(message);
	}
}
