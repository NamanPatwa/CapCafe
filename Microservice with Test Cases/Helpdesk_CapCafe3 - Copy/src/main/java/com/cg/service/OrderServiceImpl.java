package com.cg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Orders;
import com.cg.exception.OrderNotFoundException;
import com.cg.repo.OrderRepo;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo repo;
	
	static Logger myLogger =  Logger.getLogger(OrderServiceImpl.class);
	
	@Override
	public List<Orders> getAllOrders() {
		myLogger.info("<<Get all orders service>>");
		return repo.findAll();
	}
	
	@Override
	public Orders addNewOrder(Orders order) {
		myLogger.info("<<Add new order service>>");
		return repo.save(order);
	}

	@Override
	public Orders getById(int orderId) {
		myLogger.info("<<Get By Id service>>");
		return repo.findById(orderId).get();
	}
	
	@Override
	public List<Orders> getOrdersByLocation(String location) throws OrderNotFoundException {
		myLogger.info("<<Get orders by location>>");
		List<Orders> orders = repo.getOrderByLocation(location);
		if(orders.size() == 0) {
			throw new OrderNotFoundException("Order with given location not found");
		}
		return orders;
	}

}
