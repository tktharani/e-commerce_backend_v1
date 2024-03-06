package com.pro.ecom.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.pro.ecom.Model.Product;
import com.pro.ecom.Repo.ProductRepo;
import com.pro.ecom.Service.ProductService;

@RestController
@RequestMapping("/product")

public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepo productRepo;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> addStudent(@RequestBody Product product){
		Product savedEntity =productRepo.saveAndFlush(product);
		return ResponseEntity.status(HttpStatus.OK)
				.body(product);	

}
}
