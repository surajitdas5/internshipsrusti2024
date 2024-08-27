package com.medicare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.model.Patient;
import com.medicare.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	PatientRepository patientRepo;
	
	public boolean createPatient(Patient p) {
		try {
			patientRepo.save(p);
			return true;
		} catch(Exception e) {
			System.out.println("Create Patient: "+e);
			return false;
		}
	}
	
	public Patient getPatientByEmail(String email) {
		return patientRepo.findByEmail(email);
	}
}
