package com.cg.service;

import java.util.List;

import com.cg.dto.Order;
import com.cg.exception.OrderNotFoundException;


public interface OrderService {
	
	List<Order> getAllOrders();
	
	Order addNewOrder(Order order);
	
	Order getById(int orderId);

	List<Order> getOrdersByLocation(String location) throws OrderNotFoundException;

}
