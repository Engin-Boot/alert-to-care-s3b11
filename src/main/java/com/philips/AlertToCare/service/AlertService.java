package com.philips.AlertToCare.service;

import com.philips.AlertToCare.entities.Alert;
import com.philips.AlertToCare.entities.Device;
import com.philips.AlertToCare.repository.JpaAlertDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AlertService {
    JpaAlertDao alertDao;

    @Autowired
    public AlertService(JpaAlertDao alertDao) {
        this.alertDao =alertDao;
    }

    @Autowired
    private DeviceService deviceService;

    public List<Alert> checkVitals(Device device)
    {
        List<Alert> alerts = new ArrayList<Alert>();

        alerts.add(checkIsSpo2InRange(device));
        alerts.add(checkIsRespRateInRange(device));
        alerts.add(checkIsBpmInRange(device));
        return alerts;
    }

    private Alert checkIsSpo2InRange(Device device){
        Alert alert = null;
        if(!deviceService.isSpo2InRange(device.getSpo2())){
            alert = new Alert(UUID.randomUUID().toString(), device.getDeviceId(), device.getBedId(),"spo2", device.getSpo2());
            alertDao.addAlert(alert);
        }
        return alert;
    }

    private Alert checkIsRespRateInRange(Device device){
        Alert alert = null;
        if(!deviceService.isRespRateInRange(device.getRespRate())){
            alert = new Alert(UUID.randomUUID().toString(), device.getDeviceId(), device.getBedId(),"respRate", device.getRespRate());
            alertDao.addAlert(alert);
        }
        return alert;
    }

    private Alert checkIsBpmInRange(Device device){
        Alert alert = null;
        if(!deviceService.isBpmInRange(device.getBpm())){
            alert = new Alert(UUID.randomUUID().toString(), device.getDeviceId(), device.getBedId(),"bpm", device.getBpm());
            alertDao.addAlert(alert);
        }
        return alert;
    }

    public List<Alert> getAllAlerts(){
        return alertDao.findAllAlerts();
    }
}
