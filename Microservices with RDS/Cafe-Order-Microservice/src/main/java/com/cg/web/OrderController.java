package com.cg.web;


import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.Order;
import com.cg.dto.OrderDetail;
import com.cg.service.OrderService;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService service;
	
	@PostMapping(value = "add", consumes = "application/json", produces = "application/json")
	public int addItems(@RequestBody Order order) {
		return service.addOrder(order);
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public Order fetchOrderById(@PathVariable int id)  {
		return service.fetchOrderById(id);
	}
	
	@GetMapping(value = "AllOrders", produces = "application/json")
	public List<Order> fetchAllOrder() {
		return service.fetchAllOrder();
	}
	
	@DeleteMapping(value = "remove", produces = "application/json")
	public boolean removeOrder(@RequestParam int id) {
		return service.removeCafeDetails(id);
	}
	
	@GetMapping(value = "/byName/{name}", produces = "application/json")
	public List<Order> fetchAllCafeDetailsByName(@PathVariable String name){
		return service.fetchOrderDetailsByName(name);
	}
	@GetMapping(value = "/byid/{id}", produces = "application/json")
	public List<Order> fetchOrderByEmployeeId(@PathVariable("id") int id){
		return service.fetchOrderByEmployeeId(id);
	}
	@PutMapping(value = "update", consumes = "application/json", produces = "application/json")
	public Order updateCafeDetails(@RequestBody Order order) {
		return service.updateOrderDetails(order);
	}
	@GetMapping(value = "/byRatingRange/{min}/{max}", produces = "application/json")
	public List<Order> fetchAllCafeDetailsByRatingRange(@PathVariable double min, @PathVariable double max){
		return service.fetchOrderByPriceRange(min, max);
	}
	@GetMapping(value = "/Date/{date}", produces = "application/json")
	public List<Order> fetchOrderByDate(@RequestParam Date date) {
		return service.fetchOrderByDate(date);
	}
	@GetMapping(value = "/item/{id}", produces = "application/json")
	public List<OrderDetail>  fetchOrderDetailByOrderId(@PathVariable("id") int id)  {
		return service.fetchItemDetailsByOrderId(id);
	}
	
	

}
