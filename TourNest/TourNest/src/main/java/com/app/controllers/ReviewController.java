package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.AddReviewDTO;
import com.app.services.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewService revService;

	@PostMapping("/add")
	public ResponseEntity<?> addReview(@RequestBody AddReviewDTO dto) {
		System.out.println(dto.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(revService.addReview(dto));
	}

	@GetMapping("/get/{reviewId}")
	public ResponseEntity<?> getReview(@PathVariable Long reviewId) {
		return ResponseEntity.ok(revService.getReview(reviewId));
	}

	@GetMapping("/fetch/{userId}")
	public ResponseEntity<?> getReviewByUserId(@PathVariable Long userId) {
		return ResponseEntity.ok(revService.getReviewByUserId(userId));
	}

	@GetMapping("/show/{packageId}")
	public ResponseEntity<?> getReviewByPackageId(@PathVariable Long packageId) {
		return ResponseEntity.ok(revService.getReviewByPackageId(packageId));
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllReviews() {
		return ResponseEntity.ok(revService.getAllReviews());
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateReview(@PathVariable Long id, @RequestBody AddReviewDTO update) {
		return ResponseEntity.ok(revService.updateReview(id, update.getReview(), update.getRating()));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteReview(@PathVariable Long id) {
		return ResponseEntity.ok(revService.deleteReview(id));
	}
}
