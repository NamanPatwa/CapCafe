package com.cg.service;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.Order;
import com.cg.dto.OrderDetail;
import com.cg.repo.OrderDetailRepo;
import com.cg.repo.OrderRepo;
@Service
public class OrderServiceImpl implements OrderService {
@Autowired
OrderDetailRepo odrepo;
@Autowired
OrderRepo orepo;
	@Override
	public int addOrder(Order order) {
		for (OrderDetail details: order.getOrderDetails())
			details.setOrder(order);
		Order order1 =orepo.save(order);
		return order1.getOrderId();
	}
	@Override
	public Order fetchOrderById(int orderId) {
		return orepo.findById(orderId).get();
	}
	@Override
	public List<Order> fetchAllOrder() {
	return orepo.findAll();
	}
	
	@Override
	public boolean removeCafeDetails(int orderId) {
    orepo.deleteById(orderId);
    return true;
	}
	
	@Override
	public Order updateOrderDetails(Order order) {
	return orepo.save(order);
	}
	
	@Override
	public List<Order> fetchOrderDetailsByName(String name) {
		return orepo.fetchOrderDetailsByName(name);
	}
	@Override
	public List<Order> fetchOrderByPriceRange(double min, double max) {
		return orepo.fetchOrderDetailsByPriceRange(min, max);
	}
	@Override
	public List<Order> fetchOrderByDate(Date date) {
		return orepo.fetchOrderDetailsByDate(date);
	}
	@Override
	public List<OrderDetail> fetchItemDetailsByOrderId(int id) {
		return odrepo.fetchItemDetailsByOrderId(orepo.findById(id).get());
	}
	@Override
	public List<Order> fetchOrderByEmployeeId(int id) {
		return orepo.fetchOrderByEmployeeId(id);
	}
	
//	@Override
//	public List<Order> fetchOrderByType(String type) {
//		// TODO Auto-generated method stub
//		return orepo.fetchOrderDetailsByType(type);
//	}
	

}
