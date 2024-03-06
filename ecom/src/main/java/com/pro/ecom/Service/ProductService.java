package com.pro.ecom.Service;

import com.pro.ecom.Model.Product;

public interface ProductService {
	Product findById(int pid);
	Product updateProduct(int pid, String pname, String description, double price,String image);


}
