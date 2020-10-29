package com.philips.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.main.entities.Icu;
import com.philips.main.repository.JpaIcuDao;

@Service
public class IcuService {
	
	@Autowired
	JpaIcuDao icuDao;
	
	public List<Icu> getAllIcus(){
		return icuDao.findAll();
	}
}
