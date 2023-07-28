package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Product;
import com.app.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository repo;
	
	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void saveProduct(Product product) {
		repo.save(product);
		
	}

	@Override
	public Product getById(long id) {
		// TODO Auto-generated method stub
		Optional<Product> optional = repo.findById(id);
		Product product = null;
		if(optional.isPresent()) {
			product = optional.get();
		}
		else {
			throw new RuntimeException("Product not found having id: "+id);
		}
		return product;
	}

	@Override
	public void deleteProduct(long id) {

		repo.deleteById(id);
	}

}
