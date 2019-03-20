package com.lahiru.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lahiru.demo.entity.Product;
import com.lahiru.demo.repository.ProductRepository;
import com.lahiru.demo.service.ProductService;

@Service
@Transactional 
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		List<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(products::add);
		return products;
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product findById(Integer id) {
		Optional<Product> product = productRepository.findById(id);
		return product.orElse(new Product());
	}

	@Override
	public void delete(Integer id) {
		//productRepository.deleteById(id);
	}

}
