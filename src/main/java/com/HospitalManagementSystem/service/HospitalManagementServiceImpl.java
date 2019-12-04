package com.HospitalManagementSystem.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HospitalManagementSystem.HospitalManagementSystemApplication;
import com.HospitalManagementSystem.dao.HospitalManagementDao;
import com.HospitalManagementSystem.model.Physician;
@Service
public class HospitalManagementServiceImpl implements HospitalManagementService {
	private static final Logger logger = LoggerFactory.getLogger(HospitalManagementService.class);
	@Autowired
	private HospitalManagementDao hospitalManagementDao;
	
	
	@Transactional
	@Override
	public Physician createPhysician(Physician physician) {
		Physician physician1=this.hospitalManagementDao.findByFirstNameAndLastName(physician.getFirstName(), physician.getLastName());
		if(physician1==null)
		{
			logger.info("Inside the Service method");
		return this.hospitalManagementDao.save(physician);
		}
		else
			return null;
	}

	
}
