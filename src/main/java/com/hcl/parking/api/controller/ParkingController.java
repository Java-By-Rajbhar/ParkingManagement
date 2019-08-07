package com.hcl.parking.api.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parking.api.dto.EmployeeDto;
import com.hcl.parking.api.service.AvailableParkingServiceImpl;
import com.hcl.parking.api.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/parking")
public class ParkingController {
	private static final Logger logger = LogManager.getLogger(ParkingController.class);
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	@Autowired
	AvailableParkingServiceImpl availableParkingServiceImpl;
	
	@PostMapping("/registration")
	public ResponseEntity<String> employeeRegistration(@RequestBody EmployeeDto employeeDto)
	{
		logger.info("from employeeRegistration() method of EmployeeController class ");
		logger.info("employeeDto data={}",employeeDto);
		String regis_message = employeeServiceImpl.employeeRegistration(employeeDto);
		return new ResponseEntity<String>(regis_message, HttpStatus.OK);
	}

	@GetMapping("/bookParking/{empId}/{slotId}")
	public ResponseEntity<String> bookParking(@PathVariable long empId,@PathVariable long slotId)
	{
		logger.info("from bookParking () with parameters empid and slotid={}",empId,slotId);
		String bookMessage = availableParkingServiceImpl.bookSlot(slotId, empId);
		return new ResponseEntity<String>(bookMessage, HttpStatus.OK);
	}
}
