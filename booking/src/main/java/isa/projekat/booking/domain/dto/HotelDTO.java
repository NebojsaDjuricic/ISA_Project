package isa.projekat.booking.domain.dto;

import isa.projekat.booking.domain.Address;
import isa.projekat.booking.domain.Hotel;

public class HotelDTO {

	private String name;
    private String description;
    private Address address;
    
    public Hotel createHotel(HotelDTO hotelDto) {
    	Hotel hotel = new Hotel();
    	hotel.setName(hotelDto.getName());
    	hotel.setDescription(hotelDto.getDescription());
    	hotel.setAddress(hotelDto.getAddress());
    	
    	return hotel;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
