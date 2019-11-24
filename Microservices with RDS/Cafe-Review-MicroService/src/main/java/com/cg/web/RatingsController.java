package com.cg.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.CafeMenu;
import com.cg.dto.ReviewsAndRatings;
import com.cg.exception.CafeNotFound;
import com.cg.exception.FeedbackNotFound;
import com.cg.exception.InvalidRating;
import com.cg.exception.ItemNotFound;
import com.cg.exception.UserNotFound;
import com.cg.service.ReviewsAndRatingsService;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/feedback")
public class RatingsController {
@Autowired
private ReviewsAndRatingsService service;
@PostMapping(value = "/addItemReview/{userId}/{itemName}/{type}/{review}", produces = "application/json")
public ReviewsAndRatings giveReviewToItem(@PathVariable("userId") String userId,@PathVariable("itemName") String itemName,@PathVariable("type") String type,@PathVariable("review") String review) throws ItemNotFound, UserNotFound {
	return service.giveReviewToItem(userId, itemName, type, review);
}
@PostMapping(value = "/addItemRating/{userId}/{itemName}/{type}/{rating}", produces = "application/json")
public ReviewsAndRatings giveRatingToItem(@PathVariable("userId") String userId,@PathVariable("itemName") String itemName ,@PathVariable("type") String type,@PathVariable("rating") int rating) throws ItemNotFound, UserNotFound {
	return service.giveRatingToItem(userId, itemName, type, rating);
}
@PostMapping(value = "/addCafeRating/{userId}/{cafeName}/{type}/{rating}", produces = "application/json")
public ReviewsAndRatings giveRatingToCafe(@PathVariable("userId") String userId,@PathVariable("cafeName") String cafeName,@PathVariable("type") String type,@PathVariable("rating") int rating) throws CafeNotFound, UserNotFound {
	return service.giveRatingToCafe(userId, cafeName, type, rating);
}
@PostMapping(value = "/addCafeReview/{userId}/{cafeName}/{type}/{review}", produces = "application/json")
public ReviewsAndRatings giveReviewToCafe(@PathVariable("userId") String userId,@PathVariable("cafeName") String cafeName,@PathVariable("type") String type,@PathVariable("review") String review) throws CafeNotFound, UserNotFound {
	return service.giveReviewToCafe(userId, cafeName, type, review);
}
@DeleteMapping(value = "/deleteFeedback/{ratingId}", produces = "application/json")
public boolean deleteFeedback(@PathVariable("ratingId") int ratingId) throws InvalidRating {
	return service.deleteFeedback(ratingId);
}
@GetMapping(value = "/getAll",produces = "application/json")
public List<ReviewsAndRatings> fetchAll() throws FeedbackNotFound {
	return service.fetchall();
}
@GetMapping(value = "/getFeedbackByItemName/{itemName}",produces = "application/json")
 public List<ReviewsAndRatings> fetchByItemName(@PathVariable  String itemName) throws ItemNotFound {
	return service.fetchByItemName(itemName);
}	
@GetMapping(value="/getFeedbackByCafeLocation/{cafeLocation}",produces="application/json")
public List<ReviewsAndRatings> fetchByCafeLocation(@PathVariable String cafeLocation) throws CafeNotFound{
	return service.fetchByCafeLocation(cafeLocation);
}
@GetMapping(value="/getItemAverageRating/{itemId}",produces="application/json")
public double fetchItemAverageRating(@PathVariable int itemId) throws ItemNotFound{
	return service.getItemAverageRating(itemId);
}
@GetMapping(value="/getCafeAverageRating/{cafeId}",produces="application/json")
public double fetechCafeAverageRating(@PathVariable int cafeId) throws CafeNotFound {
	return service.getCafeAverageRating(cafeId);
}




@GetMapping(value="/getReviewByCafeLocation/{cafeLocation}",produces="application/json")
public List<String> fetchCafeReviews(@PathVariable String cafeLocation) {
	return service.getCafeReviews(cafeLocation);
}
@GetMapping(value="/getReviewByItemName/{itemName}",produces="application/json")
public List<String> fetchItemReviews(@PathVariable String itemName) {
	return service.getItemReviews(itemName);
}

@GetMapping(value="/getReviewByCafeId/{cafeId}",produces="application/json")
public List<ReviewsAndRatings> fetchCafeReviewsById(@PathVariable int cafeId) {
	return service.getCafeReviewsById(cafeId);
}
@GetMapping(value="/getReviewByItemId/{itemId}",produces="application/json")
public List<ReviewsAndRatings> fetchItemReviewsById(@PathVariable int itemId) {
	return service.getItemReviewsById(itemId);
}
}


