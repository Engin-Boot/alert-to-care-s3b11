package com.philips.AlertToCare.service;

import com.philips.AlertToCare.entities.Device;
import com.philips.AlertToCare.repository.JpaDeviceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

	@Autowired
	JpaDeviceDao deviceDao;
	
    private static final int MINSPO2 = 90;
    private static final int MAXSPO2 = 100;
    private static final int MINRESPRATE = 70;
    private static final int MAXRESPRATE = 110;
    private static final int MINBPM = 80;
    private static final int MAXBPM = 120;

    public String isSpo2InRange(int spo2){
        if(spo2 < MINSPO2)
        {
            return "low";
        }
        else if(spo2 > MAXSPO2) {
        	return "high";
        }
        else{
            return "normal";
        }
    }

    public String isRespRateInRange(int respRate){
        if(respRate < MINRESPRATE)
        {
            return "low";
        }
        else if(respRate > MAXRESPRATE) {
        	return "high";
        }
        else{
            return "normal";
        }
    }
    public String isBpmInRange(int bpm){
        if(bpm < MINBPM)
        {
            return "low";
        }
        else if(bpm > MAXBPM) {
        	return "high";
        }
        else{
            return "normal";
        }
    }
    
    public void addNewDevice(Device deviceEntity){
        deviceDao.addDevice(deviceEntity);
    }
    
    public List<Device> getAllDevices(){
        return deviceDao.findAllDevices();
    }
    
    public int getBedIdFromDeviceId(int deviceId) {
    	List<Integer> result = deviceDao.findBedIdFromDeviceId(deviceId);
    	return result.get(0);
    }
}
