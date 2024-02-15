package com.app.dtos;

import javax.validation.constraints.NotBlank;
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
public class AddReviewDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	@NotBlank(message = "User Can Not be Null")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long userId;
	@NotBlank(message = "Package Can Not be Null")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long packageId;
	@NotBlank(message = "Please Add Review")
	private String review;
	@NotNull(message = "Rating is Mendatory")
	private int rating;

}
