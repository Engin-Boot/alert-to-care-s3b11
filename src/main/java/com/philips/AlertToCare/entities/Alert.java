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
@Table(name = "alert_info")
public class Alert {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alert_Id")
    private int alertId;
	
	@Column(name = "error_Message")
    private String errorMessage;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="bed_Id")
	Bed bed;
    
    public Alert(){
    	
    }

	public Alert(int alertId, String errorMessage, Bed bed) {
		super();
		this.alertId = alertId;
		this.errorMessage = errorMessage;
		this.bed = bed;
	}

	public int getAlertId() {
		return alertId;
	}

	public void setAlertId(int alertId) {
		this.alertId = alertId;
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
	    }
	}
	
	public void freeBed(Bed bed) {
		if(bed != null) {
			this.bed = bed; 
	    }
	}
    
	@Override
	public String toString() {
	    return "Alert [ AlertId=" + alertId + ", errorMessage=" + errorMessage +"]";
	}
    

    
    

}