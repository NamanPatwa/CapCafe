package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.dto.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {
	
	@Query("SELECT o FROM Order o WHERE o.location = :location")
	public List<Order> getOrderByLocation(@Param("location") String location);

}
