package com.app.services;

import java.util.List;

import com.app.dtos.AddReviewDTO;
import com.app.dtos.ApiResponse;

public interface ReviewService {
	
	AddReviewDTO addReview(AddReviewDTO dto);
	
	AddReviewDTO getReview(Long reviewId);
	
	List<AddReviewDTO> getReviewByUserId(Long id);
	
	List<AddReviewDTO> getReviewByPackageId(Long id);
	
	List<AddReviewDTO> getAllReviews();
	
	AddReviewDTO updateReview(Long id, String review, int rating);
	
	ApiResponse deleteReview(Long id);

}
