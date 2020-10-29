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
import com.philips.main.entities.Device;
import com.philips.main.entities.Icu;
import com.philips.main.repository.JpaBedDao;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(value = { JpaBedDao.class })
	
public class JpaBedDaoTesting {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private JpaBedDao bedDao;

	
	@Test
	public void testFindBed() {
		Bed newBed = getFirstBed();
		
		Bed savedInDb = entityManager.persist(newBed);
		Bed getFromDb = bedDao.findBedById(savedInDb.getBedId());
		
		assertThat(getFromDb).isEqualTo(savedInDb);
	}
	
	@Test
	public void testFindAllBeds() {
		List<Bed> allBeds = new ArrayList<>();
		
		Bed firstBed = getFirstBed();
		Bed secondBed = getSecondBed();
		
		Bed saveFirstBed = entityManager.persist(firstBed);
		Bed saveSecondBed = entityManager.persist(secondBed);
		
		allBeds = bedDao.findAllBeds();
		
		assertThat(allBeds.get(0)).isEqualTo(saveFirstBed);
		assertThat(allBeds.get(1)).isEqualTo(saveSecondBed);
		assertThat(allBeds.get(0).getBedId()).isEqualTo(1);
		assertThat(allBeds.get(1).getBedId()).isEqualTo(2);
	}
	
	private Bed getFirstBed() {
		Bed bed = new Bed();
		Device device = new Device();
		Icu icu = new Icu();
		bed.setBedId(1);
		device.setDeviceId(1);
		bed.setDevice(device);
		icu.setIcuId(1);
		bed.setIcu(icu);
		bed.setBedStatus(true);
		entityManager.persist(icu);
		entityManager.persist(device);
		entityManager.persist(bed);
		return bed;
		
	}	
	

	private Bed getSecondBed() {
		Bed bed = new Bed();
		Device device = new Device();
		Icu icu = new Icu();
		bed.setBedId(2);
		device.setDeviceId(2);
		bed.setDevice(device);
		icu.setIcuId(2);
		bed.setIcu(icu);
		bed.setBedStatus(true);
		entityManager.persist(icu);
		entityManager.persist(device);
		entityManager.persist(bed);
		return bed;
		
	}	

}
