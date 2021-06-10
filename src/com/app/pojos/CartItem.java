package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CartItem {

	private Integer cartItemId;
	private Integer quantity;
	private Double value;

	//Mapping

	private Product product;
	
	//@JsonIgnore
	private Cart cart;

	//Constructors
	
	public CartItem() {
		System.out.println("In CartItems Constr");
	}
	
	public CartItem(Integer quantity, Double value) {
		super();
		this.quantity = quantity;
		this.value = value;
	}
	
	//Methods
	
	@Id
	@Column(name="cartitem_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(Integer cartItemId) {
		this.cartItemId = cartItemId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}

	@OneToOne
	@JoinColumn(name="product_id")
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	@ManyToOne()
	@JoinColumn(name="cart_id")
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", quantity=" + quantity + ", value=" + value + "]";
	}
	


}