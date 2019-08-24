package isa.projekat.booking.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Vehicles")
public class Vehicle {

    @Id
    private String licenceID;
    private String name;
    private String brand;
    private String model;
    private int manufacturingYear;
    private int numberOfSeats;
    //private VehicleType vehicleType;
    private Double rating;
    private Double price;
    private VehicleStatus status;
    

    public Vehicle() {

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicenceID() {
        return licenceID;
    }

    public void setLicenceID(String licenceID) {
        this.licenceID = licenceID;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }
}
