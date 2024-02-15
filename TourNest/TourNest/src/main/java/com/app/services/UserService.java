package com.app.services;

import com.app.dtos.ApiResponse;
import com.app.dtos.LoginDTO;
import com.app.dtos.UpdateUserDTO;
import com.app.dtos.UserDTO;

public interface UserService {

	UserDTO addUser(UserDTO dto);

	UserDTO loginUser(LoginDTO dto);

	ApiResponse changePassword(LoginDTO dto);

	UserDTO updateUser(Long id, UpdateUserDTO dto);
}
