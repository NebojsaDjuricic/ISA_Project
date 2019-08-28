package isa.projekat.booking.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//public enum AdditionalService {
//	WIFI, PARKING, AIRPORT_TRANSFER, ROOM_SERVICE, MINI_BAR,
//  KITCHEN, TV, AIR_CONDITION, SWIMMING_POOL,
//  PRIVATE_BATHROOM, BREAKFAST, HALF_BOARD, FULL_BOARD,
//  WELLNESS, SPA, TENNIS COURTS, BOWLING, GYM, SOLARIUM
//}


@Document("Additional Services")
public class AdditionalService {
	
	@Id
	private Long id;
	private String service;
	private int price;
	
	
	public AdditionalService() {
		super();
	}

	public AdditionalService(Long id, String service, int price) {
		super();
		this.id = id;
		this.service = service;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
