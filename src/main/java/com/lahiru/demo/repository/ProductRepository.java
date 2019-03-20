package com.lahiru.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.lahiru.demo.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
