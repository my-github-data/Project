package com.app.controllers;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.AddFeedbackDTO;
import com.app.services.FeedbackService;

@RestController
@RequestMapping("/feedback")
@Validated
public class FeedbackController {

	@Autowired
	private FeedbackService feedService;

	@PostMapping("/add")
	public ResponseEntity<?> addReview(@RequestBody @Valid AddFeedbackDTO dto) {
		System.out.println(dto.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(feedService.addFeedback(dto));
	}

	@GetMapping("/get/{feedbackId}")
	public ResponseEntity<?> getFeedback(
			@PathVariable @NotNull(message = "Feedback id Cannot be Null") Long feedbackId) {
		return ResponseEntity.ok(feedService.getFeedback(feedbackId));
	}

	@GetMapping("/fetch/{userId}")
	public ResponseEntity<?> getFeedbackByUserId(
			@PathVariable @NotNull(message = "User id Cannot be Null") Long userId) {
		return ResponseEntity.ok(feedService.getFeedbackByUserId(userId));
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllFeedbacks() {
		return ResponseEntity.ok(feedService.getAllFeedbacks());
	}

}
