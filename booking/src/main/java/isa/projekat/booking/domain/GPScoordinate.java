package isa.projekat.booking.domain;

public class GPScoordinate {

    private Double latitude;
    private Double longitude;

    public GPScoordinate() {
    	super();
    }
    
    

    public GPScoordinate(Double lat, Double longitude) {
    	super();
		this.latitude = lat;
		this.longitude = longitude;
	}



	public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
