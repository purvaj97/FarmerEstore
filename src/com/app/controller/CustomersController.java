package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Category;
import com.app.pojos.Customer;
import com.app.service.ICategoryService;
import com.app.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomersController {

	@Autowired
	ICustomerService customerService;

	@Autowired
	ICategoryService categoryService;

	public CustomersController() {
		System.out.println("in Customer controller ctor");

	}

	@GetMapping("/login")
	public ModelAndView showLoginForm() {
		ModelAndView mv = new ModelAndView("/home/index");
		System.out.println("in show login form");
		mv.addObject("customerLogin", true);
		return mv;
	}

	// request handling method to process login form
	@PostMapping("/login") // @RequestMapping + method=post
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model map,
			RedirectAttributes flashMap, HttpSession session) {

		System.out.println("in process login form");
		// invoke dao's method for auth.
		try {

			Customer customer = customerService.authenticateCustomer(email, password);

			// valid login
			session.setAttribute("customer_details", customer); // till logout
			System.out.println("Customer info" + customer);
			flashMap.addFlashAttribute("mesg", "Login Successful");// till next request

			return "redirect:/customer/categories";

		} catch (RuntimeException e) {

			System.out.println("err in Customer controller " + e);
			map.addAttribute("mesg", "Invalid email or password");
			// invalid login
			return "redirect:/customer/login";

		}

	}

	@GetMapping("/categories")
	public ModelAndView showCategories(Model map, HttpSession session) {
		ModelAndView mv = new ModelAndView("/home/index");
		System.out.println("in show categories form");
		List<Category> list = categoryService.getCategoryList();
		System.out.println("Category list:" + list);
		mv.addObject("showCategories", true);
		session.setAttribute("category_list", list);

		return mv;
	}

	@GetMapping("/account")
	public ModelAndView showAccount(Model map, HttpSession session) {
		ModelAndView mv = new ModelAndView("/home/index");
		System.out.println("in show account");
		Customer customer = (Customer) session.getAttribute("customer_details");
		customer = customerService.getCustomerOrders(customer.getCustomerId());

		map.addAttribute("customer_details", customer);

		// return "/customer/login";
		mv.addObject("customerAccount", true);
		return mv;
	}

	@GetMapping("/register")
	public ModelAndView showRegForm(Model map) {
		ModelAndView mv = new ModelAndView("/home/index");
		System.out.println("inside showRegForm method ");

		map.addAttribute("customer", new Customer());

		mv.addObject("customerRegister", true);
		return mv;
	}

	@PostMapping("/register")
	public String processRegForm(@Valid Customer customer, BindingResult result, RedirectAttributes flashMap) {

		System.out.println("inside processRegForm method");
		flashMap.addFlashAttribute("mesg", "some error in registration, please retry..");
		if (result.hasErrors()) {
			System.out.println("P.L errs " + result);

			// in case of P.L errors --forward clnt to reg form
			return "redirect:/customer/register";
		}
		if (customerService.addCustomer(customer)) {
			flashMap.addFlashAttribute("mesg", "Registration successful");
			return "redirect:/customer/login";
		}

		return "redirect:/customer/register";
	}

	@GetMapping("/update")
	public ModelAndView showUpdateForm(@RequestParam int customerId, Model map) {
		ModelAndView mv = new ModelAndView("/home/index");
		System.out.println("inside showUpdateForm method ");
		map.addAttribute("customer", customerService.getCustomerDetails(customerId));
		mv.addObject("customerUpdate", true);
		return mv;
	}

	@PostMapping("/update")
	public String updateCustomer(@RequestParam int customerId, @Valid Customer customer, BindingResult result,
			Model map) {
		System.out.println("in update Customer" + customerId + " " + customer);
		try {
			if (customerService.updateCustomer(customerId, customer)) {
				map.addAttribute("mesg", "Customer updated successfully");
				return "redirect:/customer/account";
			}

		} catch (Exception e) {
			map.addAttribute("mesg", "Customer NOT Updated ");
			return "redirect:/customer/error";
		}
		return "/customer/list";

	}

	@GetMapping("/delete")
	public ModelAndView deleteCustomer(@RequestParam int customerId, Model map) {
		ModelAndView mv = new ModelAndView("/home/index");
		try {
			if (customerService.deleteCustomer(customerId)) {
				map.addAttribute("mesg", "Customer deleted successfully");
			}
		} catch (Exception e) {
			map.addAttribute("mesg", "Customer not deleted");
		}
		mv.addObject("customerList", true);
		return mv;
	}

	@GetMapping("/logout")
	public String showLogout(HttpSession session) {
		System.out.println("in logout page");
		session.invalidate();

		return "redirect:/customer/login";
	}

}
