package com.app.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.app.entities.Type;
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
public class PackageDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private long id;
	@NotBlank
	private String name;
	@NotBlank
	private Type type;
	@NotBlank
	private Integer price;
	@NotBlank
	private String details;
	@NotBlank
	private LocalDate fromDate;
	@NotBlank
	private LocalDate toDate;
}
