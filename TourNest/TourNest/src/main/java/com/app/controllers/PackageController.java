package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/package")
public class PackageController {

	@Autowired
	private PackageService packService;

	@PostMapping("/add")
	public ResponseEntity<?> addPackage(@RequestBody PackageDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(packService.addPackage(dto));
	}

	@PutMapping("/updatePackage/{id}")
	public ResponseEntity<?> updatePackage(@PathVariable Long id, @RequestBody PackageDTO dto) {
		return ResponseEntity.ok(packService.updatePackage(id, dto));
	}

	@DeleteMapping("/deletePackage/{id}")
	public ResponseEntity<?> deletePackage(@PathVariable Long id) {
		return ResponseEntity.ok(packService.deletePackage(id));
	}

	@GetMapping("/viewPackage/{id}")
	public ResponseEntity<?> viewPackage(@PathVariable Long id) {
		return ResponseEntity.ok(packService.viewPackage(id));
	}
}
