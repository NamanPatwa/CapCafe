package com.cg.cafedetails.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.cafedetails.dto.CafeDetails;
import com.cg.cafedetails.dto.CafeMenu;
import com.cg.cafedetails.exception.CafeDetailsNotFoundException;
import com.cg.cafedetails.repo.CafeDetailsRepo;
import com.cg.cafedetails.repo.CafeMenuRepo;

@Service
@Transactional(rollbackFor = CafeDetailsNotFoundException.class)
public class CafeDetailsServiceImpl implements CafeDetailsService {

	static Logger myLogger =  Logger.getLogger(CafeDetailsServiceImpl.class);

	
	@Autowired
	private CafeDetailsRepo cafeDetailsRepo;
	
	@Autowired
	private CafeMenuRepo cafeMenuRepo;
	
	
	@Override
	public CafeDetails addCafeDetails(CafeDetails cafedetails) {
		myLogger.info("<<CafeDetails Service>>");
		myLogger.info("Adding a new Cafe");
		return cafeDetailsRepo.save(cafedetails);
	}

	@Override
	public CafeDetails fetchCafeDetailsById(int cafeId) throws CafeDetailsNotFoundException {
		myLogger.info("<<CafeDetails Service>>");	
		try {
			myLogger.info("Fetching a Cafe by id");
			return cafeDetailsRepo.findById(cafeId).get();
		} catch (Exception e) {
			myLogger.error("No cafe details are available for cafeId: " + cafeId);
			throw new CafeDetailsNotFoundException("No cafe details are available for cafeId: " + cafeId);
		}
	}

	@Override
	public List<CafeDetails> fetchAllCafeDetails() {
		myLogger.info("<<CafeDetails Service>>");
		myLogger.info("Fetching all cafe details");
		return cafeDetailsRepo.findAll();
	}

	@Override
	public boolean removeCafeDetails(int cafeId) throws CafeDetailsNotFoundException {
		myLogger.info("<<CafeDetails Service>>");
		myLogger.info("Removing a Cafe by cafe id");
		try {
			cafeDetailsRepo.deleteById(cafeId);
			return true;
		} catch (Exception e) {
			myLogger.error("Invalid Cafe Id proivded: " + cafeId);
			throw new CafeDetailsNotFoundException("Invalid Cafe Id provided: " + cafeId);
		}
	}

	@Override
	public CafeDetails updateCafeDetails(CafeDetails cafedetails) {
		myLogger.info("<<CafeDetails Service>>");
		myLogger.info("Updating a Cafedetails");
		return cafeDetailsRepo.save(cafedetails);
	}

	@Override
	public CafeMenu fetchCafeMenuById(int itemId) {
		return cafeMenuRepo.findById(itemId).get();
	}

	@Override
	public List<CafeMenu> fetchAllCafeMenu() {
		return cafeMenuRepo.findAll();
	}

	
	
	
	@Override
	public List<CafeDetails> fetchCafeDetailsByName(String name) throws CafeDetailsNotFoundException {
			if(cafeDetailsRepo.fetchAllCafeDetailsByName(name).size()==0)
				throw new CafeDetailsNotFoundException("No Cafe found for this Name: " + name);
			return cafeDetailsRepo.fetchAllCafeDetailsByName(name);
	}

	@Override
	public List<CafeDetails> fetchCafeDetailsByLocation(String location) throws CafeDetailsNotFoundException {
		myLogger.info("<<CafeDetails Service>>");		
			if(cafeDetailsRepo.fetchCafeDetailsByLocation(location)==null || cafeDetailsRepo.fetchCafeDetailsByLocation(location).size()==0) {
				myLogger.error("No Cafe found for this Location: " + location);
				throw new CafeDetailsNotFoundException("No Cafe found for this Location: " + location);
			}
			myLogger.info("Fetching a Cafe by location");
				return cafeDetailsRepo.fetchCafeDetailsByLocation(location);
	}

	@Override
	public List<CafeDetails> fetchCafeDetailsByOwner(String owner) throws CafeDetailsNotFoundException {
	
			if(cafeDetailsRepo.fetchAllCafeDetailsByOwner(owner).size()==0)
				throw new CafeDetailsNotFoundException("No Cafe found for this Owner: " + owner);
			return cafeDetailsRepo.fetchAllCafeDetailsByOwner(owner);
	}

	@Override
	public List<CafeDetails> fetchCafeDetailsByRating(double rating) throws CafeDetailsNotFoundException {
		
			if(cafeDetailsRepo.fetchAllCafeDetailsByRating(rating).size()==0)
				throw new CafeDetailsNotFoundException("No Cafe found for this Rating: " + rating);
			return cafeDetailsRepo.fetchAllCafeDetailsByRating(rating);
	}

	@Override
	public List<CafeDetails> fetchCafeDetailsByRatingRange(double min, double max) throws CafeDetailsNotFoundException {
		
			if(cafeDetailsRepo.fetchCafeDetailsByRatingRange(min, max).size()==0)
				throw new CafeDetailsNotFoundException("No Cafe found for this Range.");
			return cafeDetailsRepo.fetchCafeDetailsByRatingRange(min, max);
	}

	@Override
	public List<CafeDetails> sortCafeDetailsByRating() {
		return cafeDetailsRepo.sortCafeDetailsByRating();
	}
	
	@Override
	public List<String> fetchUniqueCafeLocation() {
		myLogger.info("<<CafeDetails Service>>");		
		myLogger.info("Fetching all unique cafe location");		
		return cafeDetailsRepo.fetchUniqueCafeLocation();
	}

	@Override
	public int updateCafeName(String name, int id) throws CafeDetailsNotFoundException {
		int updateStatus = cafeDetailsRepo.updateCafeName(name, id);
		if(updateStatus == 0)
			throw new CafeDetailsNotFoundException("Invalid Cafe Details are provided.");
		return 1;
	}

	

}
