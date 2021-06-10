package com.app.daoImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.IProductRepository;
import com.app.models.Product;

@Repository
public class ProductDaoImpl {

	@Autowired
	IProductRepository productRepo;
	
	 public ProductDaoImpl() {
		System.out.println("In ProductDaoImpl");
	}


	public boolean addProduct(Product product) {
		boolean status=false;
		try {
			productRepo.save(product);
			status=true;
			System.out.println("Product added");
		}catch(Exception e) {
			throw e;
		}
		return status;
	}

	public boolean deleteProduct(int id) {
		boolean status=false;
		try {
			status=productRepo.existsById(id);
			productRepo.deleteById(id);
			System.out.println("Product deleted");
		}catch(Exception e) {
			throw e;
		}
		return status;
	}
	
	public Product getProduct(int productId) {
		Product product;
		try {
			Optional<Product> o=productRepo.findById(productId);
			product = o.get();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return product;
	}

	public boolean updateProduct(int productId, int quantity) {
		boolean status=false;
		try {
			Optional<Product> o=productRepo.findById(productId);
			Product p=o.get();
			p.setQuantity(quantity);
			productRepo.save(p);
			status=true;
		}
		catch(Exception e) {
			System.out.println("In updateProduct product not found"+e);
		}
		return status;
		
	}

	public List<Product> getAllProducts() {
		List<Product> productList;
		try {
			productList=productRepo.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
		return productList;
	}

}
