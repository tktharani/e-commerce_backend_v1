package com.pro.ecom.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pro.ecom.Exception.ProductNotFoundException;
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
	public ResponseEntity<?> addProduct(@RequestBody Product product){
		Product savedEntity =productRepo.saveAndFlush(product);
		return ResponseEntity.status(HttpStatus.OK)
				.body(product);	
		}
	
	 @GetMapping("/listproduct")
	    public ResponseEntity<List<Product>> getAllProducts() {
	        List<Product> products = productService.getAllProducts();
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }
	 @GetMapping("/productget/{id}")
	 Product getProductById(@PathVariable int id) {
		 return productRepo.findById(id)
				 .orElseThrow(()->new ProductNotFoundException(id));
	 }
	 
	 @PutMapping("/update/{id}")
	 Product updateProduct(@RequestBody Product product,@PathVariable int id) {
		 return productRepo.findById(id)
				 .map(user ->{
					 user.setName(product.getName());
					 user.setDescription(product.getDescription());
					 user.setPrice(product.getPrice());
					 user.setImage(product.getImage());
					 user.setCategoryname(product.getCategoryname());
					 return productRepo.save(product);
				 }).orElseThrow(()->new ProductNotFoundException(id));
	 }

	 @DeleteMapping("/delete/{id}")
	 String deleteProduct(@PathVariable int id) {
		 if(!productRepo.existsById(id)) {
			 throw new ProductNotFoundException(id);
		 }
		 productRepo.deleteById(id);
		  return "user with id "+id+" has been deleted success";
		 }
	}
	 


