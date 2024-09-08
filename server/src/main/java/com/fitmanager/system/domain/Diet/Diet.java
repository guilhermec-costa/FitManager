package com.fitmanager.system.domain.Diet;

import java.time.LocalDateTime;

import com.fitmanager.system.domain.BaseEntity;
import com.fitmanager.system.domain.Student.Student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Diet extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private LocalDateTime startDate;

	@Column
	private LocalDateTime endDate;

	@OneToOne
	@JoinColumn(name = "student_id")
	private Student student;
}
