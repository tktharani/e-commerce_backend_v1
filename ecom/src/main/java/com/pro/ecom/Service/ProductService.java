package com.pro.ecom.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pro.ecom.Model.Product;
import com.pro.ecom.Repo.ProductRepo;

public interface ProductService {
	
	List<Product> getAllProducts();

	Product findById(int pid);
	
	 
        
        
	
}
