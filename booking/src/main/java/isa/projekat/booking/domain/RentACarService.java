package isa.projekat.booking.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document("RentACarServices")
public class RentACarService {

    @Id
    private String id;
    @TextIndexed
    private String name;
    private Address address;
    private String description;
    private Double rating;
    private ArrayList<Branch> branches;
    private ArrayList<VehicleDiscount> vehiclesOnDiscount;
    private Map<String, String> vehicles;
    private Map<String, List<String>> branchesAndVehicles;

    public RentACarService() {
    	this.setBranches(new ArrayList<Branch>());
    	this.setVehiclesOnDiscount(new ArrayList<VehicleDiscount>());
    	this.setVehicles(new HashMap<String, String>());
    	this.setBranchesAndVehicles(new HashMap<String, List<String>>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public void setBranches(ArrayList<Branch> branches) {
        this.branches = branches;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	public ArrayList<VehicleDiscount> getVehiclesOnDiscount() {
		return vehiclesOnDiscount;
	}

	public void setVehiclesOnDiscount(ArrayList<VehicleDiscount> vehiclesOnDiscount) {
		this.vehiclesOnDiscount = vehiclesOnDiscount;
	}

	public Map<String, String> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Map<String, String> vehicles) {
		this.vehicles = vehicles;
	}

	public Map<String, List<String>> getBranchesAndVehicles() {
		return branchesAndVehicles;
	}

	public void setBranchesAndVehicles(Map<String, List<String>> branchesAndVehicles) {
		this.branchesAndVehicles = branchesAndVehicles;
	}
}
