package com.pro.ecom.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pro.ecom.Model.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
	@Query(value = "Select * from Products Where categoryname = :categoryname", nativeQuery = true)
    List<Product> findByName(String categoryname);
	

}
