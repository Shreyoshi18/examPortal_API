package com.exam.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.exam.Category;
import com.exam.repository.CategoryRepository;
import com.exam.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepository.save(category);

	}

	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepository.save(category);

	}

	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return this.categoryRepository.findAll();
	}

	public Category getCategory(Long id) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findById(id).get();
	}

	public void deleteCategory(Long id) {
		// TODO Auto-generated method stub
		this.categoryRepository.deleteById(id);

	}

}
