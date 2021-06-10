package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.models.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query("select c from customer c where c.email=:email and c.password=:password")
	public Customer authenticate(@Param("email") String email,@Param("password") String password);

	@Query("select c from Customer c join fetch c.orders where c.customerId=:id")
    public Customer findDetailsbyOrders(@Param("id")int customerId);

	@Query("select c from Customer c join fetch c.cart where c.customerId=:id")
    public Customer findDetailsbyCart(@Param("id")int id);

	

}
