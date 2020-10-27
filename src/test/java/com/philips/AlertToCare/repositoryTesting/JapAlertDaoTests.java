package com.philips.AlertToCare.repositoryTesting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.philips.AlertToCare.entities.Alert;
import com.philips.AlertToCare.entities.Bed;
import com.philips.AlertToCare.repository.JpaAlertDao;




@RunWith(SpringRunner.class)
@DataJpaTest
@Import(value = {JpaAlertDao.class })
public class JapAlertDaoTests{

		
		@Autowired
		private TestEntityManager entityManager;
		
		@Autowired
		private JpaAlertDao alertDao;
		
		
		@Test
		public void testAddAlert() {
			Alert newAlert = getAlert();
			Alert savedInDb = alertDao.addNewAlert(newAlert);
			
			Alert getFromDb = entityManager.find(Alert.class, newAlert.getAlertId());
		
			assertThat(getFromDb.getAlertId()).isEqualTo(1);
			assertThat(getFromDb.getErrorMessage()).isEqualTo("vital is Normal");
			assertThat(getFromDb).isEqualTo(savedInDb);
			
		}
		
		@Test
		public void testViewAllAlertInfo() {
			
			Alert newAlert = getAlert();
			Alert savedInDb = entityManager.persist(newAlert);
			
			List<Alert> getFromDb = alertDao.findAllAlerts(1);
		
			assertThat(getFromDb.get(0).getAlertId()).isEqualTo(1);
			assertThat(getFromDb.get(0).getErrorMessage()).isEqualTo("vital is Normal");
			assertThat(getFromDb.get(0)).isEqualTo(savedInDb);
			
		}	

		private Alert getAlert() {
			Bed bed = new Bed();
			Alert alert = new Alert();
			alert.setAlertId(1);
			alert.setBed(bed);
			bed.setBedId(1);
			alert.setErrorMessage("vital is Normal");
			entityManager.persist(alert);
			entityManager.persist(bed);
			return alert;
			
		}
}
