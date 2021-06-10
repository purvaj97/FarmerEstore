package com.app.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.models.Seller;



public interface ISellerRepository extends JpaRepository<Seller, Integer> {
	@Query("select s from Seller s where s.email=:email and s.password=:password")
	public Seller authenticate(@Param("email") String email,@Param("password") String password);

    @Query("select s from Seller s join fetch s.products where s.sellerId=:id")
	public Seller findDetailsbyId(@Param("id") int sellerid);

    @Query("select s from Seller s join fetch s.products where s.sellerId=:id")
    public Seller findDetailsbyProducts(@Param("id")int sellerid);

    @Query("select s from Seller s join fetch s.orders where s.sellerId=:id")
    public Seller findDetailsbyOrders(@Param("id")int sellerid);
}
