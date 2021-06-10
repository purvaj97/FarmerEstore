package com.app.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.ICategoryRepository;
import com.app.models.Category;


@Repository
public class CategoryDaoImpl{
	
	@Autowired
	ICategoryRepository categoryRepo;
	
	public CategoryDaoImpl() {
		System.out.println("In CategoryDaoImpl");
	}

	public List<Category> getCategoryList(){
		List<Category> categoryList=categoryRepo.findAll();
		return categoryList;
		
	}

	public Category getCategoryDetails(String categoryName) {
		Category category=null;
		try {
			category=categoryRepo.getCategoryDetails(categoryName);
		}
		catch(Exception e) {
			System.out.println(e+"In CategoryDetails");
		}
		return category;
	}

	public boolean deleteCategory(int categoryId) {
		boolean status=false;
		if(categoryRepo.existsById(categoryId)) {
			categoryRepo.deleteById(categoryId);
			status=true;
			System.out.println("category delete dao");
		}
		return status;
	}

	public boolean addCategory(String categoryName) {
		boolean status=false;
		try {
			Category category = new Category(categoryName);
				categoryRepo.save(category);
			status=true;
		}catch(Exception e) {
		throw e;
		}
		return status;
	}
}
