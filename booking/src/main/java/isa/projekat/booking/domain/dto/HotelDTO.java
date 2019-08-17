package isa.projekat.booking.domain.dto;

import isa.projekat.booking.domain.Address;
import isa.projekat.booking.domain.Hotel;

public class HotelDTO {

	private String name;
    private String description;
    private AddressDTO address;
    
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
}
