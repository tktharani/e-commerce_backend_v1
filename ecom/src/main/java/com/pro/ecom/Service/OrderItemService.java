package com.pro.ecom.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.ecom.Model.OrderItem;
import com.pro.ecom.Repo.OrderItemRepo;
import com.pro.ecom.Repo.OrderRepo;

@Service
public class OrderItemService {
	private  OrderItemRepo orderItemRepo;

	@Autowired
    public OrderItemService(OrderItemRepo orderItemRepo) {
        this.orderItemRepo = orderItemRepo;
    }
	
	public OrderItem createOrderItem(OrderItem orderItem) {
        
        return orderItemRepo.save(orderItem);
    }
	public OrderItem updateOrderItem(OrderItem orderItem) {
        
        return orderItemRepo.save(orderItem);
    }

    public void deleteOrderItem(Long id) {
        orderItemRepo.deleteById(id);
    }
	
	
	

}
