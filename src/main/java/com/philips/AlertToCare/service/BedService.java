package com.philips.AlertToCare.service;

import com.philips.AlertToCare.entities.Bed;
import com.philips.AlertToCare.exceptions.*;
import com.philips.AlertToCare.repository.BedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BedService {
    BedRepository bedRepository;

    @Autowired
    public BedService(BedRepository bedRepository) {
        this.bedRepository = bedRepository;
    }

    @Autowired
    private DeviceService deviceService;


    public void createBeds(int bedCount, String clientId){
        for(int i=0; i<bedCount; i++){
            Bed bed = new Bed(Integer.toString(i+1), deviceService.getDeviceIdForBedId(Integer.toString(i+1)), clientId, "Vacant" );
            bedRepository.save(bed);
        }
    }

    public boolean isBedVacant(Optional<Bed> bed){
        if(bed.get().getBedStatus().equals("Vacant")){
            return true;
        }
        return false;
    }

    public Bed changeBedStatusWhenPatientIsAdmitted(String bedId) throws BedNotEmptyException {
        Optional<Bed> bed = bedRepository.findById(bedId);
        if(isBedVacant(bed)){
                bed.get().setBedStatus("Occupied");
                bedRepository.save(bed.get());
            }
        else{
                throw new BedNotEmptyException( bedId + " is already occupied");
            }
        return bed.get();
    }

    public void changeBedStatusWhenPatientDischarged(String bedId){
        Bed bed = bedRepository.findById(bedId).get();
        bed.setBedStatus("Vacant");
        bedRepository.save(bed);
    }

    public void updateDeviceForABed(String bedId, String newDeviceId)
    {
        deviceService.makeBedIdNullForRemovedDevice(bedId);
        deviceService.createNewDevice(newDeviceId, bedId);
        Bed bed = bedRepository.findById(bedId).get();
        bed.setDeviceId(newDeviceId);
        bedRepository.save(bed);
    }

    public Bed getBedDetails(String bedId){
        return bedRepository.findById(bedId).get();
    }

    public List<Bed> getAllBeds(){
        return bedRepository.findAll();
    }
}