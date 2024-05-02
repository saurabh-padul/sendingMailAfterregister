package com.sp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
     
	public List<Employee> findByEmployeeStatus(String s);
}
