package com.hcl.parking.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.parking.api.entity.ReleaseParking;

@Repository
public interface ReleaseParkingRepository extends JpaRepository<ReleaseParking, Long> {
	
	

}
