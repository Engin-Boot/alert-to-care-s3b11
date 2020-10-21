package com.philips.AlertToCare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.AlertToCare.entities.Icu;
import com.philips.AlertToCare.repository.JpaIcuDao;

@Service
public class IcuService {
	
	@Autowired
	JpaIcuDao icuDao;
	
	public List<Icu> getAllIcus(){
		return icuDao.findAll();
	}
}
