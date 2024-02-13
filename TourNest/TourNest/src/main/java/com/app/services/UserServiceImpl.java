package com.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
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

	@Override
	public UserDTO loginUser(UserDTO dto) {
		User user = userRepo.findByEmailIdAndPassword(dto.getEmailId(), dto.getPassword());
		if (user != null)
			return mapper.map(user, UserDTO.class);
		throw new ResourceNotFoundException("Invalid Email Or Password");
	}

	@Override
	public UserDTO changePassword(UserDTO dto) {
		User user = userRepo.findByEmailId(dto.getEmailId());
		if (user != null) {
			user.setPassword(dto.getPassword());
			return mapper.map(user, UserDTO.class);
		}
		throw new ResourceNotFoundException("Invalid Email Or Password");
	}
	
	@Override
	public UserDTO updateUser(Long id, UserDTO dto) {
	    if (userRepo.existsById(id)) {
	        User existingUser = userRepo.findById(id).orElse(null);

	        if (existingUser != null) {
	            existingUser.setFirstName(dto.getFirstName());
	            existingUser.setLastName(dto.getLastName());
	            existingUser.setEmailId(dto.getEmailId());
	            existingUser.setPhoneNo(dto.getPhoneNo());
	            existingUser.setPassword(dto.getPassword());
	            return mapper.map(userRepo.save(existingUser), UserDTO.class);
	        }
	    }
	    return null;
	}
}
