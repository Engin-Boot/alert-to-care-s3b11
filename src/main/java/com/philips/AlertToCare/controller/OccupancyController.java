package com.philips.AlertToCare.controller;

import com.philips.AlertToCare.entities.Bed;
import com.philips.AlertToCare.entities.Client;
import com.philips.AlertToCare.entities.Patient;
import com.philips.AlertToCare.exceptions.BedNotEmptyException;
import com.philips.AlertToCare.exceptions.ICUDoesNotExistException;
import com.philips.AlertToCare.exceptions.PatientDoesNotExistException;
import com.philips.AlertToCare.service.BedService;
import com.philips.AlertToCare.service.ClientService;
import com.philips.AlertToCare.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class OccupancyController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private BedService bedService;

    @Autowired
    private ClientService clientService;

    @PostMapping("/client/patient/admit")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) throws BedNotEmptyException {
        System.out.println("Entered controller");
        bedService.changeBedStatusWhenPatientIsAdmitted(patient.getBedId());
        System.out.println("Bed Status HAS been updated");
        Patient savedPatient = patientService.savePatient(patient);
        System.out.println("saving patient");
        return new ResponseEntity<Patient>(savedPatient, HttpStatus.CREATED);
    }

    @GetMapping("/client/patients")
    public ResponseEntity<List<Patient>> getAllPatients() throws ICUDoesNotExistException {

        return new ResponseEntity<List<Patient>>(patientService.getAllPatients(), HttpStatus.OK);

    }

    @PutMapping("/client/patient/discharge/{patientId}")
    public ResponseEntity<Patient> dischargePatient(@PathVariable(value = "patientId") UUID patientId) throws PatientDoesNotExistException {

        Patient dischargedPatient = patientService.dischargePatient(patientId.toString());
        bedService.changeBedStatusWhenPatientDischarged(dischargedPatient.getBedId());
        return new ResponseEntity<Patient>(dischargedPatient, HttpStatus.OK);
    }

}
