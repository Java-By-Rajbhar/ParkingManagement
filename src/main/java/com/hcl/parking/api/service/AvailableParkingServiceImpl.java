package com.hcl.parking.api.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parking.api.customException.SlotNotAvailableException;
import com.hcl.parking.api.entity.AvailableParking;
import com.hcl.parking.api.entity.Slot;
import com.hcl.parking.api.repository.AvailableParkingRepository;
import com.hcl.parking.api.repository.SlotRepository;

@Service
public class AvailableParkingServiceImpl implements AvailableParkingService {
	
	private static final Logger logger = LogManager.getLogger(AvailableParkingServiceImpl.class);
	@Autowired
	SlotRepository slotRepository;
	@Autowired
	AvailableParkingRepository availableParkingRepository;

	@Override
	public String bookSlot(long slotId, long empId) {
		//date formatter
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
		String  currentDateTime =formatter.format(LocalDateTime.now());
		logger.info(" from bookSlot() and slotid and empid ={}",slotId,empId);
		Slot slot = slotRepository.findBySlotId(slotId);
		logger.info("current date time ={}",currentDateTime);
		if(slot.getSlotStatus().equals("available"))
		{
			//set slot status
			slot.setSlotStatus("booked");
			//now update status
			slotRepository.save(slot);
			//save employee detail ,slot id in available parking 
			AvailableParking parking = new AvailableParking();
			parking.setSlotId(slotId);
			parking.setEmpId(empId);
			parking.setBookDate(currentDateTime);
			parking.setId(100);
			availableParkingRepository.save(parking);
			return "Slot has booked with id "+slotId;
			
		}
		else
		{
			throw new SlotNotAvailableException("Slot id "+slotId+" is already booked");
		}
	}

}
