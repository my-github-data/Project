package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

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
	private String firstName;
	@Column(length = 75, nullable = false, unique = true)
	private String lastName;
	@Column(name = "email_id", length = 75, unique = true, nullable = false)
	private String emailId;
	@Column(name = "phone_no", length = 15, unique = true, nullable = false)
	private String phoneNo;
	@Column(length = 25, unique = true, nullable = false)
	private String password;
	@CreationTimestamp
	@Column(name = "registration_date")
	private LocalDate registrationDate;
	@Enumerated(EnumType.STRING)
	private Role role;
}
