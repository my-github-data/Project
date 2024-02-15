package com.app.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDTO {

	@NotBlank(message = "Email-id Can Not Be Blank")
	@Email(message = "Email-id is Not in Standard Format")
	private String emailId;
	@NotBlank(message = "Password Can Not Be Blank")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password should be of minimum 8 Character containing One Capital letter, One Small letter, One Special Character and One Digit at least.")
	private String password;
}
