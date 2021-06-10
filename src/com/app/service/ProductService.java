package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daoImp.CategoryDaoImpl;
import com.app.daoImp.ProductDaoImpl;
import com.app.models.Category;
import com.app.models.Product;
import com.app.models.Seller;

@Service
public class ProductService implements IProductService {

	@Autowired
	ProductDaoImpl productDao;

	@Autowired
	CategoryDaoImpl categoryDao;

	@Override
	public Product getProductDetails(int id) {
		// TODO Auto-generated method stub
		return productDao.getProduct(id);
	}

	@Override
	public boolean addProduct(Product product, String categoryName, Seller seller) {
		boolean status = false;
		try {
			System.out.println("/////" + product + categoryName + seller);
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
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(id);
	}

	@Override
	public boolean updateProduct(int productId, int quantity) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(productId, quantity);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.getAllProducts();
	}

}
