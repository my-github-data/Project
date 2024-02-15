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
public class AddressDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	private String landmark;
	@NotBlank(message = "City Can Not be Null")
	private String city;
	@NotBlank(message = "State Can Not be Null")
	private String state;
	@NotBlank(message = "Country Can Not be Null")
	private String country;
	@NotNull(message = "Enter Valid Zip-Code")
	private String zipCode;
}
