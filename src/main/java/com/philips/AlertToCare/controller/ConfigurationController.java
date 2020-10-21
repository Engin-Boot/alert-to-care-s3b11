package com.philips.AlertToCare.controller;

import com.philips.AlertToCare.entities.Bed;
import com.philips.AlertToCare.entities.Device;
import com.philips.AlertToCare.exceptions.ClientAlreadyExistsException;
import com.philips.AlertToCare.service.BedService;
import com.philips.AlertToCare.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ConfigurationController {

    /*@Autowired
    private ClientService clientService;

    @Autowired
    private BedService bedService;

    @Autowired
    private DeviceService deviceService;

    @PostMapping("/client/config")
    public ResponseEntity<Client> configureClient(@RequestBody Client client) throws ClientAlreadyExistsException {
        Client configuredClient = clientService.configureClient(client);
        deviceService.createDevices(client.getNoOfBeds(), client.getClientId());
        bedService.createBeds(client.getNoOfBeds(), client.getClientId());
        return new ResponseEntity<Client>(configuredClient, HttpStatus.CREATED);
    }

    @GetMapping("/client/allClients")
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> allClients = clientService.getAllClients();
        return new ResponseEntity<List<Client>>(allClients, HttpStatus.OK);
    }

    @PostMapping("client/config/changeDevice")
    public ResponseEntity<Bed> changeDevice(@RequestBody List<String> bedIdAndNewDeviceId){
        bedService.updateDeviceForABed(bedIdAndNewDeviceId.get(0), bedIdAndNewDeviceId.get(1));
        return new ResponseEntity<Bed>(bedService.getBedDetails(bedIdAndNewDeviceId.get(0)), HttpStatus.OK);
    }

    @GetMapping("/client/allBeds")
    public ResponseEntity<List<Bed>> getAllBeds(){
        List<Bed> allBeds = bedService.getAllBeds();
        return new ResponseEntity<List<Bed>>(allBeds, HttpStatus.OK);
    }

    @GetMapping("/client/allDevices")
    public ResponseEntity<List<Device>> getAllDevices(){
        return new ResponseEntity<List<Device>>(deviceService.getAllDevices(), HttpStatus.OK);
    }*/
}
