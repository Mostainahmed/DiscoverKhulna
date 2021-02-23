package com.mostainahmed.discoverkhulna.policestation;

public class PoliceStation {
    int id;
    String policeStationName;
    String policeStationNumber;
    int policeImage;
    String policeLocation;

    public int getId() {
        return id;
    }

    public String getPoliceStationName() {
        return policeStationName;
    }

    public String getPoliceStationNumber() {
        return policeStationNumber;
    }

    public int getPoliceImage() {
        return policeImage;
    }

    public String getPoliceLocation() {
        return policeLocation;
    }

    public PoliceStation(int id, String policeStationName, String policeStationNumber, int policeImage, String policeLocation) {
        this.id = id;
        this.policeStationName = policeStationName;
        this.policeStationNumber = policeStationNumber;
        this.policeImage = policeImage;
        this.policeLocation = policeLocation;
    }
}
