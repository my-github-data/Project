package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Review;
import com.app.entities.User;
import com.app.entities.Package;

public interface ReviewRepository extends JpaRepository<Review, Long>{
	
	List<Review> findAllByUser(User orElseThrow);
	
	List<Review> findAllByPakage(Package orElseThrow);

}
