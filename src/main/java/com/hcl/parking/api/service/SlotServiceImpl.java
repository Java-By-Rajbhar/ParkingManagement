package com.hcl.parking.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.parking.api.repository.SlotRepository;
@Transactional
@Service
public class SlotServiceImpl implements SlotService {

	@Autowired
	SlotRepository slotRepository;
	
	public String releasedailySlot()
	{
		int numberOfUpdateddata = slotRepository.releaseSlotDaily();
		return numberOfUpdateddata+"  slot has updated successfully ";
	}
}
