package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.entity.Orders;

public interface OrderRepo extends JpaRepository<Orders, Integer> {
	
	@Query("SELECT o FROM Orders o WHERE o.location = :location")
	public List<Orders> getOrderByLocation(@Param("location") String location);

}
