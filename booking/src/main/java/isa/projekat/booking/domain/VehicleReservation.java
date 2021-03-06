package isa.projekat.booking.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

@Document("VehicleReservations")
public class VehicleReservation {

    @Id
    private String id;
    private String vehicleID;
    private String rentACarServiceID;
    private LocalDate startDate;
    private LocalDate endDate;
    private String pickUpLocation;
    private String dropUpLocation;
    private Double rating;
    
    public VehicleReservation() {
    	this.setId("VehRes" + Calendar.getInstance().getTimeInMillis());
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getPickUpLocation() {
		return pickUpLocation;
	}

	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

	public String getDropUpLocation() {
		return dropUpLocation;
	}

	public void setDropUpLocation(String dropUpLocation) {
		this.dropUpLocation = dropUpLocation;
	}

	public String getRentACarServiceID() {
		return rentACarServiceID;
	}

	public void setRentACarServiceID(String rentACarServiceID) {
		this.rentACarServiceID = rentACarServiceID;
	}
    
}
