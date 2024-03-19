package com.pro.ecom.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pro.ecom.Model.Cart;

public interface CartRepo extends JpaRepository<Cart, Long> {

}
