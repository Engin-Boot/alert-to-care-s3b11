package com.philips.main.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bed_info")
public class Bed{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bed_Id")
    private int bedId;
    
    @Column(name = "bed_Status")
    private boolean bedStatus;

    
    @OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="device_Id")
	Device device;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="icu_Id")
	Icu icu;
    
    public Bed(){
    	
    }

	public Bed(int bedId, boolean bedStatus, Device device, Icu icu) {
		super();
		this.bedId = bedId;
		this.bedStatus = bedStatus;
		this.device = device;
		this.icu = icu;
	}

	public int getBedId() {
		return bedId;
	}

	public void setBedId(int bedId) {
		this.bedId = bedId;
	}

	public boolean isBedStatus() {
		return bedStatus;
	}

	public void setBedStatus(boolean bedStatus) {
		this.bedStatus = bedStatus;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Icu getIcu() {
		return icu;
	}

	public void setIcu(Icu icu) {
		this.icu = icu;
	}
	
	@Override
	public String toString() {
	    return "Bed [ BedId=" + bedId + " , BedStatus=" + bedStatus +"]";
	}

	
}