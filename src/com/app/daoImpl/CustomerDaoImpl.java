package com.app.daoImpl;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustomerDao;
import com.app.pojos.Customer;

@Repository
@Transactional
public class CustomerDaoImpl implements ICustomerDao {

	@Autowired
	SessionFactory sf;

	public CustomerDaoImpl() {
		System.out.println("In CustomerDaoImpl constr");
	}

	@Override
	public List<Customer> getCustomerList() {
		// method returns list of all customers
		List<Customer> customers = null;
		String jpql = "select c from Customer c";

		try {
			customers = sf.getCurrentSession().createQuery(jpql, Customer.class).getResultList();
		} catch (Exception e) {
			throw e;
		}
		return customers;
	}

	@Override
	public Customer getCustomerDetails(int id) {
		// method returns customer details by id
		Customer customer = null;
		try {
			customer = sf.getCurrentSession().get(Customer.class, id);
		} catch (Exception e) {
			throw e;
		}

		return customer;
	}

	@Override
	public boolean addCustomer(Customer c) {
		// method to add new customer
		boolean status = false;
		try {
			sf.getCurrentSession().persist(c);
			status = true;
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	@Override
	public boolean updateCustomer(int id, Customer c) {
		// method to update customer details
		boolean status = false;
		try {
			sf.getCurrentSession().update(c);
			status = true;

		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	@Override
	public boolean deleteCustomer(int custid) {
		// method delete customer
		boolean status = false;
		try {
			Session hs = sf.getCurrentSession();
			Customer c = hs.get(Customer.class, custid);
			hs.delete(c);
			status = true;
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	@Override
	public Customer authenticateCustomer(String email, String password) {
		// TODO Auto-generated method stub
		Customer customer;
		try {
			customer = sf.getCurrentSession()
					.createQuery("select c from Customer c join fetch c.cart where c.email=:email and c.password=:password", Customer.class)
					.setParameter("email", email).setParameter("password", password).getSingleResult();
			System.out.println("cart found in dao");
			
		} catch (NoResultException e) {
			
			System.out.println("NoResultException catxhed in dao");
			try {
				customer = sf.getCurrentSession()
						.createQuery("select c from Customer c where c.email=:email and c.password=:password", Customer.class)
						.setParameter("email", email).setParameter("password", password).getSingleResult();
			} catch (Exception ex) {
				throw ex;
			}
			
		}

		return customer;
	}

	@Override
	public Customer getCustomerDetailsWithCart(int id) {
		// TODO Auto-generated method stub
		Customer customer;
		try {
			String jpql = "select c from Customer c join fetch c.cart where c.customerId=:id";
			customer = sf.getCurrentSession().createQuery(jpql, Customer.class).setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			throw e;
		}
		return customer;
	}

	@Override
	public Customer getCustomerOrders(Integer customerId) {
		// TODO Auto-generated method stub
		Customer customer=null;
		try {
			String jpql = "select c from Customer c join fetch c.orders where c.customerId=:id";
			customer = sf.getCurrentSession().createQuery(jpql, Customer.class).setParameter("id", customerId)
					.getSingleResult();
		} catch (NoResultException e) {
			customer=sf.getCurrentSession().get(Customer.class, customerId);
			customer.setOrders(null);
			return customer;
		}
		catch(Exception ex) {
			throw ex;
		}
		return customer;
	}

}
