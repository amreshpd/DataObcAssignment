package com.nt.binding;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exit {
	private String Description="When employee exit the organization";
	private String empId;
	private String designation;
	private LocalDate eventDate;
	private Event event;
	private String notes;
}
