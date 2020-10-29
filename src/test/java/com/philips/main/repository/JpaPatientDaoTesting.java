package com.philips.main.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.philips.main.entities.Bed;
import com.philips.main.entities.Patient;
import com.philips.main.repository.JpaPatientDao;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(value = { JpaPatientDao.class })


public class JpaPatientDaoTesting {

	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private JpaPatientDao patientDao;
	
	
	@Test
	public void testAddPatient() {
		Patient newPatient = getFirstPatient();
		
		Patient addInDb = patientDao.addNewPatient(newPatient);
		Patient getFromDb = entityManager.find(Patient.class, newPatient.getPatientId());
		
		assertThat(getFromDb.getAge()).isEqualTo(23);
		assertThat(getFromDb.getName()).isEqualTo("Ravikumar Tiwari");
		assertThat(getFromDb).isEqualTo(addInDb);
	}
	
	
	@Test
	public void testFindPatientById() {
		Patient newPatient = getFirstPatient();
		
		Patient savedInDb = entityManager.persist(newPatient);
		Patient getFromDb = patientDao.findPatientById(savedInDb.getPatientId());
		
		assertThat(getFromDb).isEqualTo(savedInDb);
	}
	
	@Test
	public void testFindAllPatient() {
		List<Patient> allPatients = new ArrayList<>();
		
		Patient firstPatient = getFirstPatient();
		Patient secondPatient = getSecondPatient();
		
		Patient saveFirstPatient = entityManager.persist(firstPatient);
		Patient saveSecondPatient = entityManager.persist(secondPatient);
		
		allPatients = patientDao.findAllPatients();
		
		assertThat(allPatients.get(0)).isEqualTo(saveFirstPatient);
		assertThat(allPatients.get(1)).isEqualTo(saveSecondPatient);
		assertThat(allPatients.get(0).getName()).isEqualTo("Ravikumar Tiwari");
		assertThat(allPatients.get(1).getName()).isEqualTo("Ram Vaishnav");
	}
	
	private Patient getFirstPatient() {
		Patient patient1 = new Patient();
		
		patient1.setName("Ravikumar Tiwari");
		patient1.setAge(23);
		patient1.setBed(getBedForFirstPatient());
		
		return patient1;
	}
	
	private Patient getSecondPatient() {
		Patient patient2 = new Patient();
		
		patient2.setName("Ram Vaishnav");
		patient2.setAge(25);
		patient2.setBed(getBedForSecondPatient());
		
		return patient2;
	}
	
	private Bed getBedForFirstPatient() {
		Bed bed1 = new Bed();
		
		bed1.setBedId(1);
		bed1.setBedStatus(true);
		entityManager.persist(bed1);
		
		return bed1;
	}
	
	private Bed getBedForSecondPatient() {
		Bed bed2 = new Bed();
		
		bed2.setBedId(2);
		bed2.setBedStatus(true);
		entityManager.persist(bed2);
		
		return bed2;
	}

	
	
}
