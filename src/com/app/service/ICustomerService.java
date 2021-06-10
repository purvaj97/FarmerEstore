package com.app.service;

import java.util.List;

import com.app.models.Customer;




public interface ICustomerService {

	List<Customer> getCustomerList();
	
	Customer getCustomerDetails(int id);
	
	boolean addCustomer(Customer c);
	
	boolean updateCustomer(int id,Customer c);
	
	boolean deleteCustomer(int custid);

	Customer authenticateCustomer(String email, String password);

	Customer getCustomerOrders(Integer customerId);
	
}
