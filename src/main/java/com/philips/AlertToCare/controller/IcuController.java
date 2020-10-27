package com.philips.AlertToCare.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.philips.AlertToCare.entities.Icu;
import com.philips.AlertToCare.service.IcuService;

@RestController
public class IcuController {
	
	@Autowired
	IcuService icuService;
	
	@GetMapping("/icus")
	public ResponseEntity<List<Icu>> getAllIcus(){
		List<Icu> icus = icuService.getAllIcus();
		if(icus == null) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
		}
		return new ResponseEntity<>(icus, HttpStatus.OK);
	}

	public void setIcuService(IcuService is) {

		
	}
}
