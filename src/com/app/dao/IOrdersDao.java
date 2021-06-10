package com.app.dao;

import java.util.List;

import com.app.pojos.Orders;

public interface IOrdersDao {
	
	public Orders getOrderDetails(int OrderId);

	public List<Orders> getAllPendingOrders();

	public boolean addOrder(Orders order);

	public boolean updateOrder(Orders order);

}
