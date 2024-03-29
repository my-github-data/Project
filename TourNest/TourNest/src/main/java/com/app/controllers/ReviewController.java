package com.app.controllers;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
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
@Validated
public class ReviewController {

	@Autowired
	private ReviewService revService;

	@PostMapping("/add")
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<?> addReview(@RequestBody @Valid AddReviewDTO dto) {
		System.out.println(dto.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(revService.addReview(dto));
	}

	@GetMapping("/get/{reviewId}")
	@PreAuthorize("hasRole('CLIENT', 'ADMIN')")
	public ResponseEntity<?> getReview(@PathVariable @NotNull Long reviewId) {
		return ResponseEntity.ok(revService.getReview(reviewId));
	}

	@GetMapping("/fetch/{userId}")
	@PreAuthorize("hasRole('CLIENT', 'ADMIN')")
	public ResponseEntity<?> getReviewByUserId(@PathVariable @NotNull Long userId) {
		return ResponseEntity.ok(revService.getReviewByUserId(userId));
	}

	@GetMapping("/show/{packageId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getReviewByPackageId(@PathVariable @NotNull Long packageId) {
		return ResponseEntity.ok(revService.getReviewByPackageId(packageId));
	}

	@GetMapping("/all")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAllReviews() {
		return ResponseEntity.ok(revService.getAllReviews());
	}

	@PutMapping("/update/{id}")
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<?> updateReview(@PathVariable @NotNull Long id, @RequestBody @Valid AddReviewDTO update) {
		return ResponseEntity.ok(revService.updateReview(id, update.getReview(), update.getRating()));
	}

	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<?> deleteReview(@PathVariable @NotNull Long id) {
		return ResponseEntity.ok(revService.deleteReview(id));
	}
}
