package isa.projekat.booking.domain.dto;

public class VehicleDiscountDTO {
	
	private String id;
	private String vehicleID;
	private String discountStartDate;
	private String discountEndDate;
	private Double discount;
	
	public VehicleDiscountDTO() {
		
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

	public String getDiscountStartDate() {
		return discountStartDate;
	}

	public void setDiscountStartDate(String discountStartDate) {
		this.discountStartDate = discountStartDate;
	}

	public String getDiscountEndDate() {
		return discountEndDate;
	}

	public void setDiscountEndDate(String discountEndDate) {
		this.discountEndDate = discountEndDate;
	}

	private Double getDiscount() {
		return discount;
	}

	private void setDiscount(Double discount) {
		this.discount = discount;
	}
	
	
}
