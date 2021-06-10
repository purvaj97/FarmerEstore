package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.app.models.Orders;

public interface IOrdersRepository extends JpaRepository<Orders, Integer>{
	
	@Query("select o from Orders o where o.status:=pending ")
	public List<Orders> findPendingOrders();
}
