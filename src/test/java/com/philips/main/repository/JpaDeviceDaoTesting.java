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

import com.philips.main.entities.Device;
import com.philips.main.repository.JpaDeviceDao;


@RunWith(SpringRunner.class)
@DataJpaTest
@Import(value = {JpaDeviceDao.class})

public class JpaDeviceDaoTesting {
		
		@Autowired
		private TestEntityManager entityManager;
		
		@Autowired
		private JpaDeviceDao deviceDao;
		
		
		@Test
		public void testAddDevice() {
			Device newDevice = getFirstDevice();
			
			Device addInDb = deviceDao.addDevice(newDevice);
			Device getFromDb = entityManager.find(Device.class, newDevice.getDeviceId());
			
			assertThat(getFromDb.getBpm()).isEqualTo(100);
			assertThat(getFromDb.getDeviceId()).isEqualTo(1);
			assertThat(getFromDb.getSpo2()).isEqualTo(70);
			assertThat(getFromDb.getRespRate()).isEqualTo(100);
			assertThat(getFromDb).isEqualTo(addInDb);
		}
		
		
		@Test
		public void testFindDeviceById() {
			Device newDevice = getSecondDevice();
			
			Device savedInDb = entityManager.persist(newDevice);
			Device getFromDb = deviceDao.findDeviceById(savedInDb.getDeviceId());
			
			assertThat(getFromDb).isEqualTo(savedInDb);
		}
		
		@Test
		public void testFindAllDevices() {
			List<Device> allDevice = new ArrayList<>();
			
			Device firstDevice = getFirstDevice();
			Device secondDevice = getSecondDevice();
			
			Device saveFirstDevice = entityManager.persist(firstDevice);
			Device saveSecondDevice = entityManager.persist(secondDevice);
			
			allDevice = deviceDao.findAllDevices();
			
			assertThat(allDevice.get(0)).isEqualTo(saveFirstDevice);
			assertThat(allDevice.get(1)).isEqualTo(saveSecondDevice);
			assertThat(allDevice.get(0).getDeviceId()).isEqualTo(1);
			assertThat(allDevice.get(1).getDeviceId()).isEqualTo(2);
		}
		
		private Device getFirstDevice() {
			Device device = new Device();
			device.setBpm(100);
			device.setDeviceId(1);
			device.setRespRate(70);
			device.setSpo2(100);
			entityManager.persist(device);
			return device;
			
		}
		
		private Device getSecondDevice() {
			Device device = new Device();
			device.setBpm(100);
			device.setDeviceId(1);
			device.setRespRate(70);
			device.setSpo2(100);
			entityManager.persist(device);
			return device;
			
		}
}
