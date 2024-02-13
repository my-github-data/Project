package com.app.dtos;

import javax.validation.constraints.NotBlank;

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
	@NotBlank
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long userId;
	@NotBlank
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long packageId;
	@NotBlank
	private int noOfTickets;
	@NotBlank
	private boolean paymentStatus;
}
