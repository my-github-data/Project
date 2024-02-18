package com.app.controllers;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.PackageDTO;
import com.app.services.PackageService;

@RestController
@RequestMapping("/package")
@Validated
@CrossOrigin(origins = "http://localhost:3000")
public class PackageController {

	@Autowired
	private PackageService packService;

	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addPackage(@RequestBody @Valid PackageDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(packService.addPackage(dto));
	}

	@PutMapping("/updatePackage/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updatePackage(@PathVariable @NotNull(message = "Provide Package To Update") Long id,
			@RequestBody @Valid PackageDTO dto) {
		return ResponseEntity.ok(packService.updatePackage(id, dto));
	}

	@DeleteMapping("/deletePackage/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deletePackage(@PathVariable @NotNull(message = "Provide Package To Update") Long id) {
		return ResponseEntity.ok(packService.deletePackage(id));
	}

	@GetMapping("/viewPackage/{id}")
	@PreAuthorize("hasAnyRole('CLIENT', 'ADMIN')")
	public ResponseEntity<?> viewPackage(@PathVariable @NotNull(message = "Provide Package To Update") Long id) {
		return ResponseEntity.ok(packService.viewPackage(id));
	}

	@GetMapping("/viewAllPackages")
	public ResponseEntity<?> viewAllPackages() {
		return ResponseEntity.status(HttpStatus.OK).body(packService.viewAllPackages());
	}
}
