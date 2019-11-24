package com.cg.web;

import java.sql.Date;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.cg.exception.OrderCanNotBeSavedException;
import com.cg.exception.OrderNotFoundException;
import com.cg.service.OrderService;
import com.cg.service.OrderServiceImpl;

/**
 * 
 * @author Team1
 * @version 1s Controller class to consume and produce the Data
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService service;
	Logger myLogger = Logger.getLogger(OrderServiceImpl.class);

	/**
	 * 
	 * @param order Which is to be saved
	 * @return Order Id by which order is saved
	 * @throws OrderCanNotBeSavedException
	 */
	@PostMapping(value = "add", consumes = "application/json", produces = "application/json")
	public int addItems(@RequestBody Order order) throws OrderCanNotBeSavedException {
		myLogger.info("Data Passed to addItems methods of controller is successfulyy consumed");
		return service.addOrder(order);
	}

	/**
	 * 
	 * @param id Order Id For which order is to be fetched
	 * @return Order
	 * @throws OrderNotFoundException
	 */
	@GetMapping(value = "/{id}", produces = "application/json")
	public Order fetchOrderById(@PathVariable int id) throws OrderNotFoundException {
		myLogger.info("Data Passed to fetchOrderById methods of controller is successfulyy consumed");
		return service.fetchOrderById(id);
	}

	/**
	 * 
	 * @return list of order
	 * @throws OrderNotFoundException
	 */
	@GetMapping(value = "AllOrders", produces = "application/json")
	public List<Order> fetchAllOrder() throws OrderNotFoundException {
		myLogger.info("Data Passed to fetchAllOrder methods of controller is successfulyy consumed");
		return service.fetchAllOrder();
	}

	/**
	 * 
	 * @param name For Which Order Is to be fetched
	 * @return list of Order
	 * @throws OrderNotFoundException
	 */
	@GetMapping(value = "/byName/{name}", produces = "application/json")
	public List<Order> fetchAllOrderDetailsByName(@PathVariable String name) throws OrderNotFoundException {
		myLogger.info("Data Passed to fetchAllOrderDetailsByName methods of controller is successfulyy consumed");
		return service.fetchOrderDetailsByName(name);
	}

	/**
	 * 
	 * @param id Employee Id for which order is to be fetched
	 * @return list of order
	 * @throws OrderNotFoundException
	 */
	@GetMapping(value = "/byid/{id}", produces = "application/json")
	public List<Order> fetchOrderByEmployeeId(@PathVariable("id") int id) throws OrderNotFoundException {
		myLogger.info("Data Passed to fetchOrderByEmployeeId methods of controller is successfulyy consumed");
		return service.fetchOrderByEmployeeId(id);
	}

	/**
	 * 
	 * @param order Order which is to be updated
	 * @return Order
	 */
	@PutMapping(value = "update", consumes = "application/json", produces = "application/json")
	public Order updateOrderDetails(@RequestBody Order order) {
		myLogger.info("Data Passed to updateOrderDetails methos of controller is successfulyy consumed");
		return service.updateOrderDetails(order);
	}

	/**
	 * 
	 * @param min Minimum amount above which Order is to be fetched
	 * @param max Maximum amount above which Order is to be fetched
	 * @return List Of Order
	 * @throws OrderNotFoundException
	 */
	@GetMapping(value = "/byRatingRange/{min}/{max}", produces = "application/json")
	public List<Order> fetchAllOrderDetailsByPriceRange(@PathVariable double min, @PathVariable double max)
			throws OrderNotFoundException {
		myLogger.info("Data Passed to fetchAllOrderDetailByPricerange methos of controller is successfulyy consumed");
		return service.fetchOrderByPriceRange(min, max);
	}

	/**
	 * 
	 * @param date For which order to be fetched
	 * @return list of Order
	 * @throws OrderNotFoundException
	 */
	@GetMapping(value = "/Date/{date}", produces = "application/json")
	public List<Order> fetchOrderByDate(@RequestParam Date date) throws OrderNotFoundException {
		myLogger.info("Data Passed to fetchOrderBydate methos of controller is successfulyy consumed");
		return service.fetchOrderByDate(date);
	}

	/**
	 * 
	 * @param id Order Id for which item details to be fetched
	 * @return List of order details
	 * @throws OrderNotFoundException
	 */
	@GetMapping(value = "/item/{id}", produces = "application/json")
	public List<OrderDetail> fetchOrderDetailByOrderId(@PathVariable("id") int id) throws OrderNotFoundException {
		myLogger.info("Data Passed to fetchOrderDetailByOrderId methos of controller is successfulyy consumed");
		return service.fetchItemDetailsByOrderId(id);
	}
}
