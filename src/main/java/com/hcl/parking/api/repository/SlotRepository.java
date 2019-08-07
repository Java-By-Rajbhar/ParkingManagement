package com.hcl.parking.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.parking.api.entity.Slot;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long>{
	
	public Slot findBySlotId(long slotId);

}
