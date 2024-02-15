package com.app.controllers;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.LoginDTO;
import com.app.dtos.UpdateUserDTO;
import com.app.dtos.UserDTO;
import com.app.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
@Validated
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<?> addUser(@RequestBody @Valid UserDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(dto));
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody @Valid LoginDTO dto) {
		return ResponseEntity.ok(userService.loginUser(dto));
	}

	@PutMapping("/changePassword")
	public ResponseEntity<?> changePassword(@RequestBody @Valid LoginDTO dto) {
		return ResponseEntity.ok(userService.changePassword(dto));
	}

	@PutMapping("/update/{id}")
	public UserDTO updateUser(@PathVariable @NotNull(message = "User Must be Provided") Long id,
			@RequestBody @Valid UpdateUserDTO dto) {
		return userService.updateUser(id, dto);
	}
}
