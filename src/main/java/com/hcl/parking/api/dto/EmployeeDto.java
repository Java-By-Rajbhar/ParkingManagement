package com.hcl.parking.api.dto;

import lombok.Data;

@Data
public class EmployeeDto {
	
	private long empId;
	private String empName;
	private String designation;
	private int experience;

}
