package com.app.dtos;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	@NotBlank(message = "Package Name Can Not Be Blank")
	private String name;
	@NotNull(message = "Package Type is Compulsory")
	private Type type;
	@NotNull(message = "Package Price Can Not Be Blank")
	private Integer price;
	@NotBlank(message = "Fill Details")
	private String details;
	@Future(message = "Both Dates Must be from Future")
	@NotNull(message = "Date Can Not Be Blank")
	private LocalDate fromDate;
	@Future(message = "Both Dates Must be from Future")
	@NotNull(message = "Date Can Not Be Blank")
	private LocalDate toDate;
}
