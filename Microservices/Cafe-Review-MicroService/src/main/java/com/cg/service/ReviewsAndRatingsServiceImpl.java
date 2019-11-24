package com.cg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.cg.dto.CafeDetails;
import com.cg.dto.CafeMenu;
import com.cg.dto.Employee;
import com.cg.dto.ReviewsAndRatings;
import com.cg.exception.CafeNotFound;
import com.cg.exception.FeedbackNotFound;
import com.cg.exception.InvalidRating;
import com.cg.exception.ItemNotFound;
import com.cg.exception.UserNotFound;
import com.cg.repo.ReviewsAndRatingsRepo;

@Service
@Transactional
public class ReviewsAndRatingsServiceImpl implements ReviewsAndRatingsService {
	@Autowired
	ReviewsAndRatingsRepo repo;
	
	@Autowired
	CafeMenuService menuService;
	
	@Autowired
	UserDetailService userService;
	
	
	@Autowired
	CafeDetailsService cafeService;

	@Override
	public ReviewsAndRatings giveReviewToItem(String userId, String itemName,String type,String review) {
			ReviewsAndRatings reviewsandratings=new ReviewsAndRatings();
		Employee user=userService.getById(userId);
		CafeMenu menu=menuService.getByItemName(itemName);
		
		reviewsandratings.setItem(menu);
		reviewsandratings.setUsers(user);
		reviewsandratings.setReview(review);
		reviewsandratings.setTypes(type);
		reviewsandratings=repo.save(reviewsandratings);
		
		return reviewsandratings;
		
	}

	@Override
	public ReviewsAndRatings giveRatingToItem(String userId, String itemName,String type, int rating){
		ReviewsAndRatings reviewsandratings=new ReviewsAndRatings();
		Employee user=userService.getById(userId);
		CafeMenu menu=menuService.getByItemName(itemName);
		
		reviewsandratings.setItem(menu);
		System.out.println(reviewsandratings.getItem());
		reviewsandratings.setUsers(user);
		reviewsandratings.setRating(rating);
		reviewsandratings.setTypes(type);
		reviewsandratings=repo.save(reviewsandratings);
		
		return reviewsandratings;
		
	}
	@Override
	public ReviewsAndRatings giveRatingToCafe(String userId, String cafeName,String type,int rating) {
		
			ReviewsAndRatings reviewsandratings=new ReviewsAndRatings();
		Employee user=userService.getById(userId);
		CafeDetails cafe=cafeService.getByCafeName(cafeName);
		
		cafe.setCafeRating(rating);
		reviewsandratings.setCafe(cafe);
		reviewsandratings.setUsers(user);
		reviewsandratings.setRating(rating);
		reviewsandratings.setTypes(type);
		reviewsandratings=repo.save(reviewsandratings);
		
		return reviewsandratings;
		
	}

	@Override
	public ReviewsAndRatings giveReviewToCafe(String userId, String cafeLocation, String type, String review)throws CafeNotFound,UserNotFound {
		ReviewsAndRatings reviewsandratings=new ReviewsAndRatings();	
		Employee user=userService.getById(userId);
		CafeDetails cafe=cafeService.getByCafeName(cafeLocation);
		
		reviewsandratings.setCafe(cafe);
		reviewsandratings.setUsers(user);
		reviewsandratings.setReview(review);
		reviewsandratings.setTypes(type);
		reviewsandratings=repo.save(reviewsandratings);
		
		return reviewsandratings;
	}

	@Override
	public boolean deleteFeedback(int ratingId)throws InvalidRating {
		try {
		repo.deleteById(ratingId);
		return true;
		}
		catch(Exception e) {
			throw new InvalidRating("No Review or Rating exists with provided Id");
		}
	}

	@Override
	public List<ReviewsAndRatings> fetchByItemName(String itemName)throws ItemNotFound {
		try {
		CafeMenu cafe;
		cafe=menuService.getByItemName(itemName);
		return repo.getByItemName(cafe);
		}
		catch(Exception e) {
			throw new ItemNotFound("No such item exists");
		}
	}

	@Override
	public List<ReviewsAndRatings> fetchall() throws FeedbackNotFound{
		try {
		return repo.findAll();
		}
		catch(Exception e) {
			throw new FeedbackNotFound("No Feedback exists at the moment");
		}
	}
	@Override
	public List<ReviewsAndRatings> fetchByCafeLocation(String cafeLocation) throws CafeNotFound{
		try{
			CafeDetails cafe;
		cafe=cafeService.getByCafeLocation(cafeLocation);
		return repo.getByCafeLocation(cafe);
		}
		catch(Exception e) {
			throw new CafeNotFound("No Cafe Exists at specified Location");
		}
	}

	@Override
	public double getItemAverageRating(int itemId) {
		
		CafeMenu menu;
		menu=menuService.getByItemId(itemId);
		return repo.getItemAverageRating(menu);
		}
		
	
	@Override
	public double getCafeAverageRating(int cafeId) {
		
			CafeDetails cafe;
		cafe=cafeService.getByCafeId(cafeId);
		return repo.getCafeAverageRating(cafe);
		
	}
	public List<String> getCafeReviews(String cafeLocation){
		
		CafeDetails cafe;
		cafe=cafeService.getByCafeLocation(cafeLocation);
		return repo.getCafeReviews(cafe);
		
	}

	@Override
	public List<String> getItemReviews(String itemName) {
		CafeDetails cafe;
		cafe=cafeService.getByCafeLocation(itemName);
		return repo.getCafeReviews(cafe);
	}

	@Override
	public List<ReviewsAndRatings> getCafeReviewsById(int cafeId) {
		CafeDetails cafe;
		cafe=cafeService.getByCafeId(cafeId);
		return repo.getCafeReviewsbyId(cafe);
	}

	@Override
	public List<ReviewsAndRatings> getItemReviewsById(int itemId) {
		CafeMenu menu;
		menu=menuService.getByItemId(itemId);
		return repo.getItemReviewsbyId(menu);
	}
}
