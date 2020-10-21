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
@Table(name = "patient_info")
public class Patient {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_Id")
    private String patientId;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "age")
    private int age;
    
    @OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="bed_Id")
	Bed bed;

    Patient() {
    	
    }

	public Patient(String patientId, String name, int age, Bed bed) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.age = age;
		this.bed = bed;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
	    return "Patient [ patientId=" + patientId + ", name=" + name + ", age=" + age + "]";
	}
    

}

