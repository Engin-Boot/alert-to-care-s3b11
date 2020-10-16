package com.philips.AlertToCare.service;

import com.philips.AlertToCare.entities.Client;
import com.philips.AlertToCare.exceptions.ClientAlreadyExistsException;
import com.philips.AlertToCare.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ClientService {
    ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public Client configureClient(Client client) throws ClientAlreadyExistsException {
        String clientId = UUID.randomUUID().toString();
        client.setClientId(clientId);
        //if(clientRepository.findById(clientId).isPresent()){
        List<Client> allClients = getAllClients();
        if(allClients.size()==1){
            throw new ClientAlreadyExistsException("Client already exists");
        }
        return clientRepository.save(client);
    }

    public List<Client> getAllClients(){
        List<Client> allClients = clientRepository.findAll();
        return allClients;
    }
}
