package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

	@Column(name = "first_name", length = 20, nullable = false)
	private String firstName;
	@Column(name = "last_name", length = 20, nullable = false)
	private String lastName;
	@Column(name = "email_id", length = 30, unique = true, nullable = false)
	private String emailId;
	@Column(name = "phone_no", length = 15, unique = true, nullable = false)
	private String phoneNo;
	@Column(length = 250, nullable = false)
	private String password;
	@CreationTimestamp
	@Column(name = "registration_date")
	private LocalDate registrationDate;
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private Role role;
}
