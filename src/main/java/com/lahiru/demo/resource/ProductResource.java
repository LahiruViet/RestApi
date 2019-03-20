package com.lahiru.demo.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lahiru.demo.entity.Product;
import com.lahiru.demo.service.ProductService;

@RestController
@RequestMapping("/rest/api/")
public class ProductResource {

	@Autowired
	private ProductService productService;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductResource.class);
	
	@GetMapping("products")
	public ResponseEntity<List<Product>> findAll(){
		return ResponseEntity.ok(productService.findAll());	
	}
	
	@GetMapping("products/{id}")
	public ResponseEntity<Product> findById(@PathVariable Integer id){
		return ResponseEntity.ok(productService.findById(id));	
	}
	
	@PostMapping("products")
	public ResponseEntity<Product> save(@RequestBody Product product, HttpServletRequest request){
		Product savedProduct = productService.save(product);
		URI uri = null;
		try {
			uri = new URI(request.getRequestURL()+"/"+savedProduct.getId());
		} catch (URISyntaxException e) {
			logger.error(e.toString());
		}
		return ResponseEntity.created(uri).body(product);
	}
	
	@PutMapping("products")
	public ResponseEntity<Product> update(@RequestBody Product product){
		return ResponseEntity.ok(product);	
	}
	
	@DeleteMapping("products/{id}")
	public ResponseEntity<Product> delete(@PathVariable Integer id){
		productService.delete(id);
		return ResponseEntity.noContent().build();	
	}
}
