package com.philips.AlertToCare.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.philips.AlertToCare.entities.Device;
import com.philips.AlertToCare.utils.GenericUtils;

@Transactional
@Repository
public class JpaDeviceDao {

	@PersistenceContext
	private EntityManager em;
	
	
	public Device addDevice(Device DeviceEntity) {
		em.persist(DeviceEntity);
		return DeviceEntity;
	}
	
	public List<Device> findAllDevices() {

		return GenericUtils.castList(Device.class, em.createQuery("SELECT d FROM Device d").getResultList());
	}
	
	public Device findDeviceById(int DeviceId){
		
		return em.find(Device.class, DeviceId);
	}
	//findDeviceIdByBedId this will be in BedService or Dao Layer
	//makeBedIdNullForRemovedDevice 

	
}