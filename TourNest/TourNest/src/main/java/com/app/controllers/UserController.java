package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.UserDTO;
import com.app.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<?> addUser(@RequestBody UserDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(dto));
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody UserDTO dto) {
		return ResponseEntity.ok(userService.loginUser(dto));
	}

	@PutMapping("/changePassword")
	public ResponseEntity<?> changePassword(@RequestBody UserDTO dto) {
		return ResponseEntity.ok(userService.changePassword(dto));

	}

}
