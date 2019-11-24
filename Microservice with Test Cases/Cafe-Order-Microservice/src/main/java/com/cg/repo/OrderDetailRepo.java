package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.dto.Order;
import com.cg.dto.OrderDetail;

/**
 * 
 * @author Team1
 * @version 1 Repository interface to persist data into ORDER_Detail table and
 *          having custom query Method
 */
public interface OrderDetailRepo extends JpaRepository<OrderDetail, Integer> {
	@Query("SELECT o FROM OrderDetail o WHERE o.order=:order")
	List<OrderDetail> fetchItemDetailsByOrderId(@Param("order") Order order);
}
