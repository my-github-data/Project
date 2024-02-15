package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "packages")
public class Package extends BaseEntity {

	@Column(length = 30, nullable = false, unique = true)
	private String name;
	@Enumerated(EnumType.STRING)
	@Column(length = 15, nullable = false)
	private Type type;
	@Column(nullable = false)
	private Integer price;
	@Column(length = 150)
	private String details;
	@Column(name = "from_date", nullable = false)
	private LocalDate fromDate;
	@Column(name = "to_date")
	private LocalDate toDate;
	@Column(name = "launch_date")
	private LocalDate launchDate;

}
