package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.dto.RequestResponse;


public interface RequestResponseRepo extends JpaRepository<RequestResponse, Integer> {
	
}
