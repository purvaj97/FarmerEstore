package com.app.dao;


import com.app.pojos.Cart;
import com.app.pojos.CartItem;

public interface ICartDao {
	
	public Cart getCartDetails(int cartId);
	
	public CartItem getCartItemDetails(int cartItemId);
	
	public boolean addCart(Cart cart);

	public boolean addCartItem(CartItem cartItem);
	
	public boolean updateCart(Cart cart);
	
	public boolean updateCartItem(CartItem cartItem);

	public boolean deleteCart(Cart cart);
	
	public boolean deleteCartItem(int cartItemId);

	
	
}
