package com.pro.ecom.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pro.ecom.Model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
