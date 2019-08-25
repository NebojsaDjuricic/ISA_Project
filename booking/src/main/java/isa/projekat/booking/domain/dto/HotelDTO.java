package isa.projekat.booking.domain.dto;

public class HotelDTO {

	private String name;
	private String description;
    private AddressDTO address;
//    private String phoneNumber;
//    private String contactEmail;
//	private String website;
//	// rating
//	private int numberOfFloors;
//	private int stars;
//	private String imageURLs;
    
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
