package com.nt.binding;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

	private LocalDate onBoard;
	private Double salary;
	private Double bonus;
	private LocalDate exit;
	private Double reimbursement;
}
