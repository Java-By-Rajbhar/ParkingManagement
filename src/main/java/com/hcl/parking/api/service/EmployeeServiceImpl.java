package com.hcl.parking.api.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parking.api.dto.EmployeeDto;
import com.hcl.parking.api.entity.Employee;
import com.hcl.parking.api.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);
	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public String employeeRegistration(EmployeeDto employeeDto) {
		logger.info("from employeeRegistration() method");
		logger.info("employeeDto data={}",employeeDto);
		//convert dto to entity
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDto, employee);
		logger.info("after conversion dto to employee entity={}",employee);
		Employee employee2 = employeeRepository.save(employee);
		if(employee2!=null)
		{
			logger.info("successfully registered={}",employee2);
			return "You are successfully registered with id "+employee2.getEmpId();
		}
		else
		{
			logger.error("Something went wrong ,try again");
			return "Please try again !!!!";
		}
	}

}
