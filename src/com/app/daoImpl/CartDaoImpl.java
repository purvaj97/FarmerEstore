package com.app.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICartDao;
import com.app.pojos.Cart;
import com.app.pojos.CartItem;

@Repository
@Transactional
public class CartDaoImpl implements ICartDao {

	@Autowired
	SessionFactory sf;

	@Override
	public Cart getCartDetails(int cartId) {
		// TODO Auto-generated method stub
		Cart cart;
		//String jpql = "select c from Cart c join fetch c.cartItems where c.cartId=:id";
		try {
			//cart = sf.getCurrentSession().createQuery(jpql, Cart.class).setParameter("id", cartId).getSingleResult();
			cart = sf.getCurrentSession().get(Cart.class, cartId);
			
		} catch (Exception e) {
			throw e;
		}
		return cart;
	}
	
	@Override
	public CartItem getCartItemDetails(int cartItemId) {
		// TODO Auto-generated method stub
		String jpql = "select c from CartItem c join fetch c.product where c.cartItemId = :id";
		CartItem cartItem;
		try {
			cartItem= sf.getCurrentSession().createQuery(jpql, CartItem.class).setParameter("id", cartItemId).getSingleResult();
		}
		catch(Exception e) {
			throw e;
		}
		return cartItem;
	}
	
	@Override
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
		try {
			sf.getCurrentSession().persist(cart);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean addCartItem(CartItem cartItem) {
		boolean status = false;
		try {
			sf.getCurrentSession().save(cartItem);
			status = true;
		}
		catch(Exception e) {
			throw e;
		}
		return status;
	}
	
	@Override
	public boolean updateCart(Cart cart) {
		// TODO Auto-generated method stub
		try {
			sf.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		boolean status=false;
		try {
			sf.getCurrentSession().update(cartItem);
			status=true;
		}
		catch(Exception e) {
			throw e;
		}
		return status;
	}
	
	@Override
	public boolean deleteCart(Cart cart) {
		// TODO Auto-generated method stub
		try {
			sf.getCurrentSession().delete(cart);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCartItem(int cartItemId) {
		// TODO Auto-generated method stub
		boolean status=false;
		try {
			Session hs= sf.getCurrentSession();
			CartItem cartItem= hs.get(CartItem.class, cartItemId);
			hs.delete(cartItem);
			status=true;
		}
		catch(Exception e) {
			throw e;
		}
		return status;
	}

}
