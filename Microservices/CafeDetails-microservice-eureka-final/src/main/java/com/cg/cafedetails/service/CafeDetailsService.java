package com.cg.cafedetails.service;

import java.util.List;

import com.cg.cafedetails.dto.CafeDetails;
import com.cg.cafedetails.dto.CafeMenu;
import com.cg.cafedetails.exception.CafeDetailsNotFoundException;

public interface CafeDetailsService {

	CafeDetails addCafeDetails(CafeDetails cafedetails);
	
	CafeDetails fetchCafeDetailsById(int cafeId) throws CafeDetailsNotFoundException;
	
	List<CafeDetails> fetchAllCafeDetails();
	
	boolean removeCafeDetails(int cafeId) throws CafeDetailsNotFoundException;
	
	CafeDetails updateCafeDetails(CafeDetails cafedetails);
	
	
	
	List<CafeDetails> fetchCafeDetailsByName(String name) throws CafeDetailsNotFoundException;
	
	List<CafeDetails> fetchCafeDetailsByLocation(String location) throws CafeDetailsNotFoundException;
	
	List<CafeDetails> fetchCafeDetailsByOwner(String owner) throws CafeDetailsNotFoundException;
	
	List<CafeDetails> fetchCafeDetailsByRating(double rating) throws CafeDetailsNotFoundException;
	
	List<CafeDetails> fetchCafeDetailsByRatingRange(double min, double max) throws CafeDetailsNotFoundException;
	
	List<CafeDetails> sortCafeDetailsByRating();
	
	List<String> fetchUniqueCafeLocation();
	
	int updateCafeName(String name, int id) throws CafeDetailsNotFoundException;
	
	
	
	CafeMenu addCafeMenu(CafeMenu cafemenu);
	
	CafeMenu fetchCafeMenuById(int itemId);
	
	List<CafeMenu> fetchAllCafeMenu();
	
	boolean removeCafeMenu(int itemId);
	
	CafeMenu updateCafeMenu(CafeMenu cafemenu);
}
