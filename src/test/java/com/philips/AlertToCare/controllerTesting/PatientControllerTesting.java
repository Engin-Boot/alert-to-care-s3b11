package com.philips.AlertToCare.controllerTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.philips.AlertToCare.controller.PatientController;
import com.philips.AlertToCare.entities.Bed;
import com.philips.AlertToCare.entities.Patient;
import com.philips.AlertToCare.service.PatientService;


public class PatientControllerTesting {


	@Test
    public void addPatientReturnsBadRequestForErrors() {
        Bed bed = new Bed();
        bed.setBedId(1);

        Patient patient = new Patient();
        patient.setBed(bed);

        PatientService ps = Mockito.mock(PatientService.class);
        Mockito.when(ps.addNewPatient(patient, 1)).thenReturn(null);
        
        PatientController patientController = new PatientController();
        patientController.setPatientService(ps);

        assertEquals(HttpStatus.BAD_REQUEST, patientController.addNewPatient(patient).getStatusCode());
    }
	
	@Test
    public void addPatientReturnsCreatedAndAURILocation() {
        Bed bed = new Bed();
        bed.setBedId(1);

        Patient patient = new Patient();
        patient.setBed(bed);
        patient.setPatientId(1);

        PatientService ps = Mockito.mock(PatientService.class);
        Mockito.when(ps.addNewPatient(patient, 1)).thenReturn(patient);

        PatientController pc = new PatientController();
        pc.setPatientService(ps);

        ResponseEntity<Patient> response = pc.addNewPatient(patient);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("patients/1", response.getHeaders().getLocation().toString());
    }
	
	@Test
    public void getAllPatientsForEmptyPatientRecords() {
		
        PatientService ps = Mockito.mock(PatientService.class);
        Mockito.when(ps.getAllPatients()).thenReturn(null);
        
        PatientController pc = new PatientController();
        pc.setPatientService(ps);

        ResponseEntity<List<Patient>> response = pc.getAllPatients();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(0, response.getBody().size());
    }
	
	@Test
    public void getAllPatientsReturnsListOfPatientsWhenThereArePatients() {
		
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient());
        patients.add(new Patient());
        
        PatientService ps = Mockito.mock(PatientService.class);
        Mockito.when(ps.getAllPatients()).thenReturn(patients);
        
        PatientController pc = new PatientController();
        pc.setPatientService(ps);

        ResponseEntity<List<Patient>> response = pc.getAllPatients();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().containsAll(patients));
    }
	
	@Test
    public void getPatientByIdReturnsNotFoundForInvalidId() {
        PatientService ps = Mockito.mock(PatientService.class);
        Mockito.when(ps.getPatient(Mockito.anyInt())).thenReturn(null);
        PatientController pc = new PatientController();
        pc.setPatientService(ps);

        ResponseEntity<Patient> response = pc.getPatientById(1);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
	
	@Test
    public void getPatientByIdReturnsPatientForValidId() {
        Patient patient = new Patient();
        
        PatientService ps = Mockito.mock(PatientService.class);
        Mockito.when(ps.getPatient(1)).thenReturn(patient);
        
        PatientController pc = new PatientController();
        pc.setPatientService(ps);

        ResponseEntity<Patient> response = pc.getPatientById(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(patient, response.getBody());
    }
	
	@Test
    public void dischargePatientReturnsNotFoundIfPatientIsNull() {
		
        PatientService ps = Mockito.mock(PatientService.class);
        Mockito.when(ps.getPatient(1)).thenReturn(null);
        
        PatientController pc = new PatientController();
        pc.setPatientService(ps);

        ResponseEntity<Patient> response = pc.dischargePatient(1);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
	
	@Test
    public void dischargePatientReturnsNotFoundIfServiceLayerReturnsFalse() {
		Bed bed = new Bed();
		bed.setBedId(2);
		Patient patient = new Patient();
		patient.setPatientId(1);
		patient.setBed(bed);
		  
        PatientService ps = Mockito.mock(PatientService.class);
        Mockito.when(ps.getPatient(1)).thenReturn(patient);
        Mockito.when(ps.dischargePatient(1,1)).thenReturn(false);
        
        PatientController pc = new PatientController();
        pc.setPatientService(ps);

        ResponseEntity<Patient> response = pc.dischargePatient(1);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
	
	@Test
    public void dischargePatient3() {
		Bed bed = new Bed();
		bed.setBedId(1);
		Patient patient = new Patient();
		patient.setPatientId(1);
		patient.setBed(bed);
		  
        PatientService ps = Mockito.mock(PatientService.class);
        Mockito.when(ps.getPatient(1)).thenReturn(patient);
        Mockito.when(ps.dischargePatient(1,1)).thenReturn(true);
        
        PatientController pc = new PatientController();
        pc.setPatientService(ps);

        ResponseEntity<Patient> response = pc.dischargePatient(1);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
