package com.sp.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.entity.Employee;
import com.sp.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private  EmployeeRepo repo;
	
	@Override
	public List<Employee> retriveData() {
	    
		List<Employee> all = repo.findByEmployeeStatus("Y");
		
		Iterator<Employee> iterator = all.iterator();
		
		while(iterator.hasNext())
			System.out.println(iterator.next().toString());
		return all;
	}

	@Override
	public Employee addEmployee(Employee emp) {
		
		return repo.save(emp);
	}

	

	@Override
	public Employee findById(Integer employeeId) {
		// TODO Auto-generated method stub
		 Optional<Employee> optional = repo.findById(employeeId);
		 
		 if(optional.isPresent())
			 return optional.get();
		 
		 return null;
	}

}
