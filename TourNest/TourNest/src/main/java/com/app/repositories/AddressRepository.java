package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Address;
import com.app.entities.User;

public interface AddressRepository extends JpaRepository<Address, Long> {

	Address findByUser(User userToUpdate);

}
