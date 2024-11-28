package com.nt.model;

import java.time.LocalDate;

import org.hibernate.annotations.UpdateTimestamp;

import com.nt.binding.Event;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "EMPLOYEE_RECORD_APP1")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@SequenceGenerator(name = "gen1_seq",sequenceName = "app_id_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1_seq",strategy = GenerationType.SEQUENCE)
	private Integer sequaneceNumber;
	@Id
	@Column(length = 40)
	private String empId;
	@Column(length = 40)
	private String empFName;
	@Column(length = 40)
	private String empLName;
	@Column(length = 50)
	private String designation;
	@UpdateTimestamp
	private LocalDate eventDate;
	private Event event;
	@Column(length = 100)
	private String notes;
}
