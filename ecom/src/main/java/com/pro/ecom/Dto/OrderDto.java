package com.pro.ecom.Dto;

import java.util.List;

import com.pro.ecom.Model.OrderItem;
import com.pro.ecom.Model.User;

public class OrderDto {
	private User  user;
    private String status;
    private double totalprice;
    private List<OrderItem> orderItems;


}
