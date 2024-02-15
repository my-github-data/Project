package com.app.services;

import java.util.List;

import com.app.dtos.ApiResponse;
import com.app.dtos.UpdateUserDTO;
import com.app.entities.Role;

public interface AdminService {

	List<UpdateUserDTO> getAllUsersByRole(Role role);

	ApiResponse blockClient(Long id);
}
