package com.app.daoImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerRepository;
import com.app.models.Customer;

@Repository
public class CustomerDaoImpl {

	@Autowired
	ICustomerRepository customerRepo;

	public CustomerDaoImpl() {
		System.out.println("In customerDaoImpl constructor");
	}

	public List<Customer> getCustomerList() {
		List<Customer> customerList = customerRepo.findAll();
		return customerList;
	}

	public Customer getCustomerDetails(int id) {
		Customer customer = null;
		try {
			Optional<Customer> o = customerRepo.findById(id);
			if (o.isPresent())
				customer = o.get();
			else
				System.out.println("In customer details not found");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	public boolean addCustomer(Customer c) {
		boolean status = false;
		try {
			customerRepo.save(c);
			status = true;
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	public boolean updateCustomer(int id, Customer c) {
		boolean status = false;
		if (customerRepo.existsById(id)) {
			customerRepo.save(c);
			status = true;
			System.out.println("Seller update Dao: " + c);
		} else {
			System.out.println("Update Customer details not found");
		}
		return status;
	}

	public boolean deleteCustomer(int custid) {
		boolean status = false;
		try {
			customerRepo.deleteById(custid);
			status = true;
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	public Customer authenticateCustomer(String email, String password) {
		Customer customer = customerRepo.authenticate(email, password);
		if (customer != null)
			System.out.println("Successfully Login");
		else
			System.out.println("Invalid email or password");
		return customer;
	}

	public Customer getCustomerDetailsWithCart(int id) {
		Customer customer;
		try {
			customer = customerRepo.findDetailsbyCart(id);
		} catch (Exception e) {
			throw e;
		}
		return customer;
	}

	public Customer getCustomerOrders(Integer customerId) {
		Customer customer;
		try {
			customer = customerRepo.findDetailsbyOrders(customerId);
		} catch (Exception e) {
			throw e;
		}
		return customer;
	}

}
