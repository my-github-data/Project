package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "bookings")
public class Booking extends BaseEntity {
	@Column(name = "tickets")
	private int noOfTickets;
	@Column(name = "booking_date")
	private LocalDate bookingDate;
	@Column(name = "payment_status")
	private boolean paymentStatus;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "package_id", nullable = false)
	private Package pakage;
}
