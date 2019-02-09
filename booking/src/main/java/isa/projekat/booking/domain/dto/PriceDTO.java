package isa.projekat.booking.domain.dto;

import java.util.Date;

import isa.projekat.booking.domain.Price;

public class PriceDTO {
	
	private int price;
	private String startDate;
	private String endDate;
	
	public PriceDTO() {
		super();
	}

	public PriceDTO(int price, String startDate, String endDate) {
		super();
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Price createPrice(PriceDTO source) {
		Price price = new Price();
		price.setEndDate(source.getEndDate());
		price.setStartDate(source.getStartDate());
		price.setPrice(source.getPrice());
		
		return price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
