package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dtos.AddFeedbackDTO;
import com.app.entities.Feedback;
import com.app.repositories.FeedbackRepository;
import com.app.repositories.UserRepository;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepository feedRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public AddFeedbackDTO addFeedback(AddFeedbackDTO dto) {
		Feedback feedback = mapper.map(dto, Feedback.class);
		feedback.setUser(userRepo.findById(dto.getUserId()).orElseThrow());
		System.out.println(feedback.toString());
		return mapper.map(feedRepo.save(feedback), AddFeedbackDTO.class);
	}

	@Override
	public AddFeedbackDTO getFeedback(Long feedbackId) {
		return mapper.map(
				feedRepo.findById(feedbackId).orElseThrow(() -> new ResourceNotFoundException("Invalid Feedback ID")),
				AddFeedbackDTO.class);
	}

	@Override
	public List<AddFeedbackDTO> getFeedbackByUserId(Long id) {
		return feedRepo
				.findAllByUser(userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid User")))
				.stream().map(feedback -> mapper.map(feedback, AddFeedbackDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<AddFeedbackDTO> getAllFeedbacks() {
		return feedRepo.findAll().stream().map(feedback -> mapper.map(feedback, AddFeedbackDTO.class))
				.collect(Collectors.toList());
	}

}
