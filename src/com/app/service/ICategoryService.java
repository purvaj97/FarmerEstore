package com.app.service;

import java.util.List;

import com.app.models.Category;

public interface ICategoryService {
	
	public List<Category> getCategoryList();

	public Category getCategoryDetails(String categoryName);

	public boolean deleteCategory(int categoryId);

	public boolean addCategory(String categoryName);
}
