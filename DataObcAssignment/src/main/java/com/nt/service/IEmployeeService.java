package com.nt.service;

import org.springframework.batch.core.JobExecution;

public interface IEmployeeService {
	public JobExecution sendEmployeeDetails() throws Exception;
	public void showOnboardDetails(int empiId);
	public void showSalaryDetails(int empiId);
	public void showBonusDetails(int empiId);
	public void showExitDetails(int empiId);
	public void showReimbursementDetails(int empiId);
}
