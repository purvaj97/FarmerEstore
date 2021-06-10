package com.app.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.models.Category;
import com.app.models.Product;
import com.app.models.Seller;
import com.app.service.ICategoryService;
import com.app.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductsController {

	@Value("${upload_image_path}")
	private String imagePath;

	@Autowired
	IProductService productService;

	@Autowired
	ICategoryService categoryService;
	
	@Autowired
	private HttpServletRequest request;

	public ProductsController() {
		System.out.println("in products controller ctor");
	}

	

	@GetMapping("/addproduct")
	public ModelAndView addProduct(Model map) {
		ModelAndView mv = new ModelAndView("/home/index");
		System.out.println("inside showRegForm method ");
		map.addAttribute("product", new Product());
		mv.addObject("categoryList", categoryService.getCategoryList());
		mv.addObject("addProduct", true);
		return mv;
	}

	@PostMapping("/addproduct")
	public String addProduct(@Valid Product product, BindingResult result, @RequestParam String category,
			HttpSession session) {

		System.out.println("inside addProduct post method");
		try {
			System.out.println("Product:" + product);
			session.setAttribute("product", product);
			session.setAttribute("categoryName", category);
		} catch (Exception e) {
			throw e;
		}
		return "redirect:selectimage";
	}

	@GetMapping("/selectimage")
	public ModelAndView uploadImage(Model map) {
		ModelAndView mv = new ModelAndView("/home/index");
		System.out.println("inside show image upload ");
		mv.addObject("uploadImage", true);
		return mv;
	}

	@PostMapping("/uploadimage")
	public String addImage(@RequestParam MultipartFile file, HttpSession session) {

		//String uploadLocation = imagePath;
		String uploadLocation = request.getServletContext().getRealPath("/resources/images/products");
		//String uploadLocation =temp+"images/products";
		// E:\CDAC\javabasica1\AdvanceJava\FarmerMid\WebContent\resources\images\products
		System.out.println("uploadLocation:" + uploadLocation);
		if (file.isEmpty()) {
			System.out.println("file is empty");
		}

		try {

			Product product = (Product) session.getAttribute("product");
			// Get the file and save it somewhere
			uploadLocation +="/"+file.getOriginalFilename();
			File dest = new File(uploadLocation);
			// file transferred to server side folder
			file.transferTo(dest);
			System.out.println(1);
			System.out.println("upload location :" + uploadLocation + "//" + file.getOriginalFilename());

			System.out.println("You successfully uploaded " + file.getOriginalFilename());
			// set product url
			product.setImageUrl(file.getOriginalFilename());
			// persist product to db
			String categoryName = (String) session.getAttribute("categoryName");
			Seller seller = (Seller) session.getAttribute("seller_details");
			System.out.println("Product adding status:" + productService.addProduct(product, categoryName, seller));

		} catch (IOException e) {
			e.printStackTrace();

		}
		return "redirect:/seller/task";

	}

	@PostMapping("/update")
	public ModelAndView showUpdateForm(@RequestParam int productId, Model map) {
		ModelAndView mv = new ModelAndView("/home/index");
		try {
			Product product = productService.getProductDetails(productId);
			map.addAttribute("product", product);
			mv.addObject("updateProduct", true);

		} catch (Exception e) {
			mv.addObject("errorInUpdate", true);
		}
		return mv;
	}

	@PostMapping("/updateproduct")
	public String updateProduct(@RequestParam int productId, @RequestParam int quantity, RedirectAttributes flashMap) {
		try {
			System.out.println("Product:0"+productId);
			if (productService.updateProduct(productId, quantity)) {
				flashMap.addAttribute("mesg", "product updated successfully");
			}
		} catch (Exception e) {
			flashMap.addAttribute("mesg", "error in updating product");
			return "redirect:/seller/error";
		}
		return "redirect:/seller/productlist";
	}
	@GetMapping("/listbycategory")
	public ModelAndView retrieveProductsByCatagory(@RequestParam String categoryName, Model map) {
		System.out.println("inside getAllProductsby Catagory");
		ModelAndView mv = new ModelAndView("/home/index");

		Category category = categoryService.getCategoryDetails(categoryName);
		System.out.println(category);

		if (category.getProducts().size() != 0) {
			System.out.println("list added");
			map.addAttribute("product_list", category.getProducts());
			mv.addObject("productList", true);
			return mv;
		} else {
			System.out.println("list not found");
			map.addAttribute("mesg", "List Not Found");
			return mv;
		}
	}

	@PostMapping("/delete")
	public String deleteProduct(@RequestParam int productId, RedirectAttributes flashMap) {

		try {
			if (productService.deleteProduct(productId)) {
				flashMap.addAttribute("mesg", "product deleted successfully");
				
			}
		} catch (Exception e) {
			flashMap.addAttribute("mesg", "product not deleted");
			return "redirect:/seller/error";
		}
		return "redirect:/seller/productlist";
	}

	@PostMapping("/details")
	public ModelAndView getProductDetails(@RequestParam int productId, Model map) {

		ModelAndView mv = new ModelAndView("/home/index");
		try {
			map.addAttribute("product", productService.getProductDetails(productId));
		} catch (Exception e) {
			map.addAttribute("mesg", "product not available");
		}
		mv.addObject("productDetails", true);

		return mv;
	}
}
