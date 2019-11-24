package com.cg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.Order;
import com.cg.exception.OrderNotFoundException;
import com.cg.repo.OrderRepo;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo repo;
	
	@Override
	public List<Order> getAllOrders() {
		return repo.findAll();
	}
	
	@Override
	public Order addNewOrder(Order order) {
		return repo.save(order);
	}

	@Override
	public Order getById(int orderId) {
		return repo.findById(orderId).get();
	}
	
	@Override
	public List<Order> getOrdersByLocation(String location) throws OrderNotFoundException {
		List<Order> orders = repo.getOrderByLocation(location);
		if(orders.size() == 0) {
			throw new OrderNotFoundException("Order with given location not found");
		}
		return orders;
	}

}
