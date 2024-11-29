package com.nt.binding;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bonus {
	private String Description="For yearly bonus declared";
	private String empId;
	private String designation;
	private LocalDate eventDate;
	private Event event;
	private String notes;
}
