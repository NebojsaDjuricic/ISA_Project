package isa.projekat.booking.domain.dto;

import java.time.LocalDate;
import java.util.Date;

import isa.projekat.booking.domain.Price;

public class PriceDTO {
	
	private Integer price;
	private LocalDate startDate;
	private LocalDate endDate;
	private Boolean naPopustu;
	private Double popust;
	private String roomId;
	
	public PriceDTO() {
		super();
	}

	@Override
	public String toString() {
		return "PriceDTO [price=" + price + ", startDate=" + startDate + ", endDate=" + endDate + ", naPopustu="
				+ naPopustu + ", popust=" + popust + ", roomId=" + roomId + "]";
	}

	public Price createPrice(PriceDTO source) {
		Price price = new Price();
		price.setEndDate(source.getEndDate());
		price.setStartDate(source.getStartDate());
		price.setPricePerNight(source.getPrice());
		price.setNaPopustu(source.getNaPopustu());
		price.setPopust(source.getPopust());
		
		return price;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
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

	public Boolean getNaPopustu() {
		return naPopustu;
	}

	public void setNaPopustu(Boolean naPopustu) {
		this.naPopustu = naPopustu;
	}

	public Double getPopust() {
		return popust;
	}

	public void setPopust(Double popust) {
		this.popust = popust;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	
}
