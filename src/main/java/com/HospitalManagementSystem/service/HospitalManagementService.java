package com.HospitalManagementSystem.service;



import org.springframework.transaction.annotation.Transactional;

import com.HospitalManagementSystem.model.Physician;

@Transactional
public interface HospitalManagementService {

	

	
	 public abstract Physician createPhysician(Physician physician);
	 
	
}
