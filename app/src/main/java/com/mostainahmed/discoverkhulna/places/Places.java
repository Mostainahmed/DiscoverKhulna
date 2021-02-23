package com.mostainahmed.discoverkhulna.places;

public class Places {

    int id;
    String placeName;
    String placeDescription;
    String placeGoingRules;
    int placeImage1;
    int placeImage2;
    int PlaceImage3;
    Double placeLongitude;
    Double placeLatitude;

    public Places(int id, String placeName, String placeDescription, String placeGoingRules, int placeImage1, int placeImage2, int placeImage3, Double placeLongitude, Double placeLatitude) {
        this.id = id;
        this.placeName = placeName;
        this.placeDescription = placeDescription;
        this.placeGoingRules = placeGoingRules;
        this.placeImage1 = placeImage1;
        this.placeImage2 = placeImage2;
        this.PlaceImage3 = placeImage3;
        this.placeLongitude = placeLongitude;
        this.placeLatitude = placeLatitude;
    }

    public int getId() {
        return id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getPlaceDescription() {
        return placeDescription;
    }

    public String getPlaceGoingRules() {
        return placeGoingRules;
    }

    public int getPlaceImage1() {
        return placeImage1;
    }

    public int getPlaceImage2() {
        return placeImage2;
    }

    public int getPlaceImage3() {
        return PlaceImage3;
    }

    public Double getPlaceLongitude() {
        return placeLongitude;
    }

    public Double getPlaceLatitude() {
        return placeLatitude;
    }
}
