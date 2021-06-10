package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.pojos.Category;
import com.app.service.ICategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	ICategoryService categoryService;

	public CategoryController() {
		System.out.println("in category controller ctor");

	}
	
	@GetMapping("/getcat")
	public ModelAndView showcategories(Model map,HttpSession session) {
		ModelAndView mv=new ModelAndView("/home/index");
		System.out.println("in showcategories");
	
		List<Category> list = categoryService.getCategoryList();
		if (list.size() != 0) {
			map.addAttribute("category_list", list);
			mv.addObject("clickCategoryList", true);
			
		} else {
			map.addAttribute("mesg", "List Not Found");
			mv.addObject("errorCatList", true);
		}
		return mv;
	}
	
}
