package com.philips.AlertToCare.entities;
import javax.persistence.*;

@Entity
public class Device {
    @Id
    private String deviceId;
    private String bedId;
    private String spo2;
    private String respRate;
    private String bpm;

    public Device(){}

    public Device(String deviceId, String bedId, String spo2, String respRate, String bpm) {
        this.deviceId = deviceId;
        this.bedId = bedId;
        this.spo2 = spo2;
        this.respRate = respRate;
        this.bpm=bpm;
    }

    public String getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getBedId() {
        return bedId;
    }
    public void setBedId(String bedId) {
        this.bedId = bedId;
    }

    public String getSpo2() {
        return spo2;
    }
    public void setSpo2(String spo2) {
        this.spo2 = spo2;
    }

    public String getRespRate() {
        return respRate;
    }
    public void setRespRate(String respRate) {
        this.respRate = respRate;
    }

    public String getBpm() {
        return bpm;
    }
    public void setBpm(String bpm) {
        this.bpm = bpm;
    }

}
