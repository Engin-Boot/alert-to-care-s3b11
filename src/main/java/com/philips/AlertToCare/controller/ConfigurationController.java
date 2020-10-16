package com.philips.AlertToCare.controller;

import com.philips.AlertToCare.entities.Client;
import com.philips.AlertToCare.exceptions.ClientAlreadyExistsException;
import com.philips.AlertToCare.service.BedService;
import com.philips.AlertToCare.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ConfigurationController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private BedService bedService;

    @PostMapping("/client/config")
    public ResponseEntity<Client> configureClient(@RequestBody Client client) throws ClientAlreadyExistsException {
        Client configuredClient = clientService.configureClient(client);
        System.out.println("configuring client");
        bedService.createBeds(client.getNoOfBeds(), client.getClientId());
        System.out.println("saving beds");
        return new ResponseEntity<Client>(configuredClient, HttpStatus.CREATED);
    }

    @GetMapping("/client/allClients")
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> allClients = clientService.getAllClients();
        return new ResponseEntity<List<Client>>(allClients, HttpStatus.OK);
    }
}
