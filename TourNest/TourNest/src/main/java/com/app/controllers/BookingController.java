package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping("/add")
	public ResponseEntity<?> addBooking(@RequestBody AddBookingDTO dto) {
		System.out.println(dto.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.addBooking(dto));
	}

	@GetMapping("/fetch/{userId}")
	public ResponseEntity<?> getBookings(@PathVariable Long userId) {
		return ResponseEntity.ok(bookingService.getBookingByUserId(userId));
	}

	@GetMapping("/get/{bookingId}")
	public ResponseEntity<?> getBooking(@PathVariable Long bookingId) {
		return ResponseEntity.ok(bookingService.getBooking(bookingId));
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllBookings() {
		return ResponseEntity.ok(bookingService.getAllBookings());
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateBooking(@PathVariable Long id, @RequestParam int noOfTickets,
			@RequestBody boolean paymentStatus) {
		return ResponseEntity.ok(bookingService.updateBooking(id, noOfTickets, paymentStatus));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBooking(@PathVariable Long id) {
		return ResponseEntity.ok(bookingService.deleteBooking(id));
	}
}
