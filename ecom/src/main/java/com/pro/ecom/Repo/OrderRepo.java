package com.pro.ecom.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.ecom.Model.Order;
@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
	}
