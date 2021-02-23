package com.mostainahmed.discoverkhulna.hospital;

public class Hospital {
    int id;
    String hospitalName;
    String hospitalNumber;
    int hospitalImage;
    String hospitalLocation;

    public int getHospitalImage() {
        return hospitalImage;
    }

    public String getHospitalLocation() {
        return hospitalLocation;
    }

    public Hospital(int id, String hospitalName, String hospitalNumber, int hospitalImage, String hospitalLocation) {
        this.id = id;
        this.hospitalName = hospitalName;
        this.hospitalNumber = hospitalNumber;
        this.hospitalImage = hospitalImage;
        this.hospitalLocation = hospitalLocation;
    }

    public int getId() {
        return id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getHospitalNumber() {
        return hospitalNumber;
    }
}
