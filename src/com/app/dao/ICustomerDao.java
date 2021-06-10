package com.app.dao;

import java.util.List;

import com.app.pojos.Customer;

public interface ICustomerDao {

	List<Customer> getCustomerList();
	
	Customer getCustomerDetails(int id);
	
	Customer getCustomerDetailsWithCart(int id);
	
	boolean addCustomer(Customer c);
	
	boolean updateCustomer(int id,Customer c);
	
	boolean deleteCustomer(int custid);

	Customer authenticateCustomer(String email, String password);

	Customer getCustomerOrders(Integer customerId);
	
}
