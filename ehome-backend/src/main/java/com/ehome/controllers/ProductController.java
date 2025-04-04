package com.ehome.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ehome.entities.Product;
import com.ehome.services.ProductService;



@RestController
@RequestMapping(value = "/api/auth/products")

public class ProductController {
	
	@Autowired
	private ProductService service;
	
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> products = service.findAll();
		return new ResponseEntity<>(products,HttpStatus.OK);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		 Product product = service.findById(id);
		 return ResponseEntity.ok().body(product);
	}
	@PostMapping("/addPro")
	public ResponseEntity<Product> saveProduct(@RequestBody Product pro)
	{
		Product p = service.insert(pro);
		HttpHeaders headers = new HttpHeaders();
		headers.add("pro", "/api/auth/products/addPro"+p.getId());
		return new ResponseEntity<>(p,headers,HttpStatus.OK);
		
	}


}
