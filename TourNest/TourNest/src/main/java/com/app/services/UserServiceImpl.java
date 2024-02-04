package com.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dtos.UserDTO;
import com.app.entities.User;
import com.app.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDTO addUser(UserDTO dto) {
		return mapper.map(userRepo.save(mapper.map(dto, User.class)), UserDTO.class);
	}

}
