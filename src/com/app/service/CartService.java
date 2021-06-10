package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICartDao;
import com.app.dao.IProductDao;
import com.app.pojos.Cart;
import com.app.pojos.CartItem;
import com.app.pojos.Product;

@Service
public class CartService implements ICartService {

	@Autowired
	private ICartDao cartDao;

	@Autowired
	private IProductDao productDao;

	@Override
	public Cart getCartDetails(int cartId) {
		// TODO Auto-generated method stub
		Cart cart;

		try {

			cart = cartDao.getCartDetails(cartId);

		} catch (Exception e) {
			throw e;
		}
		return cart;
	}

	@Override
	public CartItem getCartItemDetails(int cartItemId) {
		CartItem cartItem = null;
		try {
			cartItem = cartDao.getCartItemDetails(cartItemId);
		} catch (Exception e) {
			throw e;
		}
		return cartItem;

	}

	@Override
	public boolean addCartItem(int productId, Cart cart) {
		// TODO Auto-generated method stub
		boolean status = false;

		try {
			// fetch product by id
			Product product = productDao.getProduct(productId);
			if (product.getQuantity() >= 1) {
				for (CartItem cartItem : cart.getCartItems()) {
					if (cartItem.getProduct().getId() == productId) {
						this.updateCartItem(cartItem.getCartItemId(), 1, cart);
						return true;
					}
				}
				// create new cart item
				CartItem cartItem = new CartItem(1, product.getPrice());
				// add product as cartItem
				cartItem.setProduct(product);
				cart.setAmount(cart.getAmount() + cartItem.getValue());
				// add cart item to cart
				cartItem.setCart(cart);
				// persist cartItem
				cartDao.addCartItem(cartItem);
				cartDao.updateCart(cart);
			} else {
				status = false;
			}
		} catch (Exception e) {
			throw e;
		}

		return status;
	}

	@Override
	public boolean updateCartItem(int cartItemId, int update, Cart cart) {
		// TODO Auto-generated method stub
		boolean status = false;
		try {
			CartItem cartItem = cartDao.getCartItemDetails(cartItemId);
			if (cartItem.getProduct().getQuantity() != 0) {
				int quantity = cartItem.getQuantity() + (update);
				double amount = 0;
				if (update == 1) {
					amount += cartItem.getProduct().getPrice();
				} else if (update == -1) {
					amount -= cartItem.getProduct().getPrice();
				}

				if (quantity != 0) {

					cartItem.setQuantity(quantity);
					cartItem.setValue(cartItem.getProduct().getPrice() * quantity);
					cartDao.updateCartItem(cartItem);
					for (CartItem ct : cart.getCartItems()) {
						amount += ct.getValue();
					}
					cart.setAmount(amount);
					cartDao.updateCart(cart);
					status = true;

				} else {
					cart.getCartItems().remove(cartItem);
					cartDao.deleteCartItem(cartItemId);
					for (CartItem ct : cart.getCartItems()) {
						amount += ct.getValue();
					}
					cart.setAmount(amount);
					cartDao.updateCart(cart);
					status = true;

				}
			}
			else {
				status = false;
			}

		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	@Override
	public boolean deleteCart(Cart cart) {
		boolean status = false;
		try {
			cartDao.deleteCart(cart);
			status = true;
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	@Override
	public boolean deleteCartItem(int cartItemId, Cart cart) {
		// TODO Auto-generated method stub
		boolean status = false;
		try {
			cart.getCartItems().remove(cartDao.getCartItemDetails(cartItemId));
			cartDao.deleteCartItem(cartItemId);
			status = true;

		} catch (Exception e) {
			throw e;
		}
		return status;
	}

}
