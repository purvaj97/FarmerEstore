package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.models.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {

}
