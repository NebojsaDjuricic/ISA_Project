package isa.projekat.booking.domain.dto;

import isa.projekat.booking.domain.GPScoordinate;

public class AddressDTO {

    private String streetName;
    private String buildingNumber;
    private String city;
    private String country;
    private GPScoordinate coordinatePosition;

    // gps location
    
    public AddressDTO() {
    	this.setCoordinatePosition(new GPScoordinate());
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

	public GPScoordinate getCoordinatePosition() {
		return coordinatePosition;
	}

	public void setCoordinatePosition(GPScoordinate coordinatePosition) {
		this.coordinatePosition = coordinatePosition;
	}


}
