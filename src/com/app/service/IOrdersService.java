package com.app.service;

import com.app.models.Customer;
import com.app.models.Orders;

public interface IOrdersService {

	boolean addOrders(Customer customer) throws Exception;
	
	Orders getOrder(int orderId);

	boolean updateOrder(Orders order);
	
}
