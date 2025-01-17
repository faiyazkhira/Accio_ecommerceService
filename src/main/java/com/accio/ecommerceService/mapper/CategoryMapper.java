package com.accio.ecommerceService.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.accio.ecommerceService.dto.CategoryRequest;
import com.accio.ecommerceService.dto.CategoryResponse;
import com.accio.ecommerceService.entity.Category;

@Component
public class CategoryMapper {

	public CategoryResponse toCategoryResponse(Category category) {
		return CategoryResponse.builder().id(category.getId()).name(category.getName())
				.description(category.getDescription()).build();
	}

	public Category toCategoryEntity(CategoryRequest categoryRequest) {
		return Category.builder().name(categoryRequest.getName()).description(categoryRequest.getDescription()).build();
	}

	public List<CategoryResponse> toCategoryResponseList(List<Category> catagories) {
		return catagories.stream().map(this::toCategoryResponse).toList();
	}
}
