package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.UserDTO;
import com.app.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public UserDTO addUser(@RequestBody UserDTO dto) {
		return userService.addUser(dto);
	}
	
	@PostMapping("/login")
	public UserDTO loginUser(@RequestBody UserDTO dto) {
		return userService.loginUser(dto);
	}
}
