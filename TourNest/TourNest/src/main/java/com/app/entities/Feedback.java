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
@Table(name = "feedbacks")
public class Feedback extends BaseEntity {
	@Column(length = 150, nullable = false)
	private String feedback;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
}
