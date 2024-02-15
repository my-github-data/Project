package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Booking;
import com.app.entities.User;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

	List<Booking> findAllByUser(User user);

}
