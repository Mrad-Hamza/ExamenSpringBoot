package tn.spring.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.spring.entities.Patient;
import tn.spring.spring.repositories.PatientRepository;

@Service
public class PatientServiceImpl implements IPatient {

	@Autowired
	PatientRepository patientRepository;

	@Override
	public Patient addPatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepository.save(patient);
	}
}
