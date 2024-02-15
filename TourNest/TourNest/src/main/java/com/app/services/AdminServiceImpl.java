package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dtos.ApiResponse;
import com.app.dtos.UpdateUserDTO;
import com.app.entities.Role;
import com.app.entities.User;
import com.app.repositories.AdminRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<UpdateUserDTO> getAllUsersByRole(Role role) {
//		List<User> lt = adminRepo.findAllByRole(role);
//		List<UserDTO> ltDTO = lt.stream().map(user -> mapper.map(user, UserDTO.class)).collect(Collectors.toList());
//		System.out.println(ltDTO);
//		return null;
		return adminRepo.findAllByRole(role).stream().map(user -> mapper.map(user, UpdateUserDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ApiResponse blockClient(Long id) {
		User user = adminRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid User Id"));
		user.setRole(null);
		adminRepo.save(user);
		return new ApiResponse("User Blocked!!!");
	}
}
