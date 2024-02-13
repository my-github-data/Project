package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Feedback;
import com.app.entities.User;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>{
	
	List<Feedback> findAllByUser(User orElseThrow);
}
