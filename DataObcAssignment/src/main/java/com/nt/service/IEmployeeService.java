package com.nt.service;

import org.springframework.batch.core.JobExecution;

public interface IEmployeeService {
	public JobExecution sendEmployeeDetails() throws Exception;
}
