package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Product;
import com.app.service.ProductService;

@Controller
//@RequestMapping("/product") // https://localhost:8080/product
public class ProductController {

	@Autowired
	private ProductService service;
	
//	@GetMapping  // https://localhost:8080/product
//	public List<Product>getAllProducts(){
//		return service.getAll();
//	}

	@RequestMapping({"/products"})  // https://localhost:8080/products
	public String getallproducts(Model model) {
		model.addAttribute("products", service.getAll());
		return "product/list";
	}
	
	
}
