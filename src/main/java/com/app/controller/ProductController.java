package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.app.model.Product;
import com.app.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("/")
	public String getAllProduct(Model model) {
		model.addAttribute("listproducts", service.getAllProduct());
		return "list";
	}
	
//	@PostMapping("/add")
	@GetMapping("/add")
	public String savingNewProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "new_product";
	 }
	
//	@PostMapping("/saveProduct")
//	public String savingPoductToDb(@ModelAttribute("product") Product product) {
//		// saving Product to db
//		service.saveProduct(product);
//		return "redirect:/";
//	}
	@PostMapping("/saveProduct")
	public String savingPoductToDb(@ModelAttribute("product") Product product, BindingResult bindingResult) {
	    if (bindingResult.hasErrors()) {
	        // Handle validation errors
	        // You can choose to show an error message or return to the form page
	    	System.out.println("Enter Proper data");
	        return "new_product";
	    } else {
	        // saving Product to db
	        service.saveProduct(product);
	        return "redirect:/";
	    }
	}

	@GetMapping("/update/{id}")
	public String viewUpdateProduct(@PathVariable(value = "id") long id, Model model) {
		Product product = new Product();
		model.addAttribute("product", service.getById(id));  //populating data with given product 
		return "productform";
	}
	
	@GetMapping("/delete/{id}") //do not use here DeleteMapping not a web Apllication
	public String deletingProduct(@PathVariable(value = "id") long id) {
		service.deleteProduct(id);
		return "redirect:/";
		
	}
	
}
