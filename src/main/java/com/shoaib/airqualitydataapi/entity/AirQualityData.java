package com.shoaib.airqualitydataapi.entity;

public class AirQualityData {

    public AirQualityData(Double groundLevelOzone, Double twoPointFivePM, Double tenPM, Double carbonMonoxide, Double sulfurDioxide, Double nitrogenDioxide) {
        this.groundLevelOzone = groundLevelOzone;
        this.twoPointFivePM = twoPointFivePM;
        this.tenPM = tenPM;
        this.carbonMonoxide = carbonMonoxide;
        this.sulfurDioxide = sulfurDioxide;
        this.nitrogenDioxide = nitrogenDioxide;
    }

    public long id;

    public Double groundLevelOzone;

    public Double twoPointFivePM;

    public Double tenPM;

    public Double carbonMonoxide;

    public Double sulfurDioxide;

    public Double nitrogenDioxide;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getGroundLevelOzone() {
        return groundLevelOzone;
    }

    public void setGroundLevelOzone(Double groundLevelOzone) {
        this.groundLevelOzone = groundLevelOzone;
    }

    public Double getTwoPointFivePM() {
        return twoPointFivePM;
    }

    public void setTwoPointFivePM(Double twoPointFivePM) {
        this.twoPointFivePM = twoPointFivePM;
    }

    public Double getTenPM() {
        return tenPM;
    }

    public void setTenPM(Double tenPM) {
        this.tenPM = tenPM;
    }

    public Double getCarbonMonoxide() {
        return carbonMonoxide;
    }

    public void setCarbonMonoxide(Double carbonMonoxide) {
        this.carbonMonoxide = carbonMonoxide;
    }

    public Double getSulfurDioxide() {
        return sulfurDioxide;
    }

    public void setSulfurDioxide(Double sulfurDioxide) {
        this.sulfurDioxide = sulfurDioxide;
    }

    public Double getNitrogenDioxide() {
        return nitrogenDioxide;
    }

    public void setNitrogenDioxide(Double nitrogenDioxide) {
        this.nitrogenDioxide = nitrogenDioxide;
    }
}
