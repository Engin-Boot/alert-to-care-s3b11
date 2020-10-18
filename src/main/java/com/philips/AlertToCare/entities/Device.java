package com.philips.AlertToCare.entities;
import javax.persistence.*;

@Entity
public class Device {
    @Id
    private String deviceId;
    private String bedId;
    private int spo2;
    private int respRate;
    private int bpm;

    public Device(){}

    public Device(String deviceId, String bedId, int spo2,int respRate, int bpm) {
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
