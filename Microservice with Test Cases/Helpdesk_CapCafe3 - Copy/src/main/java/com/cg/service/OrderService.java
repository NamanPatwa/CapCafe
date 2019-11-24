package com.cg.service;

import java.util.List;


import com.cg.entity.Orders;
import com.cg.exception.OrderNotFoundException;

import javassist.tools.rmi.ObjectNotFoundException;

public interface OrderService {
	
	List<Orders> getAllOrders();
	
	Orders addNewOrder(Orders order);
	
	Orders getById(int orderId);

	List<Orders> getOrdersByLocation(String location) throws OrderNotFoundException;

}
