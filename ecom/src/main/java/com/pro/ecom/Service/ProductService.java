package com.pro.ecom.Service;

import java.util.List;

import com.pro.ecom.Model.Product;

public interface ProductService {
	
	List<Product> getAllProducts();

	Product findById(int pid);
	
}
