package com.app.services;

import java.util.List;

import com.app.dtos.AddBookingDTO;
import com.app.dtos.ApiResponse;

public interface BookingService {

	AddBookingDTO addBooking(AddBookingDTO dto);

	List<AddBookingDTO> getBookingByUserId(Long id);

	List<AddBookingDTO> getAllBookings();

	AddBookingDTO updateBooking(Long id, int noOfTickets, boolean paymentStatus);

	ApiResponse deleteBooking(Long id);

	AddBookingDTO getBooking(Long bookingId);

}
