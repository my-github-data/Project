package com.app.controllers;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.AddBookingDTO;
import com.app.services.BookingService;

@RestController
@RequestMapping("/booking")
@Validated
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping("/add")
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<?> addBooking(@RequestBody @Valid AddBookingDTO dto) {
		System.out.println(dto.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.addBooking(dto));
	}

	@GetMapping("/fetch/{userId}")
	@PreAuthorize("hasAnyRole('CLIENT', 'ADMIN')")
	public ResponseEntity<?> getBookings(@PathVariable @NotNull Long userId) {
		return ResponseEntity.ok(bookingService.getBookingByUserId(userId));
	}

	@GetMapping("/get/{bookingId}")
	@PreAuthorize("hasAnyRole('CLIENT', 'ADMIN')")
	public ResponseEntity<?> getBooking(@PathVariable @NotNull Long bookingId) {
		return ResponseEntity.ok(bookingService.getBooking(bookingId));
	}

	@GetMapping("/all")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAllBookings() {
		return ResponseEntity.ok(bookingService.getAllBookings());
	}

	@PutMapping("/update/{id}")
	@PreAuthorize("hasAnyRole('CLIENT', 'ADMIN')")
	public ResponseEntity<?> updateBooking(@PathVariable @NotNull Long id, @RequestParam @NotNull int noOfTickets,
			@RequestParam @NotNull boolean paymentStatus) {
		return ResponseEntity.ok(bookingService.updateBooking(id, noOfTickets, paymentStatus));
	}

	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasAnyRole('CLIENT', 'ADMIN')")
	public ResponseEntity<?> deleteBooking(@PathVariable @NotNull Long id) {
		return ResponseEntity.ok(bookingService.deleteBooking(id));
	}
}
