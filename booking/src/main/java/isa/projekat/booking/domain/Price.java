package isa.projekat.booking.domain;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Prices")
public class Price {
	
	@Id
	private String id;
	private int pricePerNight;
	private LocalDate startDate;
	private LocalDate endDate;
	private boolean naPopustu;
	private Double popust;
	
	public Price() {
		super();
	}

	public Price(String id, LocalDate startDate, LocalDate endDate, int price) {
		super();
		this.id = id;
		this.pricePerNight = price;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Price(String id, LocalDate startDate, LocalDate endDate, int price, boolean naPopustu, Double popust) {
		super();
		this.id = id;
		this.pricePerNight = price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.naPopustu = naPopustu;
		this.popust = popust;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(int price) {
		this.pricePerNight = price;
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

	public boolean isNaPopustu() {
		return naPopustu;
	}

	public void setNaPopustu(boolean naPopustu) {
		this.naPopustu = naPopustu;
	}

	public Double getPopust() {
		return popust;
	}

	public void setPopust(Double popust) {
		this.popust = popust;
	}
	
}
