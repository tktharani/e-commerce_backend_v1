package com.pro.ecom.Service;

public interface ProductService {
	Product findById(int id);
	Product updateProduct(int productid,String productname, String description, double price);

}
