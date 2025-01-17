package com.accio.ecommerceService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	@ResponseStatus(HttpStatus.CREATED)
	public CategoryResponse createCategory(@RequestBody CategoryRequest categoryRequest) {
		return categoryService.createCategory(categoryRequest);
	}

	// Retrieve a category by ID
	@GetMapping("/{id}")
	public CategoryResponse getCategoryById(@PathVariable Long id) {
		return categoryService.getCategoryById(id);
	}

	// Retrieve all categories
	@GetMapping
	public List<CategoryResponse> getAllCategories() {
		return categoryService.getAllCategories();
	}

	// Update a category
	@PutMapping("/{id}")
	public CategoryResponse updateCategory(@PathVariable Long id, @RequestBody CategoryRequest categoryRequest) {
		return categoryService.updateCategory(id, categoryRequest);
	}

	// Delete a category
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
	}
}
