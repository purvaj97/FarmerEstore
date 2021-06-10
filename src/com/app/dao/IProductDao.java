package com.app.dao;

import java.util.List;
import com.app.pojos.Product;

public interface IProductDao {

	public List<Product> getAllProducts();

	public Product getProduct(int productId);

	public boolean addProduct(Product product);

	public boolean deleteProduct(int productId);

	boolean updateProduct(int id, int quantity);

	
}
