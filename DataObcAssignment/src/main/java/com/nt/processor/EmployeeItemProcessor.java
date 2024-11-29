package com.nt.processor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.nt.model.Employee;

@Component("empProcessor")
public class EmployeeItemProcessor implements ItemProcessor<Employee, List<Employee>>{

	private ArrayList<Employee> list=new ArrayList<Employee>();
	private String empId;
	@Override
	public List<Employee> process(Employee item) throws Exception {
	Employee emp=new Employee();
	empId = item.getEmpId();
	if(empId!=null) {
		emp.setEmpId(empId);
		emp.setEmpFName(item.getEmpFName());
		emp.setEmpLName(item.getEmpLName());
		emp.setSequenceNumber(item.getSequenceNumber());
		emp.setDesignation(item.getDesignation());
		emp.setEventDate(item.getEventDate());
		emp.setEvent(item.getEvent());
		emp.setNotes(item.getNotes());
		list.add(emp);		
	}
		return list;
	}

}
