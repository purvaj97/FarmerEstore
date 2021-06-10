package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.models.CartItem;

public interface ICartItemRepository extends JpaRepository<CartItem, Integer>{

}
