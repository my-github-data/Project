package com.app.controllers;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> getAllUsersByRole(@RequestParam Role role) {
		return ResponseEntity.ok(adminService.getAllUsersByRole(role));
	}

	@PutMapping("/block/{id}")
	public ResponseEntity<?> blockClient(@PathVariable @NotBlank Long id) {
		return ResponseEntity.ok(adminService.blockClient(id));
	}
}
