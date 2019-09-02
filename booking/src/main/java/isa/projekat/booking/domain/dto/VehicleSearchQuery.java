package isa.projekat.booking.domain.dto;

import isa.projekat.booking.domain.VehicleType;

public class VehicleSearchQuery {
    private String startDate;
    private String endDate;
    private String startPlace;
    private String endPlace;
    private VehicleType type;
    private Integer passengers;

    public VehicleSearchQuery() {

    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(String endPlace) {
        this.endPlace = endPlace;
    }

	public Integer getPassengers() {
		return passengers;
	}

	public void setPassengers(Integer passengers) {
		this.passengers = passengers;
	}
	
	public String toString() {
		return ""+this.getStartDate()+" "+this.getStartPlace()+" "
				+this.getEndDate()+" "+ this.getEndPlace()+ " "
				+this.getType()+ " " + this.getPassengers();
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}
}
