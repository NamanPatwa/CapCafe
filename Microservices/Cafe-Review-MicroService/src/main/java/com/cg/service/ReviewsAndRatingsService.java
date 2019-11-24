package com.cg.service;

import java.util.List;

import com.cg.dto.CafeMenu;
import com.cg.dto.ReviewsAndRatings;
import com.cg.exception.CafeNotFound;
import com.cg.exception.FeedbackNotFound;
import com.cg.exception.InvalidRating;
import com.cg.exception.ItemNotFound;
import com.cg.exception.UserNotFound;



public interface ReviewsAndRatingsService {
	ReviewsAndRatings giveReviewToItem(String userId,String itemName,String type,String review) ;
	ReviewsAndRatings giveRatingToItem(String userId, String itemName,String type,int rating);
	ReviewsAndRatings giveReviewToCafe(String userId,String cafeName,String type,String review) throws CafeNotFound,UserNotFound;
	ReviewsAndRatings giveRatingToCafe(String userId, String cafeName, String type,int rating);
	boolean deleteFeedback(int ratingId) throws InvalidRating;
	List<ReviewsAndRatings> fetchByItemName(String itemName) throws ItemNotFound;
	List<ReviewsAndRatings> fetchall() throws FeedbackNotFound;
	List<ReviewsAndRatings> fetchByCafeLocation(String cafeLocation) throws CafeNotFound;
	double getItemAverageRating(int itemId) ;
	double getCafeAverageRating(int cafeId) throws CafeNotFound;
	List<String> getCafeReviews(String cafeLocation);
	List<String> getItemReviews(String itemName);
	List<ReviewsAndRatings> getCafeReviewsById(int cafeId);
	List<ReviewsAndRatings> getItemReviewsById(int itemId);
	

}
