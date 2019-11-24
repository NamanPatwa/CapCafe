package com.cg.service;


import java.sql.Date;
import java.util.List;

import com.cg.dto.Order;
import com.cg.dto.OrderDetail;
import com.cg.exception.OrderCanNotBeSavedException;
import com.cg.exception.OrderNotFoundException;
/**
 * 
 * @author Team 1
 * @version 1
 * Service Interface for Different type of service related to order
 */
public interface OrderService {
	/**
	 * 
	 * @param order Which is to be saved
	 * @return Order Id by which order is saved
	 * @throws OrderCanNotBeSavedException
	 */
 int addOrder(Order order)throws OrderCanNotBeSavedException;
 /**
	 * 
	 * @param id Order Id For which order is to be fetched
	 * @return Order
	 * @throws OrderNotFoundException
	 */
 Order fetchOrderById(int orderId) throws OrderNotFoundException;
 /**
	 * 
	 * @return list of Order
	 * @throws OrderNotFoundException
	 */

 List<Order> fetchAllOrder()throws OrderNotFoundException;
 /**
	 * 
	 * @param order Order which is to be updated
	 * @return Order
	 */
 Order updateOrderDetails(Order order);
 /**
	 * 
	 * @param name For Which Order Is to be fetched 
	 * @return list of Order
	 * @throws OrderNotFoundException
	 */
 List<Order> fetchOrderDetailsByName(String name)throws OrderNotFoundException; 
 /**
	 * 
	 * @param min Minimum ammount above which Order is to be fetched
	 * @param max Maximum ammount above which Order is to be fetched
	 * @return List Of Order
	 * @throws OrderNotFoundException
	 */
 List<Order> fetchOrderByPriceRange(double min, double max)throws OrderNotFoundException;
 /**
	 * 
	 * @param date For which order to be fetched
	 * @return list of Order
	 * @throws OrderNotFoundException
	 */
 List<Order> fetchOrderByDate(Date date)throws OrderNotFoundException;
 /**
	 * 
	 * @param id Employee Id for which order is to be fetched
	 * @return list of order
	 * @throws OrderNotFoundException
	 */
 List<Order> fetchOrderByEmployeeId(int id)throws OrderNotFoundException;
 /**
	 * 
	 * @param id Order Id for which item details to be fetched
	 * @return List of order details
	 * @throws OrderNotFoundException
	 */
 List<OrderDetail> fetchItemDetailsByOrderId(int id)throws OrderNotFoundException;
}
