package com.mostainahmed.discoverkhulna.fireservice;

public class FireService {
    int id;
    int fireImage;
    String fireLocation;

    public int getFireImage() {
        return fireImage;
    }

    public String getFireLocation() {
        return fireLocation;
    }

    String fireServiceName;
    String fireServiceNumber;

    public int getId() {
        return id;
    }

    public String getFireServiceName() {
        return fireServiceName;
    }

    public String getFireServiceNumber() {
        return fireServiceNumber;
    }

    public FireService(int id, String fireServiceName, String fireServiceNumber, int fireImage, String fireLocation) {
        this.id = id;
        this.fireServiceName = fireServiceName;
        this.fireServiceNumber = fireServiceNumber;
        this.fireImage = fireImage;
        this.fireLocation = fireLocation;
    }
}
