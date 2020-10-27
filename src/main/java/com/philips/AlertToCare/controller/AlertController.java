package com.philips.AlertToCare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.philips.AlertToCare.entities.Alert;
import com.philips.AlertToCare.entities.Device;
import com.philips.AlertToCare.service.AlertService;

@RestController
public class AlertController {
	
	@Autowired
    private AlertService alertService;

    @PostMapping("/alerts/{deviceId}")
    public ResponseEntity<List<Alert>> alertDispatcher(@PathVariable("deviceId") int deviceId, @RequestBody Device device) {
        List<Alert> alerts = alertService.checkVitals(deviceId, device);
        return new ResponseEntity<List<Alert>>(alerts, HttpStatus.CREATED);
    }

    @GetMapping("/alerts/{deviceId}")
    public ResponseEntity<List<Alert>> getAllAlerts(@PathVariable("deviceId") int deviceId){
        List<Alert> allAlerts = alertService.getAllAlerts(deviceId);
        return new ResponseEntity<List<Alert>>(allAlerts, HttpStatus.OK);
    }

	public void setAlertService(AlertService as) {
		
		
	}

}
