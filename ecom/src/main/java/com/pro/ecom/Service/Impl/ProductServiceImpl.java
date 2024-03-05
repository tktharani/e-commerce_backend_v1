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
	public Product findById(int id) {
		
		Optional<Product> tproduct = productRepo.findById(id);
		
		if(!tproduct.isEmpty())
			return tproduct.get();			
		else
			return null;	
	}
	@Override
	public Product updateProduct(int productid, String productname, String description, double price) {
		Product product = productRepo.findById(id).get();		
		product.setProductname(productname);
		product.setDescription(description);
		product.setPrice(price);
		
		
		Product savedEntity = productRepo.save(product);
		
		return savedEntity;
	
	}

}
