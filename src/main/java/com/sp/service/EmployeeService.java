package com.sp.service;

import java.util.List;

import com.sp.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> retriveData();
	
	public Employee addEmployee(Employee emp);
	
	
	
	public Employee findById(Integer employeeId);

}
