package isa.projekat.booking.domain;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document("Hotels")
public class Hotel {
	
	@Id
	private String id;
	private String name;
	private Address address;
	private String phoneNumber;
    private String contactEmail;
	private String description;
	private String website;
	private Double rating;
	@JsonIgnore
	private ArrayList<HotelRating> hotelRatings;
	private int numberOfFloors;
	private int stars;
	@JsonIgnore
	private ArrayList<Room> rooms;
	@JsonIgnore
	private ArrayList<AdditionalService> additionalServices;
	private String imageURLs;
//	 private admin ?
	
	public Hotel() {
		
	}

	public Hotel(String id, String name, Address address,
				String phoneNumber, String contactEmail, 
				String description, String website,
				Double rating, int numberOfFloors,
				int stars, ArrayList<Room> rooms,
				ArrayList<AdditionalService> additionalServices) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.contactEmail = contactEmail;
		this.description = description;
		this.website = website;
		this.rating = rating;
		this.numberOfFloors = numberOfFloors;
		this.stars = stars;
		this.rooms = rooms;
		this.additionalServices = additionalServices;
	}

// dodato polje za slike
	public Hotel(String id, String name, Address address, String phoneNumber, String contactEmail, String description,
			String website, Double rating, int numberOfFloors, int stars, ArrayList<Room> rooms,
			ArrayList<AdditionalService> additionalServices, String imageURL) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.contactEmail = contactEmail;
		this.description = description;
		this.website = website;
		this.rating = rating;
		this.numberOfFloors = numberOfFloors;
		this.stars = stars;
		this.rooms = rooms;
		this.additionalServices = additionalServices;
		this.imageURLs = imageURL;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public ArrayList<HotelRating> getHotelRatings() {
		return hotelRatings;
	}

	public void setHotelRatings(ArrayList<HotelRating> hotelRatings) {
		this.hotelRatings = hotelRatings;
	}

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}

	public ArrayList<AdditionalService> getAdditionalServices() {
		return additionalServices;
	}

	public void setAdditionalServices(ArrayList<AdditionalService> additionalServices) {
		this.additionalServices = additionalServices;
	}

	public String getImageURL() {
		return imageURLs;
	}

	public void setImageURL(String imageURL) {
		this.imageURLs = imageURL;
	}
	
	
}
