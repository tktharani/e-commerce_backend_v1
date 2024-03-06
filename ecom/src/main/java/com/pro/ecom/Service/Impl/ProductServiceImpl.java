package com.pro.ecom.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.ecom.Model.Product;
import com.pro.ecom.Repo.ProductRepo;
import com.pro.ecom.Service.ProductService;

@Service

public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public Product findById(int pid) {
		
		Optional<Product> tproduct = productRepo.findById(pid);
		
		if(!tproduct.isEmpty())
			return tproduct.get();			
		else
			return null;	
	}
	
	@Override
	public Product updateProduct(int pid, String name, String description, double price,String image) {
		
		Product product = productRepo.findById(pid).get();		
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		product.setImage(image);
		
		
		Product savedEntity = productRepo.save(product);
		
		return savedEntity;
	}

}
