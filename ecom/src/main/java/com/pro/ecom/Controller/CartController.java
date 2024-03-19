package com.pro.ecom.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.ecom.Model.Cart;
import com.pro.ecom.Repo.CartRepo;

@RestController
@RequestMapping("/cart")

public class CartController {
	
	 @Autowired
	    private CartRepo cartRepo;

	    @PostMapping("/add")
	    public Cart addToCart(@RequestBody Cart cartItem) {
	        return cartRepo.save(cartItem);
	    }
	    @GetMapping("/cart/items")
	    public ResponseEntity<List<Cart>> getCartItems() {
	        List<Cart> cartItems = cartRepo.findAll(); 
	        return ResponseEntity.ok(cartItems);
	    }
	    
	    

}
