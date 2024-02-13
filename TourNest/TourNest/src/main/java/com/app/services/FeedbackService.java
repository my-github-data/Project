package com.app.services;

import java.util.List;

import com.app.dtos.AddFeedbackDTO;
public interface FeedbackService {
	
	AddFeedbackDTO addFeedback(AddFeedbackDTO dto);
	
	AddFeedbackDTO getFeedback(Long feedbackId);
	
	List<AddFeedbackDTO> getFeedbackByUserId(Long id);
		
	List<AddFeedbackDTO> getAllFeedbacks();

}
