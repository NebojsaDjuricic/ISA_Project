package isa.projekat.booking.domain;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class VehicleDiscount {
	
	private String id;
	private String vehicleID;
	private LocalDate discountStartDate;
	private LocalDate discountEndDate;
	private Double discount;
	
	public VehicleDiscount() {
		this.setId("VehDis" + Calendar.getInstance().getTimeInMillis());
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

	public LocalDate getDiscountStartDate() {
		return discountStartDate;
	}

	public void setDiscountStartDate(LocalDate discountStartDate) {
		this.discountStartDate = discountStartDate;
	}

	public LocalDate getDiscountEndDate() {
		return discountEndDate;
	}

	public void setDiscountEndDate(LocalDate discountEndDate) {
		this.discountEndDate = discountEndDate;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
	
}
