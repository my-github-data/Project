package com.app.services;

import com.app.dtos.UserDTO;

public interface UserService {

	UserDTO addUser(UserDTO dto);
	UserDTO loginUser(UserDTO dto);
}
