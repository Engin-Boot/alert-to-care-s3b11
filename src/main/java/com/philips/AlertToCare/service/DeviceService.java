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
	
    private final int minSpo2 = 90;
    private final int maxSpo2 = 100;
    private final int minRespRate = 70;
    private final int maxRespRate = 110;
    private final int minBpm = 80;
    private final int maxBpm = 120;


    @Autowired
    public DeviceService(JpaDeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }


   /* public String getDeviceIdForBedId(String bedId){
        Device device = deviceRepository.findByBedId(bedId);
        return devices.get(0).getDeviceId();
    }*/

    public void createNewDevice(Device deviceEntity){
        deviceDao.addDevice(deviceEntity);
    }

    /*public void makeBedIdNullForRemovedDevice(String bedId){
        List<Device> devices = deviceRepository.findByBedId(bedId);
        devices.get(0).setBedId("null");
        deviceRepository.save(devices.get(0));
    }*/

    public boolean isSpo2InRange(int spo2){
        if (spo2>=minSpo2 && spo2<=maxSpo2)
        {
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isRespRateInRange(int respRate){
        if (respRate>=minRespRate && respRate<=maxRespRate)
        {
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isBpmInRange(int bpm){
        if (bpm>=minBpm && bpm<=maxBpm)
        {
            return true;
        }
        else{
            return false;
        }
    }

    public List<Device> getAllDevices(){
        return deviceDao.findAllDevices();
    }
}
