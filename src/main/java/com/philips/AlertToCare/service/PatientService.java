package com.philips.AlertToCare.service;

import com.philips.AlertToCare.entities.Client;
import com.philips.AlertToCare.entities.Patient;
import com.philips.AlertToCare.exceptions.ICUDoesNotExistException;
import com.philips.AlertToCare.exceptions.PatientDoesNotExistException;
import com.philips.AlertToCare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService {
    PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    @Autowired
    private ClientService clientService;

    public Patient savePatient(Patient patient){
        String patientId = UUID.randomUUID().toString();
        patient.setPatientId(patientId);
        return patientRepository.save(patient);
    }

    public Patient dischargePatient(String patientId) throws PatientDoesNotExistException {
        Patient patientToDischarge = getPatient(patientId);
        patientRepository.delete(patientToDischarge);
        return patientToDischarge;
    }

    private Patient getPatient(String patientId) throws PatientDoesNotExistException {
        Optional<Patient> patient = patientRepository.findByPatientId(patientId);
        if(patient.isPresent()){
            return patient.get();
        }
        else{
            throw new PatientDoesNotExistException("Patient does not exist with id = "+patientId);
        }
    }

    public List<Patient> getAllPatients() throws ICUDoesNotExistException {
        List<Patient> allPatients = new ArrayList<>();
        List<Client> allClients = clientService.getAllClients();
        if (allClients.size()==0){
            throw new ICUDoesNotExistException("No ICU configured");
        }
        else{
            Client client = allClients.get(0);
            allPatients = patientRepository.findAll();
        }
        return allPatients;
    }
}
