package com.hcl.parking.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDto {
	
	private long empId;
	private String empName;
	private String designation;
	private int experience;

}
