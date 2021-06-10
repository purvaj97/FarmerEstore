package com.app.service;

import java.util.List;

import com.app.pojos.Product;
import com.app.pojos.Seller;

public interface IProductService {

	public List<Product> getAllProducts();
	
	public Product getProductDetails(int id);

	boolean addProduct(Product product, String categoryName, Seller seller);

	boolean deleteProduct(int id);
	
	boolean updateProduct(int productId, int quantity);
}
