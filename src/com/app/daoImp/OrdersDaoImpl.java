package com.app.daoImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrdersRepository;
import com.app.models.Orders;

@Repository
public class OrdersDaoImpl {
	
	@Autowired
	IOrdersRepository orderRepo;
	
	public Orders getOrderDetails(int OrderId) {
		Orders orders = null;
		try {
			Optional<Orders> o=orderRepo.findById(OrderId);
			if(o.isPresent())
				orders=o.get();
			else
				System.out.println("In Oders details not found");
		}catch(Exception e) {
			e.printStackTrace();
		}
	return orders;
	}

	public List<Orders> getAllPendingOrders(){
		List<Orders> orderslist;
		try {
			orderslist = orderRepo.findPendingOrders();
		} catch (Exception e) {
			throw e;
		}
		return orderslist;
	}

	public boolean addOrder(Orders order) {
		boolean status = false;
		try {
			orderRepo.save(order);
			status = true;
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	public boolean updateOrder(Orders order) {
		boolean status = false;
		try {
			orderRepo.save(order);
			status = true;
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	
}
