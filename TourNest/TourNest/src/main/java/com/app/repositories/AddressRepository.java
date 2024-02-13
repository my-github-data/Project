package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Address;
import com.app.entities.User;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	Address findByUser(User userToUpdate);

}
