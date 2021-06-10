package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daoImp.CartDaoImpl;
import com.app.daoImp.CustomerDaoImpl;
import com.app.models.Cart;
import com.app.models.Customer;


@Service
public class CustomerService implements ICustomerService {

	@Autowired
	CustomerDaoImpl customerDao;

	@Autowired
	CartDaoImpl cartDao;

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
		
		return customerDao.addCustomer(c);
	}

	@Override
	public boolean updateCustomer(int id, Customer c) {
		
		return customerDao.updateCustomer(id, c);
	}

	@Override
	public boolean deleteCustomer(int custid) {
		
		return customerDao.deleteCustomer(custid);
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
