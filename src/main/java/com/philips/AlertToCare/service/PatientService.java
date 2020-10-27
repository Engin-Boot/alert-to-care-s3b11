package com.philips.AlertToCare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.AlertToCare.entities.Bed;
import com.philips.AlertToCare.entities.Patient;
import com.philips.AlertToCare.repository.JpaBedDao;
import com.philips.AlertToCare.repository.JpaPatientDao;

@Service
public class PatientService {
	
	@Autowired
	private JpaPatientDao patientDao;
	
	@Autowired
    JpaBedDao bedDao;
	
	public List<Patient> getAllPatients() {
		
		return patientDao.findAllPatients();
	}

	public Patient getPatient(int patientId) {
		return patientDao.findPatientById(patientId);
	}
	
	public Patient addNewPatient(Patient patient, int bedId) {
        Bed bed = bedDao.findBedById(bedId); 
        if (bed == null) return null;

        if (bed.isBedStatus()) {
        	patient.setBed(bed);
        	return patientDao.addNewPatient(patient);
        } else {
            return null;
        }
    }
	
	public Patient getPatientFromBedId(int bedId) {
		Patient patient = patientDao.findPatientByBedId(bedId);
		if(patient == null) {
			return null;
		}
		else {
			return patient;
		}
	}
	
	public boolean dischargePatient(int patientId, int bedId) {
		Patient patient = patientDao.findPatientById(patientId);
        if (patient == null) {
        	return false;
        }
        else {
        	Bed bed = bedDao.findBedById(bedId);
        	patient.freeBed(bed);
        	patientDao.deletePatient(patientId);
        }
        return true;
	} 
	
}
