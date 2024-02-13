package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Role;
import com.app.entities.User;

@Repository
public interface AdminRepository extends JpaRepository<User, Long> {

	List<User> findAllByRole(Role role);

}
