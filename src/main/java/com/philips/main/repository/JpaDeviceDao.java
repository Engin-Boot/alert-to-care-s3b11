package com.philips.main.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.philips.main.entities.Device;
import com.philips.main.utils.GenericUtils;

@Transactional
@Repository
public class JpaDeviceDao {

	@PersistenceContext
	private EntityManager eManager;
	
	
	public Device addDevice(Device device) {
		eManager.persist(device);
		return device;
	}
	
	public List<Device> findAllDevices() {
		return GenericUtils.castList(Device.class, eManager.createQuery("SELECT d FROM Device d").getResultList());
	}
	
	public Device findDeviceById(int deviceId){
		return eManager.find(Device.class, deviceId);
	}
	
	public List<Integer> findBedIdFromDeviceId(int deviceId) {
		
		 return GenericUtils.castList(Integer.class, eManager.createQuery("Select b.bedId from Bed b inner join Device d on b.device.deviceId = d.deviceId where b.device.deviceId = :paramId").setParameter("paramId", deviceId).getResultList());
	}
	
}