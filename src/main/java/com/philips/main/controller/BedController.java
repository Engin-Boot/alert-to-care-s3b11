package com.philips.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.philips.main.entities.Bed;
import com.philips.main.service.BedService;

@RestController
public class BedController {

	@Autowired
	BedService bedService;
	
	@GetMapping("/beds")
	public ResponseEntity<List<Bed>> getAllBeds() {
		List<Bed> beds = bedService.getAllBeds();
		if (beds == null) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
		}
		return new ResponseEntity<>(beds, HttpStatus.OK);

	}

	@GetMapping("/beds/{bedId}")
	public ResponseEntity<Bed> getBedByBedId(@PathVariable("bedId") int bid) {
		Bed bed = bedService.getBedById(bid);

		if (bed != null) {
			return new ResponseEntity<>(bed, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/beds/icu/{icuId}")
	public ResponseEntity<List<Bed>> viewByAvailability(@PathVariable("icuId") int icuNumber) {
		List<Bed> beds = bedService.getBedByIcuNumber(icuNumber);
		if (beds == null) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
		}
		return new ResponseEntity<>(beds, HttpStatus.OK);

	}

	public void setBedService(BedService bs) {
	
		
	}
}
