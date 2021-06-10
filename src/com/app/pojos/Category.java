package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Category {

	private Integer categoryid;
	private String categoryName;
	
	//Mapping
	
	
	private List<Product> products=new ArrayList<Product>() ;
	
	//Constructors
	
	public Category() {
		System.out.println("In Category Constructor");
	}


	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCategoryid() {
		return categoryid;
	}


	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	
	@Column(length =20)
	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	//mappedBy = "e_d_id", cascade = CascadeType.ALL, orphanRemoval=true
	@OneToMany(mappedBy="category", orphanRemoval = true )
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	//Helper Method
	
	public void addProduct(Product p) {
		this.products.add(p);
	}
	
	public void removeProduct(Product p) {
		this.removeProduct(p);
	}


	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", categoryName=" + categoryName + "]";
	}
		
	
}
