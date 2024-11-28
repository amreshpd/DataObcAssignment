package com.nt.controller;

import org.springframework.batch.core.JobExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.service.IEmployeeService;

@RestController
@RequestMapping("/empRecords")
public class EmployeeController {
	@Autowired
	private IEmployeeService service;

	@GetMapping("/send")
	public ResponseEntity<String> sendAmount() throws Exception {
		JobExecution execution = service.sendEmployeeDetails();
		return new ResponseEntity<String>(execution.getExitStatus().getExitDescription(), HttpStatus.OK);
	}

}
