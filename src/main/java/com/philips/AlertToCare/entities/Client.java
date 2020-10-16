package com.philips.AlertToCare.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Client {
    @Id
    private String clientId;
    private String layout;
    private int noOfBeds;
    private HashMap<String, String> bedDeviceMapping;


    public String getClientId() {
        return clientId;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getLayout() {
        return layout;
    }
    public void setLayout(String layout) {
        this.layout = layout;
    }
    public int getNoOfBeds() {
        return noOfBeds;
    }
    public void setNoOfBeds(int noOfBeds) {
        this.noOfBeds = noOfBeds;
    }
    public HashMap<String, String> getBedDeviceMapping(){
        return bedDeviceMapping;
    }
    public void setBedDeviceMapping(HashMap<String, String> bedDeviceMapping)
    {
        this.bedDeviceMapping = bedDeviceMapping;
    }
}
