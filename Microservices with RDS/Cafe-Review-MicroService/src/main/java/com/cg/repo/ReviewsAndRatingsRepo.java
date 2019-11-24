package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.dto.CafeDetails;
import com.cg.dto.CafeMenu;
import com.cg.dto.ReviewsAndRatings;


public interface ReviewsAndRatingsRepo extends JpaRepository<ReviewsAndRatings, Integer>{
@Query("SELECT r FROM ReviewsAndRatings r WHERE r.item=item")
List<ReviewsAndRatings> getByItemName(@Param("item")CafeMenu item);
@Query("SELECT r FROM ReviewsAndRatings r WHERE r.cafe=cafe")
List<ReviewsAndRatings> getByCafeLocation(@Param("cafe")CafeDetails cafe);
@Query("SELECT AVG(r.rating) FROM ReviewsAndRatings r where r.item=:item")
double getItemAverageRating(@Param("item")CafeMenu item);
@Query("SELECT AVG(r.rating) FROM ReviewsAndRatings r where r.cafe=:cafe")
double getCafeAverageRating(@Param("cafe")CafeDetails item);
@Query("SELECT r.review FROM ReviewsAndRatings r where r.cafe=:cafe")
List<String> getCafeReviews(@Param("cafe")CafeDetails cafe);
@Query("SELECT r.review FROM ReviewsAndRatings r where r.item=:item")
List<String> getItemReviews(@Param("item")CafeMenu item);
@Query("SELECT r FROM ReviewsAndRatings r WHERE r.cafe=cafe")
List<ReviewsAndRatings> getCafeReviewsbyId(CafeDetails cafe);
@Query("SELECT r FROM ReviewsAndRatings r WHERE r.item=item")
List<ReviewsAndRatings> getItemReviewsbyId(CafeMenu menu);
}
