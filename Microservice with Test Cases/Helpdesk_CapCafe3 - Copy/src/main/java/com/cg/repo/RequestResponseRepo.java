package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.RequestResponse;

public interface RequestResponseRepo extends JpaRepository<RequestResponse, Integer> {
	
}
