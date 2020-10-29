package com.philips.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "device_info")
public class Device {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "device_Id")
	private int deviceId;
	
	@Column(name = "spo2")
	private int spo2;
	
	@Column(name = "resp_Rate")
	private int respRate;
	
	@Column(name = "bpm")
	private int bpm;
	
	public Device() {
		
	}
	
	public Device(int deviceId, int spo2, int respRate, int bpm) {
		super();
		this.deviceId = deviceId;
		this.spo2 = spo2;
		this.respRate = respRate;
		this.bpm = bpm;
	}
	
	public int getDeviceId() {
		return deviceId;
	}
	
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	
	public int getSpo2() {
		return spo2;
	}
	
	public void setSpo2(int spo2) {
		this.spo2 = spo2;
	}
	
	public int getRespRate() {
		return respRate;
	}
	
	public void setRespRate(int respRate) {
		this.respRate = respRate;
	}
	
	public int getBpm() {
		return bpm;
	}
	
	public void setBpm(int bpm) {
		this.bpm = bpm;
	}
	
	
	
	
}
	