package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dtos.AddReviewDTO;
import com.app.dtos.ApiResponse;
import com.app.entities.Review;
import com.app.repositories.PackageRepository;
import com.app.repositories.ReviewRepository;
import com.app.repositories.UserRepository;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository revRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PackageRepository packRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public AddReviewDTO addReview(AddReviewDTO dto) {
		Review review = mapper.map(dto, Review.class);
		review.setUser(
				userRepo.findById(dto.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User Not Found")));
		review.setPakage(packRepo.findById(dto.getPackageId())
				.orElseThrow(() -> new ResourceNotFoundException("Package Not Found")));
		System.out.println(review.toString());
		return mapper.map(revRepo.save(review), AddReviewDTO.class);
	}

	@Override
	public AddReviewDTO getReview(Long reviewId) {
		return mapper.map(
				revRepo.findById(reviewId).orElseThrow(() -> new ResourceNotFoundException("Invalid Review ID")),
				AddReviewDTO.class);
	}

	@Override
	public List<AddReviewDTO> getReviewByUserId(Long id) {
		return revRepo
				.findAllByUser(userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid User")))
				.stream().map(review -> mapper.map(review, AddReviewDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<AddReviewDTO> getReviewByPackageId(Long id) {
		return revRepo
				.findAllByPakage(
						packRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Package")))
				.stream().map(review -> mapper.map(review, AddReviewDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<AddReviewDTO> getAllReviews() {
		return revRepo.findAll().stream().map(review -> mapper.map(review, AddReviewDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public AddReviewDTO updateReview(Long id, String review, int rating) {
		Review rev = revRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Id Provided"));
		rev.setRating(rating);
		rev.setReview(review);
		return mapper.map(review, AddReviewDTO.class);
	}

	@Override
	public ApiResponse deleteReview(Long id) {
		revRepo.delete(revRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Error Occured...")));
		return new ApiResponse("Review Deleted Successfully!");
	}

}
