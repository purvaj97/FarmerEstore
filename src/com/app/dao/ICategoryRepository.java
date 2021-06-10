package com.app.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.models.Category;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {


    @Query("select c from Category c join fetch c.products where c.categoryName=:name")
	public Category getCategoryDetails(@Param("name") String categoryName);

	
}
