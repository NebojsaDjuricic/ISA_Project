package isa.projekat.booking.domain;

public class Address {

    private String streetName;
    private String buildingNumber;
    private String city;
    private String country;
    private GPScoordinate coordinatePosition;

    public Address() {

    }

    public Address(String streetName, String buildingNumber, String city, String country,
			GPScoordinate coordinatePosition) {
		super();
		this.streetName = streetName;
		this.buildingNumber = buildingNumber;
		this.city = city;
		this.country = country;
		this.coordinatePosition = coordinatePosition;
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
