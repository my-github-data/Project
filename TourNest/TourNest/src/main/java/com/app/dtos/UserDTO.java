package com.app.dtos;

import javax.persistence.Column;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
	@JsonProperty(access = Access.READ_ONLY)
	private long id;
	private String name;
	private String emailId;
	private long phoneNo;
	private String password;
}
