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
public class AddFeedbackDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	@NotNull(message = "User Must be Provided!")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long userId;
	@NotBlank(message = "Feedback Must Not be Blank.")
	private String feedback;

}
