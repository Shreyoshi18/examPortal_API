package com.exam.services;

import java.util.List;

import com.exam.entity.exam.Category;

public interface CategoryService {

	public Category addCategory(Category category);
	public Category updateCategory(Category category);
	public List<Category> getAllCategories();
	public Category getCategory(Long id);
	public void deleteCategory(Long id);
	
}
