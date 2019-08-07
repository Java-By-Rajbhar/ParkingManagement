package com.hcl.parking.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="avilavle_parking")
public class AvailableParking {
	
	@Id
	@GeneratedValue
	private long id;
	private long empId;
	private long slotId;
	private String bookDate;

}
