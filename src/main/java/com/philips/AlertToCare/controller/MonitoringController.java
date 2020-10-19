package com.philips.AlertToCare.controller;

import com.philips.AlertToCare.entities.Alert;
import com.philips.AlertToCare.entities.Device;
import com.philips.AlertToCare.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class MonitoringController {

    @Autowired
    private AlertService alertService;

    @PostMapping("/client/monitor/{deviceId}")
    public ResponseEntity<List<Alert>> alertDispatcher(@RequestBody Device device) {
        List<Alert> alerts = alertService.checkVitals(device);
        if (alerts.size()==0){
            return new ResponseEntity<List<Alert>>(alerts, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<Alert>>(alerts, HttpStatus.CREATED);
        }
    }
}
