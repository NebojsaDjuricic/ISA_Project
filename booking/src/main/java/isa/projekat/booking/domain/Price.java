package isa.projekat.booking.domain;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Prices")
public class Price {
	
	@Id
	private String id;
	private Integer pricePerNight;
	private LocalDate startDate;
	private LocalDate endDate;
	private Boolean naPopustu;
	private Double popust;
	
	public Price() {
		super();
	}

	public Price(String id, LocalDate startDate, LocalDate endDate, Integer price) {
		super();
		this.id = id;
		this.pricePerNight = price;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Price(String id, LocalDate startDate, LocalDate endDate, Integer price, Boolean naPopustu, Double popust) {
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

	public Integer getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(Integer price) {
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

	public Boolean isNaPopustu() {
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
	
}
