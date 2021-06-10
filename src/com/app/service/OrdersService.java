package com.app.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daoImp.CartDaoImpl;
import com.app.daoImp.OrdersDaoImpl;
import com.app.daoImp.ProductDaoImpl;
import com.app.models.Cart;
import com.app.models.CartItem;
import com.app.models.Customer;
import com.app.models.Orders;
import com.app.models.Product;



@Service
public class OrdersService implements IOrdersService {

	@Autowired
	OrdersDaoImpl orderDao;

	@Autowired
	CartDaoImpl cartDao;
	
	@Autowired
	ProductDaoImpl productDao;

	@Override
	public boolean addOrders(Customer customer) {
		// TODO Auto-generated method stub
		boolean status = false;
		try {
			Cart cart = customer.getCart();
			System.out.println("cart in addorders:" + cart);
			for (CartItem cartItem : cart.getCartItems()) {

				DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date dateobj = new Date();
				String date = sdf.format(dateobj);
				System.out.println(date);

				Orders order = new Orders(date, cartItem.getProduct().getProductName(),
						cartItem.getProduct().getWeight(), cartItem.getQuantity(), cartItem.getValue(),
						customer.getBillingAddress(), customer.getShippingAddress());

				order.setCustomer(customer);
				order.setSeller(cartItem.getProduct().getSeller());
				System.out.println("Order:" + order);
				orderDao.addOrder(order);
				//remove product from inventory
				Product product = cartItem.getProduct();
				int quantity = product.getQuantity() - cartItem.getQuantity();
				productDao.updateProduct(product.getId(), quantity);
				
				System.out.println("order placed:" + order);

			}
			System.out.println("all orders placed");
			for (CartItem cartItem : cart.getCartItems()) {
				cartDao.deleteCartItem(cartItem.getCartItemId());
			}
			cartDao.deleteCart(cart);
			System.out.println("cart cleared ");
			Cart newCart = new Cart();
			cart.setCustomer(customer);
			cartDao.addCart(newCart);
			status = true;
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	
	@Override
	public Orders getOrder(int orderId) {
		// TODO Auto-generated method stub
		Orders order;
		try {
			order = orderDao.getOrderDetails(orderId);
		}
		catch(Exception e) {
			throw e;
		}
		return order;
	}

	@Override
	public boolean updateOrder(Orders order) {
		// TODO Auto-generated method stub
		boolean status = false;
		try {
			order.setStatus("delivered");
			orderDao.updateOrder(order);
		}
		catch(Exception e) {
			throw e;
		}
		return status;
	}

}
