package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class User extends BaseEntity {
	@Column(length = 75, nullable = false, unique = true)
	@NotBlank
	private String name;

	@Column(name = "email_id", length = 75, unique = true, nullable = false)
	@Email
	@NotBlank
	private String emailId;

	@Column(name = "phone_no", length = 15, unique = true, nullable = false)
	private String phoneNo;

	@Column(length = 25, unique = true, nullable = false)
	@NotBlank
	private String password;
}
