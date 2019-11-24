package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.dto.CafeDetails;

public interface CafeDetailsRepo extends JpaRepository<CafeDetails, Integer>{
	@Query("SELECT c FROM CafeDetails c WHERE c.cafeLocation = :cafeLocation")
	CafeDetails getByCafeLocation(@Param("cafeLocation") String cafeLocation);
@Query("SELECT c FROM CafeDetails c WHERE c.cafeId = :cafeId")
	
	CafeDetails getByCafeId(@Param("cafeId") int cafeId);
@Query("SELECT c FROM CafeDetails c WHERE c.cafeName = :cafeName")

CafeDetails getByCafeName(String cafeName);
}
