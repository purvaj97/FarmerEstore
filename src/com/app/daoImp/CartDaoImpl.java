package com.app.daoImp;

import java.util.Optional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.ICartItemRepository;
import com.app.dao.ICartRepository;
import com.app.models.Cart;
import com.app.models.CartItem;

@Repository
public class CartDaoImpl {
	
	@Autowired
	ICartRepository cartRepo;
	
	@Autowired
	ICartItemRepository cartItemRepo;
	
	public CartDaoImpl() {
		System.out.println("In CartDaoImpl constructor");
	
	}
	
	
public Cart getCartDetails(int cartId) {
	Cart cart;
	try {
		Optional<Cart> o=cartRepo.findById(cartId);
		cart = o.get();
	} catch (Exception e) {
		System.out.println(e);
		return null;
	}
	return cart;
}

	
	public CartItem getCartItemDetails(int cartItemId) {
		CartItem cartItem;
		try {
			cartItem= cartRepo.cartItemDetailsbyId(cartItemId);
		}
		catch(Exception e) {
			throw e;
		}
		return cartItem;
	}
	
	public boolean addCart(Cart cart) {
		boolean status=false;
		try {
			cartRepo.save(cart);
			status=true;
			System.out.println("CartDaoImpl added");
		}catch(Exception e) {
			throw e;
		}
		return status;
	}

	public boolean addCartItem(CartItem cartItem) {
		boolean status=false;
		try {
			cartItemRepo.save(cartItem);
			status=true;
			System.out.println("CartDaoImpl Items added");
		}catch(Exception e) {
			throw e;
		}
		return status;
	}
	
	public boolean updateCart(Cart cart) {
		boolean status=false;
		try {
			cartRepo.save(cart);
			status=true;
		}
		catch(Exception e) {
			System.out.println("In Cart cart details not found"+e);
		}
		return status;
	}
	
	public boolean updateCartItem(CartItem cartItem) {
		boolean status=false;
		try {
			cartItemRepo.save(cartItem);
			status=true;
		}
		catch(Exception e) {
			throw e;
		}
		return status;
	}

	public boolean deleteCart(Cart cart) {
		try {
			cartRepo.delete(cart);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean deleteCartItem(int cartItemId) {
		boolean status=false;
		try {
			cartItemRepo.deleteById(cartItemId);
			status=true;
		}
		catch(Exception e) {
			throw e;
		}
		return status;
	}
	
}
		
	
	