package com.app.controllers;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Role;
import com.app.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/allusersbyrole")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAllUsersByRole(@RequestParam @NotNull Role role) {
		return ResponseEntity.ok(adminService.getAllUsersByRole(role));
	}

	@PutMapping("/block/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> blockClient(@PathVariable @NotNull Long id) {
		return ResponseEntity.ok(adminService.blockClient(id));
	}
}
