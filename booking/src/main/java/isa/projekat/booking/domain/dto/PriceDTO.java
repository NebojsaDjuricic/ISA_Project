package isa.projekat.booking.domain.dto;

import java.time.LocalDate;
import java.util.Date;

import isa.projekat.booking.domain.Price;

public class PriceDTO {
	
	private int price;
	private LocalDate startDate;
	private LocalDate endDate;
	
	public PriceDTO() {
		super();
	}

	public PriceDTO(int price, LocalDate startDate, LocalDate endDate) {
		super();
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Price createPrice(PriceDTO source) {
		Price price = new Price();
		price.setEndDate(source.getEndDate());
		price.setStartDate(source.getStartDate());
		price.setPricePerNight(source.getPrice());
		
		return price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
}
