package com.nt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.binding.Bonus;
import com.nt.binding.Exit;
import com.nt.binding.Onboard;
import com.nt.binding.Reimburesement;
import com.nt.binding.Salary;
import com.nt.model.Employee;
import com.nt.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private JobLauncher launcher;
	@Autowired
	private Job job;

	@Autowired
	private IEmployeeRepository repo;
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
	public List<Onboard> showOnboardDetails(String empiId) {
		Optional<Employee> opt = repo.findById(empiId);
		Onboard board=new Onboard();
		List<Onboard> list=new ArrayList<Onboard>();
		if(opt.isPresent()) {
			Employee emp = opt.get();
			board.setDesignation(emp.getDesignation());
			board.setEmpFName(emp.getEmpFName());
			board.setEmpId(empiId);
			board.setEmpLName(emp.getEmpLName());
			board.setEvent(emp.getEvent().getEventType().toString());
			board.setEventDate(emp.getEventDate());
			board.setNotes(emp.getNotes());
			list.add(board);
		}
		return list;
	}

	@Override
	public List<Salary> showSalaryDetails(String empiId) {
		// TODO Auto-generated method stub
		Optional<Employee> opt = repo.findById(empiId);
		Salary board=new Salary();
		List<Salary> list=new ArrayList<>();
		if(opt.isPresent()) {
			Employee emp = opt.get();
			board.setDesignation(emp.getDesignation());
			board.setEmpId(empiId);
			board.setEvent(emp.getEvent().getEventType().toString());
			board.setEventDate(emp.getEventDate());
			board.setNotes(emp.getNotes());
			list.add(board);
		}
		return list;
		
	}

	@Override
	public List<Bonus> showBonusDetails(String empiId) {
		// TODO Auto-generated method stub
		Optional<Employee> opt = repo.findById(empiId);
		Bonus board=new Bonus();
		List<Bonus> list=new ArrayList<>();
		if(opt.isPresent()) {
			Employee emp = opt.get();
			board.setDesignation(emp.getDesignation());
			board.setEmpId(empiId);
			board.setEvent(emp.getEvent().getEventType().toString());
			board.setEventDate(emp.getEventDate());
			board.setNotes(emp.getNotes());
			list.add(board);
		}
		return list;
	}

	@Override
	public List<Exit> showExitDetails(String empiId) {
		// TODO Auto-generated method stub
		Optional<Employee> opt = repo.findById(empiId);
		Exit board=new Exit();
		List<Exit> list=new ArrayList<>();
		if(opt.isPresent()) {
			Employee emp = opt.get();
			board.setDesignation(emp.getDesignation());
			board.setEmpId(empiId);
			board.setEvent(emp.getEvent().getEventType().toString());
			board.setEventDate(emp.getEventDate());
			board.setNotes(emp.getNotes());
			list.add(board);
		}
		return list;
		
	}

	@Override
	public List<Reimburesement> showReimbursementDetails(String empiId) {
		// TODO Auto-generated method stub
		Optional<Employee> opt = repo.findById(empiId);
		Reimburesement board=new Reimburesement();
		List<Reimburesement> list=new ArrayList<>();
		if(opt.isPresent()) {
			Employee emp = opt.get();
			board.setDesignation(emp.getDesignation());
			board.setEmpId(empiId);
			board.setEvent(emp.getEvent().getEventType().toString());
			board.setEventDate(emp.getEventDate());
			board.setNotes(emp.getNotes());
			list.add(board);
		}
		return list;
	}
}