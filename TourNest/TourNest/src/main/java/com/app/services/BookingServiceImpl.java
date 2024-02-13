package com.app.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dtos.AddBookingDTO;
import com.app.dtos.ApiResponse;
import com.app.entities.Booking;
import com.app.repositories.BookingRepository;
import com.app.repositories.PackageRepository;
//import com.app.repositories.PackageRepository;
import com.app.repositories.UserRepository;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PackageRepository packageRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<AddBookingDTO> getBookingByUserId(Long id) {
		return bookingRepo
				.findAllByUser(userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid User")))
				.stream().map(booking -> mapper.map(booking, AddBookingDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<AddBookingDTO> getAllBookings() {
		return bookingRepo.findAll().stream().map(booking -> mapper.map(booking, AddBookingDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public AddBookingDTO updateBooking(Long id, int noOfTickets, boolean paymentStatus) {
		Booking booking = bookingRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Id Provided"));
		booking.setNoOfTickets(noOfTickets);
		booking.setPaymentStatus(paymentStatus);
		return mapper.map(booking, AddBookingDTO.class);
	}

	@Override
	public ApiResponse deleteBooking(Long id) {
		bookingRepo
				.delete(bookingRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Error Occured...")));
		return new ApiResponse("Booking Deleted Successfully!");
	}

	@Override
	public AddBookingDTO addBooking(AddBookingDTO dto) {
		Booking booking = mapper.map(dto, Booking.class);
		booking.setBookingDate(LocalDate.now());
		booking.setUser(userRepo.findById(dto.getUserId()).orElseThrow());
		booking.setPakage(packageRepo.findById(dto.getPackageId()).orElseThrow());
		System.out.println(booking.toString());
		return mapper.map(bookingRepo.save(booking), AddBookingDTO.class);
	}

	@Override
	public AddBookingDTO getBooking(Long bookingId) {
		return mapper.map(
				bookingRepo.findById(bookingId).orElseThrow(() -> new ResourceNotFoundException("Invalid Booking ID")),
				AddBookingDTO.class);
	}

}
