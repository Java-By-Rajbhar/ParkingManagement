package com.hcl.parking.api.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.hcl.parking.api.dto.EmployeeDto;
import com.hcl.parking.api.entity.Employee;
import com.hcl.parking.api.repository.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {
	@Mock
	EmployeeRepository employeeRepository;
	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;
	Employee employee;
	EmployeeDto employeeDto;
	
	@Before
	public void setData()
	{
		employee= new Employee();
		employeeDto = new EmployeeDto(100, "Sushil", "SSE", 3);
		BeanUtils.copyProperties(employeeDto, employee);
	}
	
	@Test
	public void testEmployeeRegistration()
	{
		Mockito.when(employeeRepository.save(Mockito.any())).thenReturn(employee);
		
		String success_message  = employeeServiceImpl.employeeRegistration(employeeDto);
		
		assertEquals("You are successfully registered with id 100", success_message);
	}

}
