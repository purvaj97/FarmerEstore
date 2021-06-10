package com.app.daoImpl;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICategoryDao;
import com.app.pojos.Category;

@Repository
@Transactional
public class CategoryDaoImpl implements ICategoryDao {

	@Autowired
	SessionFactory sf;
	
	@Override
	public List<Category> getCategoryList() {
		
		// method returns list of all categories
				List<Category> categories;
				String jpql = "select c from Category c";
				try {
					categories= sf.getCurrentSession().createQuery(jpql, Category.class).getResultList();
				}
				catch(Exception e) {
					throw e;
				}
				return categories;
	}

	@Override
	public Category getCategoryDetails(String categoryName) {
		// 
		Category category;
		try {
			String jpql = "select c from Category c join fetch c.products where c.categoryName=:name";
			category = sf.getCurrentSession().createQuery(jpql,Category.class).setParameter("name", categoryName).getSingleResult();
		}
		catch(NoResultException e) {
			String jpql = "select c from Category c where c.categoryName=:name";
			category = sf.getCurrentSession().createQuery(jpql,Category.class).setParameter("name", categoryName).getSingleResult();
		}
		catch(Exception ex) {
			throw ex;
		}
		return category;
		
	}

	@Override
	public boolean deleteCategory(int categoryId) {
		// TODO Auto-generated method stub
		boolean status = false;
		try {
			Session hs = sf.getCurrentSession();
			Category category = hs.get(Category.class, categoryId);
			hs.delete(category);
			status = true;
		}
		catch(Exception e) {
			throw e;
		}
		return status;
	}

	@Override
	public boolean addCategory(String categoryName) {
		// TODO Auto-generated method stub
		boolean status = false;
		try {
			Category category = new Category(categoryName);
			sf.getCurrentSession().save(category);
			status = true;
		}
		catch(Exception e) {
			throw e;
		}
		return status;
	}

}
