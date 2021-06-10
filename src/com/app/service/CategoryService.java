package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICategoryDao;
import com.app.pojos.Category;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	ICategoryDao categoryDao;
	
	@Override
	public List<Category> getCategoryList() {
		
		return categoryDao.getCategoryList();
	}

	@Override
	public Category getCategoryDetails(String categoryName) {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryDetails(categoryName);
	}

	@Override
	public boolean deleteCategory(int categoryId) {
		// TODO Auto-generated method stub
		
		return categoryDao.deleteCategory(categoryId);
	}

	@Override
	public boolean addCategory(String categoryName) {
		// TODO Auto-generated method stub
		return categoryDao.addCategory(categoryName);
	}

}