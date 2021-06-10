package com.app.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrdersDao;
import com.app.pojos.Orders;

@Repository
@Transactional
public class OrderDaoImpl implements IOrdersDao {

	@Autowired
	SessionFactory sf;

	@Override
	public Orders getOrderDetails(int orderId) {
		// TODO Auto-generated method stub
		Orders order=sf.getCurrentSession().get(Orders.class, orderId);
		return order;
	}

	@Override
	public List<Orders> getAllPendingOrders() {
		List<Orders> orders;
		String jpql = "select o from Orders o where o.status:=pending ";

		try {
			orders = sf.getCurrentSession().createQuery(jpql, Orders.class).getResultList();
		} catch (Exception e) {
			throw e;
		}
		return orders;
	}

	@Override
	public boolean addOrder(Orders order) {
		// TODO Auto-generated method stub
		boolean status = false;
		try {
			sf.getCurrentSession().save(order);
			status = true;
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	@Override
	public boolean updateOrder(Orders order) {
		// TODO Auto-generated method stub
		boolean status = false;
		try {
			
			sf.getCurrentSession().update(order);;
			status = true;
			
		} catch (Exception e) {
			throw e;
		}
		return status;
		
	}

}
