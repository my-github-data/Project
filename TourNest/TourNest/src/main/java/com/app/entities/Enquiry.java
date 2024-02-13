package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
@Entity
@Table(name = "enquiries")
public class Enquiry extends BaseEntity {

	@Column(length = 75)
	private String name;
	@Column(name = "email_id", length = 75, nullable = false, unique = true)
	private String emailId;
	@Column(length = 75, nullable = false)
	private String subject;
	@Column(length = 250)
	private String description;
	@Column(name = "posting_date")
	private LocalDate postingDate;
	private boolean status;
}
