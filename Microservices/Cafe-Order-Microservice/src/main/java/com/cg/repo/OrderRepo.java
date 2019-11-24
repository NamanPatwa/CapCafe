package com.cg.repo;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.dto.Order;



public interface OrderRepo extends JpaRepository<Order, Integer> {

	@Query("SELECT o FROM Order o WHERE o.employeeName=:name")
	List<Order> fetchOrderDetailsByName(String name);
	
	@Query("SELECT o FROM Order o WHERE o.totalAmount BETWEEN :min AND :max")
	List<Order> fetchOrderDetailsByPriceRange(double min, double max);
	
	@Query("SELECT o FROM Order o where o.orderDate=:date")
	List<Order> fetchOrderDetailsByDate(Date date);
	
	@Query("SELECT o FROM Order o where o.employeeId=:id")
	List<Order> fetchOrderByEmployeeId(int id);
	
	

}
