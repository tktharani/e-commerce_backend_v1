package com.pro.ecom.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pro.ecom.Model.Order;
import com.pro.ecom.Repo.OrderRepo;
@Service
public class OrderService {
	private  OrderRepo orderRepo;
	public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }
	
	public Order createOrder(Order order) {
        return orderRepo.save(order);
    }
	
	public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public Order getOrderById(int id) {
        return orderRepo.findById(id).orElse(null);

}
}