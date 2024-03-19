package com.pro.ecom.Controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pro.ecom.Exception.InvalidProductIdFormatException;
import com.pro.ecom.Exception.ProductNotFoundException;
import com.pro.ecom.Model.Product;

import com.pro.ecom.Repo.ProductRepo;
import com.pro.ecom.Service.ProductService;
import com.pro.ecom.response.ApiResponse;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepo productRepo;

    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping("/listproduct")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> productList = productRepo.findAll();
        return ResponseEntity.ok(productList);
    }

    

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@Valid @RequestBody Product product) {
        try {
            productRepo.save(product);
            return ResponseEntity.ok(new ApiResponse("Product added successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Failed to add product"));
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return ResponseEntity.ok(product);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateProduct(@Valid @RequestBody Product updatedProduct, @PathVariable int id) {
        try {
            Product existingProduct = productRepo.findById(id)
                    .orElseThrow(() -> new ProductNotFoundException(id));

            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setImage(updatedProduct.getImage());
            existingProduct.setCategoryname(updatedProduct.getCategoryname());

            productRepo.save(existingProduct);

            return ResponseEntity.ok().body(new ApiResponse("Product updated successfully"));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Product not found"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Failed to update product"));
        }
    }


        @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable int id) {
        try {
            if (productRepo.existsById(id)) {
                productRepo.deleteById(id);
                return ResponseEntity.ok(new ApiResponse("Product deleted successfully"));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Product not found"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Failed to delete product"));
        }
    }
}





