package com.pro.ecom.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.pro.ecom.Exception.ProductNotFoundException;
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
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
	@Override
	public Product findByIdProduct(int pid) {
		return productRepo.findById(pid)
				.orElseThrow(() -> new ProductNotFoundException(pid));
	}
	
	
	

}
