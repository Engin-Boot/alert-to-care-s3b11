package com.philips.AlertToCare.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alert {
    @Id
    private String alertId;
    private String deviceId;
    private String bedId;
    private String errorType;
    private int errorValue;

    public Alert(){}

    public Alert(String alertId, String deviceId, String bedId, String errorType,int errorValue)
    {
        this.alertId=alertId;
        this.deviceId=deviceId;
        this.bedId=bedId;
        this.errorType=errorType;
        this.errorValue=errorValue;
    }

    public String getAlertId(){return alertId;}
    public void setAlertId(String alertId){
        this.alertId=alertId;
    }
    public String getDeviceId(){return deviceId;}
    public void setDeviceId(String deviceId){
        this.deviceId=deviceId;
    }
    public String getBedId(){return bedId;}
    public void setBedId(String bedId){
        this.bedId=bedId;
    }
    public String getErrorType(){return errorType;}
    public void setErrorType(String errorType){
        this.errorType=errorType;
    }
    public int getErrorValue(){return errorValue;}
    public void setErrorValue(int errorValue){
        this.errorValue=errorValue;
    }
}
