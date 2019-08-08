package com.hcl.parking.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="release_parking")
public class ReleaseParking {
	
	@Id
	@GeneratedValue
	private long id;
	private long empId;
	private long slotId;
	private String releaseDate;

}
