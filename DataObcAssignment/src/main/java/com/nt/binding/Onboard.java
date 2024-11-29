package com.nt.binding;

import java.time.LocalDate;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Onboard {
	private String Description="When employee join the organization";
	private String empId;
	private String empFName;
	private String empLName;
	private String designation;
	private LocalDate eventDate;
	private Event event;
	private String notes;
}
