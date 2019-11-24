package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.Order;
import com.cg.exception.OrderNotFoundException;
import com.cg.service.OrderService;

import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService service;
	
	@GetMapping(value = "/all", produces = "application/json")
	public List<Order> getAll(){
		return service.getAllOrders();
	}
	
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public Order addOrder(@RequestBody Order order) {
		return service.addNewOrder(order);
	}
	
	@GetMapping(value = "/id/{id}", produces = "application/json")
	public Order getById(@PathVariable("id") int id) {
		return service.getById(id);
	}
	
	@GetMapping(value = "/location/{location}", produces = "application/json")
	public List<Order> listByLocation(@PathVariable("location") String location) throws OrderNotFoundException{
		return service.getOrdersByLocation(location);
	}
}
