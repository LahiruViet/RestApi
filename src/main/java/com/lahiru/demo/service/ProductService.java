package com.lahiru.demo.service;

import java.util.List;

import com.lahiru.demo.entity.Product;

public interface ProductService {

	public List<Product> findAll();

	public Product save(Product product);

	public Product findById(Integer id);

	public void delete(Integer id);

}
