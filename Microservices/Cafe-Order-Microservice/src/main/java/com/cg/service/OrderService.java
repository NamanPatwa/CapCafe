package com.cg.service;


import java.sql.Date;
import java.util.List;

import com.cg.dto.Order;
import com.cg.dto.OrderDetail;

public interface OrderService {
 int addOrder(Order order);
 Order fetchOrderById(int orderId);
 List<Order> fetchAllOrder();
 boolean removeCafeDetails(int orderId);
 Order updateOrderDetails(Order order);
 List<Order> fetchOrderDetailsByName(String name); 
 List<Order> fetchOrderByPriceRange(double min, double max);
 List<Order> fetchOrderByDate(Date date);
 List<Order> fetchOrderByEmployeeId(int id);
 //List<Order> fetchOrderByType(String type);
List<OrderDetail> fetchItemDetailsByOrderId(int id);
}
