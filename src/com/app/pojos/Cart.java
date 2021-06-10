package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
public class Cart {
	
	private Integer cartId;
	
	private double amount;
	
	
	// Mapping
	
	//@JsonIgnore
	private Customer customer;
	
	private List<CartItem> cartItems=new ArrayList<CartItem>(); 
	
	
	// Constructors
	
	public Cart() {
		System.out.println("In cart Constr");
		
	}

	// Methods
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCartId() {
		return cartId;
	}



	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}


	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="customer_id")
	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	@OneToMany(targetEntity = CartItem.class ,mappedBy="cart")
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<CartItem> getCartItems() { 
		return cartItems; 
	}
	  
	  
	  
	public void setCartItems(List<CartItem> cartItems) { 
		  this.cartItems = cartItems; 
	}
	  
	//helper methods
	  
	public void addCartItem(CartItem cartItem) {
		cartItem.setCart(this);
		this.cartItems.add(cartItem);
	}
	  
	public void removeCartItem(CartItem cartItem) {
		this.cartItems.remove(cartItem); 
		
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", amount=" + amount + "]";
	}
	


}