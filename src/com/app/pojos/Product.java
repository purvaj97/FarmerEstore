package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//import org.hibernate.validator.constraints.Length;
//import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Product {

	private Integer id;
	//@NotEmpty(message = "Name must be supplied")
	private String productName;
	//@Length(min = 5,max=100)
	private String description;
	//@NotEmpty(message = "price must be supplied")
	private double price;
	//@NotEmpty(message = "weight must be supplied")
	private double weight;
	
	private int quantity;
	
	private String imageUrl;
	//Mapping
	
	//@JsonIgnore
	private Seller seller;
	
	//@JsonIgnore
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "seller_id")
	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	@ManyToOne
	@JoinColumn(name="categoryid")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	//Constructors
	
	public Product() {
		System.out.println("In Product Constr");
	}

	//Methods

	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", description=" + description + ", price="
				+ price + ", weight=" + weight + ", quantity=" + quantity + ", imageUrl=" + imageUrl + "]";
	}
	
	//helper methods


}
