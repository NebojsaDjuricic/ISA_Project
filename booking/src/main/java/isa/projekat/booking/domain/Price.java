package isa.projekat.booking.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Prices")
public class Price {
	
	@Id
	private String id;
	private int price;
	private String startDate;
	private String endDate;
	private boolean naPopustu;
	private int popust;
	
	public Price() {
		super();
	}

	public Price(String id, int price, String startDate, String endDate) {
		super();
		this.id = id;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Price(String id, int price, String startDate, String endDate, boolean naPopustu, int popust) {
		super();
		this.id = id;
		this.price = price;
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

	public boolean isNaPopustu() {
		return naPopustu;
	}

	public void setNaPopustu(boolean naPopustu) {
		this.naPopustu = naPopustu;
	}

	public int getPopust() {
		return popust;
	}

	public void setPopust(int popust) {
		this.popust = popust;
	}
	
}
