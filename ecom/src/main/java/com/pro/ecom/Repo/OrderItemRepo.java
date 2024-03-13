package com.pro.ecom.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pro.ecom.Model.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem,Long> {

}
