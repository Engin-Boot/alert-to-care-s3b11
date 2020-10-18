package com.philips.AlertToCare.service;

import com.philips.AlertToCare.entities.Device;
import com.philips.AlertToCare.repository.BedRepository;
import com.philips.AlertToCare.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public void createDevices(int bedCount, String clientId){
        for(int i=0; i<bedCount; i++){
            Device device = new Device(Integer.toString(4220+i), Integer.toString(i+1), 0, 0, 0);
            deviceRepository.save(device);
        }
    }

    public String getDeviceIdForBedId(String bedId){
        List<Device> devices = deviceRepository.findByBedId(bedId);
        return devices.get(0).getDeviceId();
    }

    public void createNewDevice(String deviceId, String bedId){
        Device device = new Device(deviceId, bedId, 0, 0, 0);
        deviceRepository.save(device);
    }

    public void makeBedIdNullForRemovedDevice(String bedId){
        List<Device> devices = deviceRepository.findByBedId(bedId);
        devices.get(0).setBedId("null");
        deviceRepository.save(devices.get(0));
    }
}
