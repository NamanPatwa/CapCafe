package com.cg.service;
import java.sql.Date;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.CafeOrderMicroserviceApplication;
import com.cg.dto.Order;
import com.cg.dto.OrderDetail;
import com.cg.exception.OrderCanNotBeSavedException;
import com.cg.exception.OrderNotFoundException;
import com.cg.repo.OrderDetailRepo;
import com.cg.repo.OrderRepo;
/**
 * 
 * @author Team1
 * @version 1
 * Service interface Implementation having logic to provide different type of service 
 * related to order
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
@Autowired
OrderDetailRepo odrepo;
@Autowired
OrderRepo orepo;
Logger myLogger =  Logger.getLogger(OrderServiceImpl.class);
	@Override
	public int addOrder(Order order)throws OrderCanNotBeSavedException{
		try {
			myLogger.info("Enterd into AddOrder Method of ServiceImplClass");
			for (OrderDetail details: order.getOrderDetails())
				details.setOrder(order);
			Order order1 =orepo.save(order);
			myLogger.info("save method of Repo executed Successfully ");
			return order1.getOrderId();
		} catch (Exception e) {
			myLogger.info("Exception Occoured during saving Order");
			throw new OrderCanNotBeSavedException("Hey You have Entered Wrong input Please Enter again");
		}
	}
	@Override
	public Order fetchOrderById(int orderId) throws OrderNotFoundException {
		myLogger.info("Enterd into fetchOrderById Method of ServiceImplClass");
		Optional<Order> order =  orepo.findById(orderId);
		myLogger.info("findById method of Repo executed Successfully ");
		if(!order.isPresent()) {
			myLogger.info("Exception Occoured during fetching  Order by Order Id");
			throw new OrderNotFoundException("No Order With Given ID. "+orderId);
		}
		return order.get();
	}
	@Override
	public List<Order> fetchAllOrder()throws OrderNotFoundException {
		myLogger.info("Enterd into AllOrder Method of ServiceImplClass");
		List<Order> order=orepo.findAll();
		myLogger.info("findAll method of Repo executed Successfully ");
		if(order.size()==0) {
			myLogger.info("Exception Occoured during Fetching all order");
			throw new OrderNotFoundException("No Order Is Present Till Now ");
		}
		return order;
	}
	
	@Override
	public Order updateOrderDetails(Order order) {
		myLogger.info("Enterd into updateOrder Method of ServiceImplClass");
	return orepo.save(order);
	}
	
	@Override
	public List<Order> fetchOrderDetailsByName(String name) throws OrderNotFoundException{
		myLogger.info("Enterd into fetchOrderDetailsByName Method of ServiceImplClass");
		List<Order> order= orepo.fetchOrderDetailsByName(name);
		myLogger.info("fetchOrderDetailsByName method of Repo executed Successfully ");
		if(order.size()==0) {
			myLogger.info("Exception Occoured during fetching order by Employee name");
			throw new OrderNotFoundException("No Order Present between "+name);
		}
		return order;
	}
	@Override
	public List<Order> fetchOrderByPriceRange(double min, double max)throws OrderNotFoundException {
		myLogger.info("Enterd into fetch Order details By price range Method of ServiceImplClass");
		List<Order> order= orepo.fetchOrderDetailsByPriceRange(min, max);
		myLogger.info("fetchOrderDetailsByPriceRange method of Repo executed Successfully ");
		if(order.size()==0) {
			myLogger.info("Exception Occoured during Fetching Order By price Range");
			throw new OrderNotFoundException("No Order Present between "+min+" "+max);
		}
		return order;
	}
	@Override
	public List<Order> fetchOrderByDate(Date date)throws OrderNotFoundException {
		myLogger.info("Enterd into FetchOrder By Date Method of ServiceImplClass");
		List<Order> order= orepo.fetchOrderDetailsByDate(date);
		myLogger.info("fetchOrderDetailsBydate method of Repo executed Successfully ");
		if(order.size()==0) {
			myLogger.info("Exception Occoured during Fetching Order By dates");
			throw new OrderNotFoundException("No Order for "+date);
		}
		return order;
	}
	@Override
	public List<OrderDetail> fetchItemDetailsByOrderId(int id)throws OrderNotFoundException {
		Optional<Order> order = orepo.findById(id);
		myLogger.info("findById method of Repo executed Successfully ");
		if(!order.isPresent()) {
			myLogger.info("Exception Occoured during Fectching Order by Order id");
			throw new OrderNotFoundException("No Order With Given ID. "+id);
			}
		List<OrderDetail> order2= odrepo.fetchItemDetailsByOrderId(order.get());
		myLogger.info("fetchOrderDetailsByOrderId method of Repo executed Successfully ");
		if(order2.size()==0) {
			myLogger.info("Exception Occoured during Fetching order detail by order id");
			throw new OrderNotFoundException("No Item Present With Given ID "+id);
		}
		return order2;
	}
	@Override
	public List<Order> fetchOrderByEmployeeId(int id)throws OrderNotFoundException {
		myLogger.info("Enterd into fetchOrderByEmployeeId Method of ServiceImplClass");
		List<Order> order= orepo.fetchOrderByEmployeeId(id);
		myLogger.info("fetchOrderByEmployeeId method of Repo executed Successfully ");
		if(order.size()==0) {
			myLogger.info("Exception Occoured during fetching Order by Employee Id");
			throw new OrderNotFoundException("No Order For Employee With id "+id);
		}
		return order;
	}
	
	
}
