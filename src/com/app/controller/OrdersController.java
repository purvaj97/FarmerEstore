package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.pojos.Customer;
import com.app.pojos.Orders;
import com.app.service.ICustomerService;
import com.app.service.IOrdersService;

@Controller
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	IOrdersService ordersService;

	@Autowired
	ICustomerService customerService;

	public OrdersController() {
		System.out.println("orders controller");
	}

	@GetMapping("/payment")
	public ModelAndView showPaymentPage(HttpSession session) {
		ModelAndView mv = new ModelAndView("/home/index");
		try {
			Customer customer = (Customer) session.getAttribute("customer_details");
			System.out.println("Cart in payment:" + customer.getCart());
			mv.addObject("showPaymentPage", true);
		} catch (Exception e) {
			mv.addObject("error", true);
		}
		return mv;
	}

	@GetMapping("/makepayment")
	public String makePayment(HttpSession session) {

		try {
			return "redirect:/orders/placeorder";
		} catch (Exception ex) {
			System.out.println("exception:" + ex);
			return "redirect:/orders/placeorder";
		}

	}

	@PostMapping("/placeorder")
	public ModelAndView placeOrders(HttpSession session) {

		ModelAndView mv = new ModelAndView("/home/index");
		System.out.println("Order placed controller...");

		try {
			Customer customer = (Customer) session.getAttribute("customer_details");
			System.out.println("Customer:" + customer);
			ordersService.addOrders(customer);
			session.setAttribute("customer_details", customerService.getCustomerDetails(customer.getCustomerId()));
			mv.addObject("placedOrder", true);
		} catch (Exception e) {
			mv.addObject("error", true);
		}
		return mv;
	}

	@PostMapping("/update")
	public String updateOrder(@RequestParam int orderId) {
		try {
			
			System.out.println("inside update order"+orderId);
			Orders order = ordersService.getOrder(orderId);
			System.out.println("order:"+order);
			boolean st=ordersService.updateOrder(order);
			System.out.println("status:"+st);
			return "redirect:/seller/orderlist";
		} catch (Exception e) {
			return "redirect:/seller/error";
		}
	}
}
