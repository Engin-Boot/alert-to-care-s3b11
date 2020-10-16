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

    /*public void save(Bed bed) {
        bedRepository.save(bed);
    }*/

    public void createBeds(int bedCount, String clientId){
        for(int i=0; i<bedCount; i++){
            Bed bed = new Bed(Integer.toString(i+1), clientId, "Vacant" );
            bedRepository.save(bed);
        }
    }

    public boolean isBedVacant(Optional<Bed> bed){
        System.out.println("enter isbedvacant");
        //System.out.println(bed.get());
        if(bed.get().getBedStatus().equals("Vacant")){
            return true;
        }
        System.out.println("false");
        return false;
    }

    public Bed changeBedStatusWhenPatientIsAdmitted(String bedId) throws BedNotEmptyException {
        Optional<Bed> bed = bedRepository.findById(bedId);
        System.out.println("bedid ->" + bedId);
        System.out.println(bed);
        System.out.println(bed.get());
        if(isBedVacant(bed)){
                bed.get().setBedStatus("Occupied");
                bedRepository.save(bed.get());
            }
        else{
                throw new BedNotEmptyException( bedId + " is already occupied");
            }
        return bed.get();
    }

    /*public Map<String,String> getAllBedStatusByClientId(String client_id) throws BedDoesNotExistException {
        Map<String, String> allBedStatus = new HashMap<>();
        List<Bed> beds = bedRepository.findByClientId(client_id);
        if(beds.isEmpty()){
            throw new BedDoesNotExistException("Beds does not exist for clientId= "+client_id);
        }
        for(Bed bed: beds){
            allBedStatus.put(bed.getBed_id(), bed.getBedStatus().toString());
        }
        return allBedStatus;
    }*/

    public void changeBedStatusWhenPatientDischarged(String bedId){
        Bed bed = bedRepository.findById(bedId).get();
        bed.setBedStatus("Vacant");
        bedRepository.save(bed);
    }


}