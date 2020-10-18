package com.philips.AlertToCare.entities;
import javax.persistence.*;

@Entity
public class Bed{

    @Id
    private String bedId;
    private String deviceId;
    private String clientId;
    private String bedStatus;

    public Bed(){}

    public Bed(String bedId, String deviceId,String clientId, String bedStatus) {
        this.bedId = bedId;
        this.deviceId = deviceId;
        this.clientId = clientId;
        this.bedStatus = bedStatus;
    }

    public String getClientId() {
        return clientId;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getBedStatus() {
        return bedStatus;
    }
    public void setBedStatus(String bedStatus) {
        this.bedStatus = bedStatus;
    }
    public String getBedId() {
        return bedId;
    }
    public void setBedId(String bedId) {
        this.bedId = bedId;
    }

}