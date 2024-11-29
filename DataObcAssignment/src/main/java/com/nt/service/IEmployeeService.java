package com.nt.service;

import java.util.List;

import org.springframework.batch.core.JobExecution;

import com.nt.binding.Bonus;
import com.nt.binding.Exit;
import com.nt.binding.Onboard;
import com.nt.binding.Reimburesement;
import com.nt.binding.Salary;

public interface IEmployeeService {
	public JobExecution sendEmployeeDetails() throws Exception;
	public List<Onboard> showOnboardDetails(String empiId);
	public List<Salary> showSalaryDetails(String empiId);
	public List<Bonus> showBonusDetails(String empiId);
	public List<Exit> showExitDetails(String empiId);
	public List<Reimburesement> showReimbursementDetails(String empiId);
}
