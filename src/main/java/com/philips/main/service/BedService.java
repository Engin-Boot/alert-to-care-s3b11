package com.philips.main.service;

import com.philips.main.entities.Bed;
import com.philips.main.repository.JpaBedDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BedService {
	
	@Autowired
    JpaBedDao bedRepo;
	
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