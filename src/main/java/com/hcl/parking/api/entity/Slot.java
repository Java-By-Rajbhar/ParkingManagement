package com.hcl.parking.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="slot_detail")
@Data
public class Slot {
	@Id
	@GeneratedValue
	private long slotId;
	private String slotStatus;

}
