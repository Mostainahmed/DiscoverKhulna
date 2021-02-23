package com.mostainahmed.discoverkhulna.hotel;

public class Hotel{
    int id;
    String hotelName;
    String hotelDescription;
    String hotelRating;
    String hotelPrice;
    int hotelImageView;
    String hotelLocation;
    String hotelNumber;
    String hotelWebUrl;

    public String getHotelLocation() {
        return hotelLocation;
    }

    public String getHotelNumber() {
        return hotelNumber;
    }

    public int getId() {
        return id;
    }

    public String getHotelRating() {
        return hotelRating;
    }

    public String getHotelPrice() {
        return hotelPrice;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getHotelImageView() {
        return hotelImageView;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public String getHotelWebUrl() {
        return hotelWebUrl;
    }

    public Hotel(int id, String hotelName, String hotelDescription, String hotelRating, String hotelPrice, int hotelImageView, String hotelLocation, String hotelNumber, String hotelWebUrl) {
        this.id = id;
        this.hotelName = hotelName;
        this.hotelDescription = hotelDescription;
        this.hotelRating = hotelRating;
        this.hotelPrice = hotelPrice;
        this.hotelImageView = hotelImageView;
        this.hotelLocation = hotelLocation;
        this.hotelNumber = hotelNumber;
        this.hotelWebUrl = hotelWebUrl;
    }
}
