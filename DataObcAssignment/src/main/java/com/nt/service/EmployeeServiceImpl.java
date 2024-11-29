package com.nt.service;

import java.util.Date;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private JobLauncher launcher;
	@Autowired
	private Job job;

	@Override
	public JobExecution sendEmployeeDetails() throws Exception{
		// TODO Auto-generated method stub
		JobParameter<Date> param = new JobParameter<Date>(new Date(), Date.class);
		Map<String, JobParameter<?>> map = Map.of("param1", param);
		JobParameters params = new JobParameters(map);
		// call the run method
		JobExecution execution = launcher.run(job, params);
		System.out.println("Job Execution Status::" + execution.getExitStatus());
		return execution;
	}

	@Override
	public void showOnboardDetails(int empiId) {
		
		
	}

	@Override
	public void showSalaryDetails(int empiId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showBonusDetails(int empiId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showExitDetails(int empiId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showReimbursementDetails(int empiId) {
		// TODO Auto-generated method stub
		
	}
}