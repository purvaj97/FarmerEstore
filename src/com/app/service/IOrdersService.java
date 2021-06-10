package com.app.service;

import com.app.pojos.Customer;
import com.app.pojos.Orders;

public interface IOrdersService {

	boolean addOrders(Customer customer) throws Exception;
	
	Orders getOrder(int orderId);

	boolean updateOrder(Orders order);
	
}
