package com.HospitalManagementSystem.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HospitalManagementSystem.model.Physician;
@Repository
public interface HospitalManagementDao extends CrudRepository<Physician,Integer>{
  
	public Physician findByFirstNameAndLastName(String firstName,String lastName);
	

}
