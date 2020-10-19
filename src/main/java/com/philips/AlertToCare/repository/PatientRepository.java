package com.philips.AlertToCare.repository;

import com.philips.AlertToCare.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {
    public Optional<Patient> findByPatientId(String patientId);
}