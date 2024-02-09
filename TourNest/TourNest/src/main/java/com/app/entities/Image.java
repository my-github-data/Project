package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "images")
public class Image extends BaseEntity {
	@Column(length = 100)
	private String path;

	@ManyToOne
	@JoinColumn(name = "package_id", nullable = false)
	private Package pakage;
}
