package com.philips.AlertToCare.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.philips.AlertToCare.entities.Bed;
import com.philips.AlertToCare.entities.Patient;
import com.philips.AlertToCare.service.PatientService;

@RestController
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@GetMapping("/patients")
	public ResponseEntity<List<Patient>> getAllPatients(){
		List<Patient> patients = patientService.getAllPatients();
		if(patients == null) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
		}
		return new ResponseEntity<>(patients, HttpStatus.OK);
	}
	
	@PostMapping("/patients")
	public ResponseEntity<Patient> addNewPatient(@RequestBody Patient patient){
		
		Bed bed = patient.getBed();
		int bedId = bed.getBedId();
		
		Patient newPatient = patientService.addNewPatient(patient, bedId);
		
		if(newPatient == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create("patients/" + newPatient.getPatientId()));
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/patients/{pid}")
	public ResponseEntity<Patient> getPatientById(@PathVariable("pid") int patientId){
	        
        Patient patient = patientService.getPatient(patientId);

        if (patient != null) {
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@DeleteMapping("/patients/{pid}")
	public ResponseEntity<Patient> dischargePatient(@PathVariable("pid") int patientId){
		
		Patient patient = patientService.getPatient(patientId);
		if(patient != null) {
			Bed bed = patient.getBed();
			int bedId = bed.getBedId();
			boolean flag = patientService.dischargePatient(patientId, bedId);
			if(flag) {
				return new ResponseEntity<>(patient, HttpStatus.NO_CONTENT);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public void setPatientService(PatientService ps) {
		
		
	}
}
