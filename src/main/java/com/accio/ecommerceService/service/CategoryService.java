package com.accio.ecommerceService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accio.ecommerceService.dto.CategoryRequest;
import com.accio.ecommerceService.dto.CategoryResponse;
import com.accio.ecommerceService.entity.Category;
import com.accio.ecommerceService.mapper.CategoryMapper;
import com.accio.ecommerceService.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	CategoryMapper categoryMapper;

	public CategoryResponse createCategory(CategoryRequest categoryRequest) {
		Category category = Category.builder().name(categoryRequest.getName())
				.description(categoryRequest.getDescription()).build();
		Category savedCategory = categoryRepository.save(category);
		return categoryMapper.toCategoryResponse(savedCategory);
	}

	public CategoryResponse getCategoryById(Long id) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Category not found"));
		return categoryMapper.toCategoryResponse(category);
	}

	public List<CategoryResponse> getAllCategories() {
		List<Category> catagories = categoryRepository.findAll();
		return categoryMapper.toCategoryResponseList(catagories);
	}

	public CategoryResponse updateCategory(Long id, CategoryRequest categoryRequest) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Category not found"));

		category.setDescription(categoryRequest.getDescription());
		category.setName(categoryRequest.getName());
		Category updatedCategory = categoryRepository.save(category);
		return categoryMapper.toCategoryResponse(updatedCategory);
	}

	public void deleteCategory(Long id) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Category not found"));
		categoryRepository.delete(category);
	}

}
