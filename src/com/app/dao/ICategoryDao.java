package com.app.dao;

import java.util.List;

import com.app.pojos.Category;

public interface ICategoryDao {

	List<Category> getCategoryList();

	Category getCategoryDetails(String categoryName);

	boolean deleteCategory(int categoryId);

	boolean addCategory(String categoryName);
	
}
