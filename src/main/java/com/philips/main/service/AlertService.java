package com.philips.main.service;

import com.philips.main.entities.Alert;
import com.philips.main.entities.Bed;
import com.philips.main.entities.Device;
import com.philips.main.repository.JpaAlertDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlertService {
    
	@Autowired
	JpaAlertDao alertDao;
	
	@Autowired
	private BedService bedService;

    @Autowired
    private DeviceService deviceService;

    public List<Alert> checkVitals(int deviceId, Device device)
    {
        List<Alert> alerts = new ArrayList<>();
        int bedId = deviceService.getBedIdFromDeviceId(deviceId);

        alerts.add(checkIsSpo2InRange(device.getSpo2(), bedId));
        alerts.add(checkIsRespRateInRange(device.getRespRate(), bedId));
        alerts.add(checkIsBpmInRange(device.getBpm(), bedId));
        return alerts;
    }

    private Alert checkIsSpo2InRange(int spo2, int bedId){
        Alert alert = new Alert();
        Bed bed = bedService.getBedById(bedId);
        String status = deviceService.isSpo2InRange(spo2);
    	alert.setBed(bed);
    	alert.setErrorMessage("spo2 is " + status);
        alertDao.addNewAlert(alert);
        return alert;
    }

    private Alert checkIsRespRateInRange(int respRate, int bedId){
        Alert alert = new Alert();
        Bed bed = bedService.getBedById(bedId);
        String status = deviceService.isRespRateInRange(respRate);
        alert.setBed(bed);
    	alert.setErrorMessage("respRate is " + status);
        alertDao.addNewAlert(alert);
        return alert;
    }

    private Alert checkIsBpmInRange(int bpm, int bedId){
    	Alert alert = new Alert();
        Bed bed = bedService.getBedById(bedId);
        String status = deviceService.isBpmInRange(bpm);
		alert.setBed(bed);
    	alert.setErrorMessage("bpm is " + status);
        alertDao.addNewAlert(alert);
        return alert;
    }

    public List<Alert> getAllAlerts(int deviceId){
    	int bedId = deviceService.getBedIdFromDeviceId(deviceId);
        return alertDao.findAllAlerts(bedId);
    }
}
