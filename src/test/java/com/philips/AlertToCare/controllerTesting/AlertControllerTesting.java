package com.philips.AlertToCare.controllerTesting;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.philips.AlertToCare.controller.AlertController;
import com.philips.AlertToCare.entities.Alert;
import com.philips.AlertToCare.entities.Device;
import com.philips.AlertToCare.service.AlertService;


public class AlertControllerTesting {

	@Test
    public void addNewAlertInfoTest() {
        Alert alert = new Alert();
        Device device = new Device();
        alert.setAlertId(1);
        AlertService as = Mockito.mock(AlertService.class);
        Mockito.when(((OngoingStubbing) as.checkVitals(device.getDeviceId(),(Mockito.any(Device.class)))).thenReturn(alert));
        AlertController ac = new AlertController();
        ac.setAlertService(as);

        ResponseEntity<List<Alert>> response = ac.alertDispatcher(1, device);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("alerts/1", response.getHeaders().getLocation().toString());
    }

    @Test
    public void getAllAlerts() {
    	Device device = new Device();
        AlertService as = (AlertService) Mockito.mock(AlertService.class);
        Mockito.when(as.getAllAlerts(device.getDeviceId())).thenReturn(null);
        AlertController ac = new AlertController();
        ac.setAlertService(as);

        ResponseEntity<List<Alert>> response = ac.getAllAlerts(device.getDeviceId());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(0, response.getBody().size());
    }
	
	
}
