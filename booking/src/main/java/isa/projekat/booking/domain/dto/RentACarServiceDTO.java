package isa.projekat.booking.domain.dto;

import java.util.ArrayList;

public class RentACarServiceDTO {

    private String id;
	private String name;
    private String description;
    private Double rating;
    private AddressDTO address;
    private ArrayList<BranchDTO> branches;
    private ArrayList<VehicleDiscountDTO> vehiclesOnDiscount;
    private ArrayList<String> vehicles;
    private ArrayList<BranchesAndVehiclesMapDTO> branchesAndVehicles;
    
    public RentACarServiceDTO() {
    	this.setBranches(new ArrayList<BranchDTO>());
    	this.setVehiclesOnDiscount(new ArrayList<VehicleDiscountDTO>());
    	this.setVehicles(new ArrayList<String>());
    	this.setBranchesAndVehicles(new ArrayList<BranchesAndVehiclesMapDTO>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public ArrayList<BranchDTO> getBranches() {
		return branches;
	}

	public void setBranches(ArrayList<BranchDTO> branches) {
		this.branches = branches;
	}

	public ArrayList<VehicleDiscountDTO> getVehiclesOnDiscount() {
		return vehiclesOnDiscount;
	}

	public void setVehiclesOnDiscount(ArrayList<VehicleDiscountDTO> vehiclesOnDiscount) {
		this.vehiclesOnDiscount = vehiclesOnDiscount;
	}

	public ArrayList<String> getVehicles() {
		return vehicles;
	}

	public void setVehicles(ArrayList<String> vehicles) {
		this.vehicles = vehicles;
	}

	public ArrayList<BranchesAndVehiclesMapDTO> getBranchesAndVehicles() {
		return branchesAndVehicles;
	}

	public void setBranchesAndVehicles(ArrayList<BranchesAndVehiclesMapDTO> branchesAndVehicles) {
		this.branchesAndVehicles = branchesAndVehicles;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
