package com.cg.cafedetails.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.cafedetails.dto.CafeDetails;
import com.cg.cafedetails.dto.CafeMenu;

public interface CafeDetailsRepo extends JpaRepository<CafeDetails, Integer>{

	@Query("SELECT c FROM CafeDetails c WHERE c.cafeName=:name")
	List<CafeDetails> fetchAllCafeDetailsByName(String name);
	
	@Query("SELECT c FROM CafeDetails c WHERE c.cafeLocation=:location")
	List<CafeDetails> fetchCafeDetailsByLocation(String location);
	
	@Query("SELECT c FROM CafeDetails c WHERE c.cafeOwner=:owner")
	List<CafeDetails> fetchAllCafeDetailsByOwner(String owner);
	
	@Query("SELECT c FROM CafeDetails c WHERE c.cafeRating=:rating")
	List<CafeDetails> fetchAllCafeDetailsByRating(double rating);
	
	@Query("SELECT c FROM CafeDetails c WHERE c.cafeRating BETWEEN :min AND :max")
	List<CafeDetails> fetchCafeDetailsByRatingRange(double min, double max);
	
	@Query("SELECT c FROM CafeDetails c ORDER BY c.cafeRating DESC")
	List<CafeDetails> sortCafeDetailsByRating();
	
	@Query("SELECT DISTINCT c.cafeLocation FROM CafeDetails c")
	List<String> fetchUniqueCafeLocation();
	
	
//	
//	@Query("SELECT menus FROM CafeDetails c WHERE c.menus=:cafe")
//	List<CafeDetails> fetchAllMenuByCafeName(CafeMenu cafe);
//	
	
	
	@Modifying
	@Query("UPDATE CafeDetails c SET c.cafeName=:name WHERE c.cafeId=:id")
	int updateCafeName(String name, int id);
}
