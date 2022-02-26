package tn.spring.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.spring.entities.Patient;
import tn.spring.spring.services.IPatient;

@RestController

public class PatientRestController {

	@Autowired
	IPatient patientService;
	
	@PostMapping("/addPatient")	
	@ResponseBody
	public Patient addPatient(@RequestBody Patient patient) {
		return patientService.addPatient(patient);
	}
	
		
}
