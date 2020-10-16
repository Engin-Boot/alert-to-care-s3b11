package com.philips.AlertToCare.entities;

import javax.persistence.*;

@Entity
public class Patient {
    @Id
    private String patientId;
    private String name;
    private String bedId;

    @Enumerated(EnumType.STRING)
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

    public String getBedId() {
        return bedId;
    }
    public void setBedId(String bedId) {
        this.bedId = bedId;
    }
}
