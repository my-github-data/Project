package com.app.controllers;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
@Validated
public class AddressController {

	@Autowired
	private AddressService addressService;

	@PostMapping("/add/{userId}")
	public ResponseEntity<?> addAddress(@PathVariable @NotNull Long userId, @RequestBody @Valid AddressDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(addressService.addAddress(userId, dto));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateAddress(@PathVariable @NotNull Long id, @RequestBody @Valid AddressDTO dto) {
		return ResponseEntity.ok(addressService.updateAddress(id, dto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getAddress(@PathVariable @NotNull Long id) {
		return ResponseEntity.ok(addressService.getAddress(id));
	}
}
