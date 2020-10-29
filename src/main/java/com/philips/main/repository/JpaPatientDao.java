package com.philips.main.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.philips.main.entities.Patient;
import com.philips.main.utils.GenericUtils;

@Transactional
@Repository
public class JpaPatientDao{
	
	@PersistenceContext
	EntityManager eManager;
	
	public List<Patient> findAllPatients(){
		return GenericUtils.castList(Patient.class, eManager.createQuery("SELECT p from Patient p").getResultList());
	}
	
	public Patient findPatientById(int patientId){
		return eManager.find(Patient.class, patientId); 
	}
	
	public Patient addNewPatient(Patient patient) {
		eManager.persist(patient);
		return patient;
	}
	
	public Patient findPatientByBedId(int bedId) {
		List<Patient> patients = GenericUtils.castList(Patient.class, eManager.createQuery("Select p from Patient as p join Bed as b on p.bed.bedId=b.bedId where b.bedId = :paramId").setParameter("paramId", bedId).getResultList());
		return patients.get(0);
	}
	
	public void deletePatient(int patientId) {
		eManager.createQuery("DELETE from Patient WHERE patient_Id = :paramId").setParameter("paramId", patientId).executeUpdate();
	}
}