package com.nt.binding;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salary {
	private String Description="For monthly salary ";
	private String empId;
	private String designation;
	private LocalDate eventDate;
	private String event;
	private String notes;
}
