package isa.projekat.booking.domain.dto;

import isa.projekat.booking.domain.Address;
import isa.projekat.booking.domain.Vehicle;

import java.util.ArrayList;

public class BranchDTO {

    private String id;
    private String admin;
    private String name;
    private AddressDTO address;
    private String phoneNumber;
    private String contactEmail;
    private ArrayList<VehicleDTO> vehicles;

    public BranchDTO() {
    	this.setVehicles(new ArrayList<VehicleDTO>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public ArrayList<VehicleDTO> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<VehicleDTO> vehicles) {
        this.vehicles = vehicles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}
