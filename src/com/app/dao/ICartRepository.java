package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.models.Cart;
import com.app.models.CartItem;

public interface ICartRepository extends JpaRepository<Cart, Integer>{

	
	@Query("select c from CartItem c join fetch c.product where c.cartItemId = :id")
	public CartItem cartItemDetailsbyId(@Param("id") int cartitemId);
	
}
