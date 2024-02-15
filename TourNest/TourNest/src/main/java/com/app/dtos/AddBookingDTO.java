package com.app.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddBookingDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull(message = "User Must Be Provided")
	private Long userId;
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull(message = "Please Select Package")
	private Long packageId;
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDate bookingDate;
	@NotNull(message = "Provide Valid Number")
	private int noOfTickets;
	@JsonProperty(access = Access.READ_ONLY)
	private boolean paymentStatus;
}
