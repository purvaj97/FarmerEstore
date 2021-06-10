package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICategoryDao;
import com.app.dao.IProductDao;
import com.app.pojos.Category;
import com.app.pojos.Product;
import com.app.pojos.Seller;

@Service
public class ProductService implements IProductService {

	@Autowired
	IProductDao productDao;

	@Autowired
	ICategoryDao categoryDao;

	@Override
	public Product getProductDetails(int id) {
		return productDao.getProduct(id);
	}

	@Override
	public boolean addProduct(Product product, String categoryName, Seller seller) {
		boolean status = false;
		try {
			System.out.println("/////"+product + categoryName + seller);
			Category category = categoryDao.getCategoryDetails(categoryName);
			product.setCategory(category);
			product.setSeller(seller);
			productDao.addProduct(product);
			status = true;
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	@Override
	public boolean updateProduct(int productId, int quantity) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(productId, quantity);
	}

	@Override
	public boolean deleteProduct(int id) {
		//
		return productDao.deleteProduct(id);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.getAllProducts();
	}

}
