package com.philips.AlertToCare.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Alert_info")
public class Alert {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alert_Id")
    private int alertId;
    
	@Column(name = "bed_Id")
    private int bedId;
	
	@Column(name = "error_Message")
    private String errorMessage;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="bed_Id")
	Bed bed;
    
    public Alert(){
    	
    }

	public Alert(int alertId, int bedId, String errorMessage, Bed bed) {
		super();
		this.alertId = alertId;
		this.bedId = bedId;
		this.errorMessage = errorMessage;
		this.bed = bed;
	}

	public int getAlertId() {
		return alertId;
	}

	public void setAlertId(int alertId) {
		this.alertId = alertId;
	}

	public int getBedId() {
		return bedId;
	}

	public void setBedId(int bedId) {
		this.bedId = bedId;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Bed getBed() {
		return bed;
	}

	public void setBed(Bed bed) {
		if(bed != null) {
			this.bed = bed; 
			this.bed.setBedStatus(false);
	    }
	}
	
	public void freeBed(Bed bed) {
		if(bed != null) {
			this.bed = bed; 
	        this.bed.setBedStatus(true);
	    }
	}
    
	@Override
	public String toString() {
	    return "Alert [ AlertId=" + alertId + ", bedId=" + bedId + ", errorMessage=" + errorMessage +"]";
	}
    

    
    

}