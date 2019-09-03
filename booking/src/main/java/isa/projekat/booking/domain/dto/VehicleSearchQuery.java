package isa.projekat.booking.domain.dto;

import isa.projekat.booking.domain.VehicleType;

public class VehicleSearchQuery {
    private String startDate;
    private String endDate;
    private String startPlace;
    private String endPlace;
    private VehicleType type;
    private Integer passengers;
    private Double minPrice;
    private Double maxPrice;
    private String rentACarServiceID;

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

	public Double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	public Double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getRentACarServiceID() {
		return rentACarServiceID;
	}

	public void setRentACarServiceID(String rentACarServiceID) {
		this.rentACarServiceID = rentACarServiceID;
	}
}
