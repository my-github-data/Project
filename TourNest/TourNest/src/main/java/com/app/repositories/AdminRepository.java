package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Role;
import com.app.entities.User;

public interface AdminRepository extends JpaRepository<User, Long> {

	List<User> findAllByRole(Role role);

}
