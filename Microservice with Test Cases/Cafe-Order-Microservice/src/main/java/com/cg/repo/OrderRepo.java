package com.cg.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.dto.Order;

/**
 * 
 * @author Team1
 * @version 1 Repository interface to persist data into ORDERS table and having
 *          custom query Method
 */

public interface OrderRepo extends JpaRepository<Order, Integer> {
	/**
	 * 
	 * @param name
	 * @return
	 */
	@Query("SELECT o FROM Order o WHERE o.employeeName=:name")
	List<Order> fetchOrderDetailsByName(String name);

	/**
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	@Query("SELECT o FROM Order o WHERE o.totalAmount BETWEEN :min AND :max")
	List<Order> fetchOrderDetailsByPriceRange(double min, double max);

	/**
	 * 
	 * @param date
	 * @return
	 */
	@Query("SELECT o FROM Order o where o.orderDate=:date")
	List<Order> fetchOrderDetailsByDate(Date date);

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Query("SELECT o FROM Order o where o.employeeId=:id")
	List<Order> fetchOrderByEmployeeId(int id);

}
