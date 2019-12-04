package com.HospitalManagementSystem.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.HospitalManagementSystem.HospitalManagementSystemApplication;
import com.HospitalManagementSystem.model.Physician;
import com.HospitalManagementSystem.service.HospitalManagementService;
 
@Controller
public class HospitalManagementController {
	private static final Logger logger = LoggerFactory.getLogger(HospitalManagementController.class);
  	@Autowired
	private HospitalManagementService hospitalManagementService;
	
	
	@RequestMapping(value="/")
	public String home(Model model) {
		logger.info("Inside the Main controller-index ");
		model.addAttribute("details", new Physician());
		
		return "index";
	}
	
	@RequestMapping(value="/createPhysician")
	public String create( @ModelAttribute("details") Physician physician)
	{
		logger.info("Inside the controller-create physician");
		System.out.println(physician.getDepartmentName());
		return "Login";
		
	}
	
	@RequestMapping(value="/addPhysician")
	public String add( @Valid @ModelAttribute("details") Physician physician)
	{
		 Physician physician1=hospitalManagementService.createPhysician(physician);
		 if(physician1!=null)
		 {
			 logger.info("Inside the controller with success");
		 return "Success";
		 }
		 else
		 {
			 logger.info("Inside the controller with fail operation");
			 return "Fail";
		 }
	}
	
		

}

