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
import com.app.pojos.Product;
import com.app.pojos.Seller;
import com.app.service.ICategoryService;
import com.app.service.IProductService;
import com.app.service.ISellerService;

@Controller
@RequestMapping("/seller")
public class SellersController {

	@Autowired
	ISellerService sellerService;

	@Autowired
	ICategoryService categoryService;

	@Autowired
	IProductService productService;

	public SellersController() {
		System.out.println("in Seller controller ctor");
	}

	@GetMapping("/account")
	public ModelAndView showProfile( HttpSession session) {
		ModelAndView mv = new ModelAndView("/home/index");
		System.out.println("in show login form");
		Seller seller = (Seller) session.getAttribute("seller_details");
		Seller sellerDetails = sellerService.getSellerDetails(seller.getSellerId());
		session.setAttribute("seller_details", sellerDetails);
		// return "/customer/login";
		mv.addObject("sellerAccount", true);
		return mv;
	}
	
	//main login page for seller
	@GetMapping("/login")
	public ModelAndView showLoginForm() {
		ModelAndView mv = new ModelAndView("/home/index");
		System.out.println("in show login form");
		mv.addObject("sellerLogin", true);
		return mv;
	}

	// request handling method to process login form
	@PostMapping("/login") // @RequestMapping + method=post
	public ModelAndView processLoginForm(@RequestParam String email, @RequestParam String password, Model map,
			RedirectAttributes flashMap, HttpSession session) {
		System.out.println("in process login form");
		ModelAndView mv = new ModelAndView("/home/index");

		// invoke dao's method for auth.
		try {

			Seller seller = sellerService.authenticateSeller(email, password);

			// if valid login
			session.setAttribute("seller_details", seller); // till logout
			System.out.println("seller info" + seller);
			flashMap.addFlashAttribute("mesg", "Login Successful"); // till next request
			mv.addObject("sellerTask", true);
			return mv;

		} catch (RuntimeException e) {

			System.out.println("err in seller controller " + e);
			map.addAttribute("mesg", "Invalid email or password");
			// invalid login
			mv.addObject("sellerLogin", true);
			return mv;

		}

	}

	@GetMapping("/productlist")
	public ModelAndView getProductListBySeller(HttpSession session, Model map) {
		System.out.println("inside get products Seller");
		ModelAndView mv = new ModelAndView("/home/index");
		Seller seller = (Seller) session.getAttribute("seller_details");
		Seller sellerDetails = sellerService.getSellerDetailsByProducts(seller.getSellerId());
		List<Product> productList = sellerDetails.getProducts();
		try {
		if (productList.size() != 0) {
			map.addAttribute("product_list", productList);
			mv.addObject("productListSeller", true);
			return mv;
		}
		} catch(Exception e) {
			map.addAttribute("msg", "List Not Found");
			return mv;
		}
		return mv;
	}

	@GetMapping("/orderlist")
	public ModelAndView getOrdersListBySeller(HttpSession session, Model map) {
		System.out.println("inside get orders Seller");
		ModelAndView mv = new ModelAndView("/home/index");
		try {
			Seller seller = (Seller) session.getAttribute("seller_details");
			Seller sellerDetails = sellerService.getSellerDetailsByOrders(seller.getSellerId());
			session.setAttribute("seller_details", sellerDetails);
			mv.addObject("ordersList", true);
			return mv;
		} catch (Exception e) {
			map.addAttribute("mesg", "List Not Found");
			return mv;
		}

	}

	@GetMapping("/list")
	public ModelAndView getAllSeller(Model map) {
		System.out.println("inside getAllSeller");
		ModelAndView mv = new ModelAndView("/home/index");

		List<Seller> list = sellerService.getSellerList();
		if (list.size() != 0) {
			map.addAttribute("seller_list", list);
			mv.addObject("sellerList", true);

			return mv;

		} else {
			map.addAttribute("mesg", "List Not Found");
			return mv;

		}
	}

	@GetMapping("/register")
	public ModelAndView showRegForm(Model map) {
		ModelAndView mv = new ModelAndView("/home/index");
		System.out.println("inside showRegForm method ");
		map.addAttribute("seller", new Seller());
		mv.addObject("sellerRegister", true);
		return mv;
	}

	@PostMapping("/register")
	public String processRegForm(@Valid Seller seller, BindingResult result, RedirectAttributes flashMap) {

		System.out.println("inside processRegForm method");
		flashMap.addFlashAttribute("mesg","some error in registration, please retry..");
		if (result.hasErrors()) {
			System.out.println("P.L errs " + result);
			// in case of P.L errors --forward clnt to reg form
			return "redirect:/seller/register";
		}
		if(sellerService.addSeller(seller)) {
			seller.setStatus("not verified");
			flashMap.addFlashAttribute("mesg", "Registration successful");
			return "redirect:/seller/login";
		}
		return "redirect:/seller/register";
	}
		

	@GetMapping("/update")
	public ModelAndView showUpdateForm(@RequestParam int sellerId,Model map) {
		ModelAndView mv = new ModelAndView("/home/index");
		System.out.println("inside showUpdateForm method ");
		mv.addObject("seller", sellerService.getSellerDetails(sellerId));
		mv.addObject("sellerUpdate", true);
		return mv;
	}

	@PostMapping("/update")
	public String updateSeller(@RequestParam int sellerId,@Valid Seller seller, BindingResult result, Model map) {
		System.out.println("in update Seller" +sellerId +  " " + seller);
		try {
			if (sellerService.updateSeller(sellerId, seller)) {

				map.addAttribute("mesg", "Seller updated successfully");
				return "redirect:/seller/account";
			}

		} catch (Exception e) {
			map.addAttribute("mesg", "Seller NOT Updated ");
			return "redirect:/seller/error";
		}
		
		return "/seller/list";

	}

	@GetMapping("/delete")
	public ModelAndView deleteSeller(@RequestParam int sellerId, Model map) {
		ModelAndView mv = new ModelAndView("/home/index");

		try {
			if (sellerService.deleteSeller(sellerId)) {
				map.addAttribute("mesg", "Seller deleted successfully");
			}
		} catch (Exception e) {
			map.addAttribute("mesg", "Seller not deleted");
		}
		mv.addObject("sellerList", true);

		return mv;
	}

	@GetMapping("/sellerCategoryList")
	public ModelAndView showCategories(Model map) {
		ModelAndView mv = new ModelAndView("/home/index");
		List<Category> list = categoryService.getCategoryList();
		map.addAttribute("category_list", list);
		System.out.println("in show categories form");
		mv.addObject("SellercategoryList", true);
		return mv;
	}

	@GetMapping("/logout")
	public String showLogout(HttpSession session) {
		System.out.println("in logout page");
		session.invalidate();
		return "redirect:/home/login";
	}

	@GetMapping("/task")
	public ModelAndView showtask() {
		ModelAndView mv = new ModelAndView("/home/index");
		System.out.println("in show task");
		mv.addObject("sellerTask", true);
		return mv;
	}

}
