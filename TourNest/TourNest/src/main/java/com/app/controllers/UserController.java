package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public UserDTO addUser(@RequestBody UserDTO dto) {
		return userService.addUser(dto);
	}
	
	@PostMapping("/login")
	public UserDTO loginUser(@RequestBody UserDTO dto) {
		return userService.loginUser(dto);
	}

	
	@PutMapping("/changePassword")
	public UserDTO changePassword(@RequestBody UserDTO dto) {
		System.out.println(dto);
		return userService.changePassword(dto);
		
	}
	
	@DeleteMapping("/{UserId}")
	public String deleteUserDetails(@PathVariable Long UserId)
	{
		System.out.println("in del user details" +UserId);
		return userService.deleteUserDetails(UserId);
		
	}
	
	@PutMapping("/changePassword")
	public UserDTO changePassword(@RequestBody UserDTO dto) {
		return userService.changePassword(dto);
	}
	
}
