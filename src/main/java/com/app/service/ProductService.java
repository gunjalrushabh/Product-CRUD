package com.app.service;

import java.util.List;

import com.app.model.Product;

public interface ProductService {

	List<Product> getAllProduct();
	void saveProduct(Product product);
	Product getById(long id);
	void deleteProduct(long id);
	
}
