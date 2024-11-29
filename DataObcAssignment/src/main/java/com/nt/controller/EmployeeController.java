package com.nt.controller;

import java.util.List;

import org.springframework.batch.core.JobExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.binding.Bonus;
import com.nt.binding.Exit;
import com.nt.binding.Onboard;
import com.nt.binding.Reimburesement;
import com.nt.binding.Salary;
import com.nt.service.IEmployeeService;

@RestController
@RequestMapping("/empRecords")
public class EmployeeController {
	@Autowired
	private IEmployeeService service;

	@PutMapping("/send")
	public ResponseEntity<String> sendAmount() throws Exception {
		JobExecution execution = service.sendEmployeeDetails();
		return new ResponseEntity<String>(execution.getExitStatus().getExitDescription(), HttpStatus.OK);
	}
	
	@GetMapping("/viewOnboard/{empId}")
	public ResponseEntity<List<Onboard>> viewOnboardDetails(@PathVariable String empiId){
		List<Onboard> board = service.showOnboardDetails(empiId);
		return new ResponseEntity<List<Onboard>>(board,HttpStatus.OK);
	}
	@GetMapping("/viewSalary/{empId}")
	public ResponseEntity<List<Salary>> showSalaryDetails(@PathVariable String empiId){
		List<Salary> board = service.showSalaryDetails(empiId);
		return new ResponseEntity<>(board,HttpStatus.OK);
	}
	@GetMapping("/viewBonus/{empId}")
	public ResponseEntity<List<Bonus>> showBonusDetails(@PathVariable String empiId){
		List<Bonus> board = service.showBonusDetails(empiId);
		return new ResponseEntity<>(board,HttpStatus.OK);
	}
	@GetMapping("/viewExit/{empId}")
	public ResponseEntity<List<Exit>> showExitDetails(@PathVariable String empiId){
		List<Exit> board = service.showExitDetails(empiId);
		return new ResponseEntity<>(board,HttpStatus.OK);
	}
	@GetMapping("/viewExit/{empId}")
	public ResponseEntity<List<Reimburesement>> showReimbursementDetails(@PathVariable String empiId){
		List<Reimburesement> board = service.showReimbursementDetails(empiId);
		return new ResponseEntity<>(board,HttpStatus.OK);
	}
}