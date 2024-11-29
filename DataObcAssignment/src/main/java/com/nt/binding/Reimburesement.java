package com.nt.binding;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reimburesement {
	private String Description="When the expenses has to reimburse along with monthly salary ";
	private String empId;
	private String designation;
	private LocalDate eventDate;
	private String event;
	private String notes;
}
