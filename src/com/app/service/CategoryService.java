package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daoImp.CategoryDaoImpl;
import com.app.models.Category;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	CategoryDaoImpl categoryDao;
	
	@Override
	public List<Category> getCategoryList() {
		
		return categoryDao.getCategoryList();
	}

	@Override
	public Category getCategoryDetails(String categoryName) {
		
		return categoryDao.getCategoryDetails(categoryName);
	}

	@Override
	public boolean deleteCategory(int categoryId) {
		return categoryDao.deleteCategory(categoryId);
	}

	@Override
	public boolean addCategory(String categoryName) {
		return categoryDao.addCategory(categoryName);
	}

}
