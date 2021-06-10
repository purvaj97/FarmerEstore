package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICartDao;
import com.app.dao.ICustomerDao;
import com.app.pojos.Cart;
import com.app.pojos.Customer;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	ICustomerDao customerDao;

	@Autowired
	ICartDao cartDao;

	@Override
	public List<Customer> getCustomerList() {
		// method returns list of all customers
		List<Customer> customers = customerDao.getCustomerList();
		if (customers != null)
			return customers;
		return null;
	}

	@Override
	public Customer getCustomerDetails(int id) {
		// method returns customer details by id
		return customerDao.getCustomerDetails(id);
	}

	@Override
	public boolean addCustomer(Customer c) {
		// method to add new customer
		boolean status = false;
		if (customerDao.addCustomer(c)) {
			status = true;
		}
		return status;
	}

	@Override
	public boolean updateCustomer(int id, Customer c) {
		// method to update customer details
		boolean status = false;
		c.setCustomerId(id);
		if (customerDao.updateCustomer(id, c)) {
			status = true;
		}
		return status;
	}

	@Override
	public boolean deleteCustomer(int custid) {
		// method delete customer
		boolean status = false;
		if (customerDao.deleteCustomer(custid)) {
			status = true;
		}
		return status;
	}

	@Override
	public Customer authenticateCustomer(String email, String password) {
		// TODO Auto-generated method stub
		Customer customer = null;
		try {

			customer = customerDao.authenticateCustomer(email, password);
			System.out.println("found cart ");

			if ( customer.getCart() == null ) {
				System.out.println("adding new cart");
				Cart cart = new Cart();

				// add cart for customer
				cart.setCustomer(customer);
				// persist cart
				cartDao.addCart(cart);
				//fetch updated customer
				customer =customerDao.getCustomerDetails(customer.getCustomerId());
				System.out.println("authenticate service:"+customer+""+customer.getCart()+" "+customer.getOrders());
			}
		}
		catch(Exception e) {
			throw e;
		}
		
		return customer;

	}

	@Override
	public Customer getCustomerOrders(Integer customerId) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerOrders(customerId);
	}

}
