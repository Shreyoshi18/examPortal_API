package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.exam.Category;
import com.exam.services.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	//add category
	@PostMapping("/add")
	public ResponseEntity<?> addCategory(@RequestBody Category category)
	{
		Category c = this.categoryService.addCategory(category);
		return ResponseEntity.ok(c);
	}
	
	//get category
	@GetMapping("/{categoryId}")
	public Category getCategory(@PathVariable("categoryId") Long categoryId)
	{
		Category c = this.categoryService.getCategory(categoryId);
		return c;
	}
	
	//get all categories
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllCategories()
	{
		return ResponseEntity.ok(this.categoryService.getAllCategories());
	}
	
	//update Category
	@PutMapping("/update")
	public Category updateCategory(@RequestBody Category category)
	{
		return this.categoryService.updateCategory(category);
	}
	
	//delete category
	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable("categoryId") Long id)
	{
		this.categoryService.deleteCategory(id);
	}
	
}
