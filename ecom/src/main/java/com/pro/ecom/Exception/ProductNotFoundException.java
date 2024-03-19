package com.pro.ecom.Exception;

public class ProductNotFoundException extends RuntimeException {
	 public ProductNotFoundException(int id) {
	        super("Product not found with ID: " + id);
	    }
	}

