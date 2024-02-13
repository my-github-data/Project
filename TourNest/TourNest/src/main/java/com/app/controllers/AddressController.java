package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.AddressDTO;
import com.app.services.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@PostMapping("/add/{userId}")
	public ResponseEntity<?> addAddress(@PathVariable Long userId, @RequestBody AddressDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(addressService.addAddress(userId, dto));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateAddress(@PathVariable Long id, @RequestBody AddressDTO dto) {
		return ResponseEntity.ok(addressService.updateAddress(id, dto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getAddress(@PathVariable Long id) {
		return ResponseEntity.ok(addressService.getAddress(id));
	}
}
