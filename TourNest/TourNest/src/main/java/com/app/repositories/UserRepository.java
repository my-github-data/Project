package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmailIdAndPassword(String email, String password);

	User findByEmailId(String email);
}
