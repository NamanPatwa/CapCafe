package com.cg.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Orders;
import com.cg.exception.OrderNotFoundException;
import com.cg.service.OrderService;
import com.cg.service.OrderServiceImpl;

import javassist.tools.rmi.ObjectNotFoundException;

/**
 * Rest controller class for Orders Entity
 * @author Bhushan Sonawane
 *
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService service;
	
	static Logger myLogger =  Logger.getLogger(OrderServiceImpl.class);

	/**
	 * To list all the orders placed
	 * @return List of all orders
	 */
	@GetMapping(value = "/all", produces = "application/json")
	public List<Orders> getAll(){
		myLogger.info("================================================");
		myLogger.info("GET MAPPING to view all orders");
		return service.getAllOrders();
	}
	
	
	/**
	 * To add a new order
	 * @param order
	 * @return order which is placed
	 */
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public Orders addOrder(@RequestBody Orders order) {
		myLogger.info("================================================");
		myLogger.info("POST MAPPING to add orders");
		return service.addNewOrder(order);
	}
	
	/**
	 * To get order by ID
	 * @param id
	 * @return Order by ID
	 */
	@GetMapping(value = "/id/{id}", produces = "application/json")
	public Orders getById(@PathVariable("id") int id) {
		myLogger.info("================================================");
		myLogger.info("GET MAPPING to get by id");
		return service.getById(id);
	}
	
	
	/**
	 * List of orders by location
	 * @param location
	 * @return List of orders by location
	 * @throws OrderNotFoundException
	 */
	@GetMapping(value = "/location/{location}", produces = "application/json")
	public List<Orders> listByLocation(@PathVariable("location") String location) throws OrderNotFoundException{
		myLogger.info("================================================");
		myLogger.info("GET MAPPING to get list of orders by location");
		return service.getOrdersByLocation(location);
	}
}
