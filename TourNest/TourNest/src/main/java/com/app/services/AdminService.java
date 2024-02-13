package com.app.services;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.app.dtos.AdminDTO;
import com.app.dtos.ApiResponse;
import com.app.entities.Role;

public interface AdminService {

	List<AdminDTO> getAllUsersByRole(Role role);

	ApiResponse blockClient(@NotBlank Long id);
}
