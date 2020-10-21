package com.philips.AlertToCare.service;

import com.philips.AlertToCare.entities.Bed;
import com.philips.AlertToCare.repository.BedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BedService {
	
	@Autowired
    BedRepository bedRepo;
	
	public List<Bed> getAllBeds() {
		return bedRepo.findAllBeds();
	}
	
	public Bed getBedById(int bedid) {
		return bedRepo.findBedById(bedid);
	}

	public List<Bed> getBedByIcuNumber(int icuNumber) {
		return bedRepo.findBedsByIcuNumber(icuNumber);
	}
}