package com.app.service;

import com.app.pojos.Cart;
import com.app.pojos.CartItem;

public interface ICartService {

	public Cart getCartDetails(int cartId);
	
	public CartItem getCartItemDetails(int cartItemid);
	
	boolean addCartItem(int productId, Cart cart);
	
	boolean updateCartItem(int cartItemId, int update, Cart cart);
	
	boolean deleteCart(Cart cart);

	boolean deleteCartItem(int cartItemId, Cart cart);

	

}
