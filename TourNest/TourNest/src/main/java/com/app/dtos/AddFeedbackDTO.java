package com.app.dtos;

import javax.validation.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddFeedbackDTO {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	@NotBlank
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long userId;
	@NotBlank
	private String feedback;
	
}
