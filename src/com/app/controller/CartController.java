package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.pojos.Customer;
import com.app.service.CartService;
import com.app.service.CustomerService;
import com.app.service.ProductService;

@Controller
@RequestMapping("customer/cart")
public class CartController {

	@Autowired
	CustomerService customerService;

	@Autowired
	ProductService productService;

	@Autowired
	CartService cartService;

	public CartController() {
		System.out.println("in cart controller ctor");
	}

	@GetMapping("/showcart")
	public ModelAndView getCart(HttpSession session, Model map) {
		// session is the person who is currently logged in
		Customer customer = (Customer) session.getAttribute("customer_details");
		session.setAttribute("customer_details", customerService.getCustomerDetails(customer.getCustomerId()));
		ModelAndView mv = new ModelAndView("/home/index");
		System.out.println("customer:" + customer);
		if(customer.getCart() == null) {
			customer = customerService.authenticateCustomer(customer.getEmail(), customer.getPassword());
		}
		System.out.println("cart:" + customer.getCart());
		System.out.println("cartItems:" + customer.getCart().getCartItems());
		map.addAttribute("cart", customer.getCart());
		mv.addObject("showCart", true);

		return mv;
	}

	@GetMapping("/addtocart")
	public String addToCart(@RequestParam int productId, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer_details");
		System.out.println("Prod id"+productId);
		cartService.addCartItem(productId, customer.getCart());
		session.setAttribute("customer_details", customerService.getCustomerDetails(customer.getCustomerId()));
		return "redirect:/customer/cart/showcart";
	}

	@GetMapping("/increasequantity")
	public String increaseQuantity(@RequestParam int cartItemId, HttpSession session) {
		System.out.println("increase quantity method ");
		System.out.println("Cart item:" + cartItemId + "  " + 1);

		Customer customer = (Customer) session.getAttribute("customer_details");
		cartService.updateCartItem(cartItemId, 1, customer.getCart());

		session.setAttribute("customer_details", customerService.getCustomerDetails(customer.getCustomerId()));
		return "redirect:/customer/cart/showcart";

	}

	@GetMapping("/decreasequantity")
	public String decreaseQuantity(@RequestParam int cartItemId, HttpSession session) {
		System.out.println("decrease quantity method ");
		System.out.println("Cart item:" + cartItemId + "  " + -1);

		Customer customer = (Customer) session.getAttribute("customer_details");

		cartService.updateCartItem(cartItemId, -1, customer.getCart());

		session.setAttribute("customer_details", customerService.getCustomerDetails(customer.getCustomerId()));
		return "redirect:/customer/cart/showcart";

	}

	@GetMapping("/removecartitem")
	public String deleteItem(@RequestParam int cartItemId, Model map, HttpSession session) {
		try {

			Customer customer = (Customer) session.getAttribute("customer_details");
			if (cartService.deleteCartItem(cartItemId, customer.getCart())) {

				System.out.println("cart Item deleted");

				session.setAttribute("customer_details", customerService.getCustomerDetails(customer.getCustomerId()));
				map.addAttribute("mesg", "Item deleted successfully");

			}
		} catch (Exception e) {
			map.addAttribute("mesg", "Item not deleted");
		}
		return "redirect:/customer/cart/showcart";
	}

	@GetMapping("/checkout")
	public String processCheckout(HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer_details");
		System.out.println("checkout method");
		System.out.println("Cart:" + customer.getCart());
		System.out.println("cartitems:" + customer.getCart().getCartItems());

		return "redirect:/orders/payment";
	}
}
