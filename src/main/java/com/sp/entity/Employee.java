package com.sp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Entity
public class Employee {
	
	private String firstName;
	@Column(name="LASTST_NAME")
	private String lastName;
	@Column(name="employeeMailAddr", insertable=true, updatable=true, unique=true, nullable=false)
	private String employeeMailAddr;
	
	private String employeeStatus;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int    employeeId;
	

}
