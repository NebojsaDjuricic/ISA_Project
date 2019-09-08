package isa.projekat.booking.domain.dto;

import java.util.ArrayList;
import java.util.List;

import isa.projekat.booking.domain.RentACarService;

public class RentACarSearchResult {
	
	private List<RentACarService> queryResult;
	private String message;
	
	public RentACarSearchResult() {
		this.setQueryResult(new ArrayList<RentACarService>());
	}

	public List<RentACarService> getQueryResult() {
		return queryResult;
	}

	public void setQueryResult(List<RentACarService> queryResult) {
		this.queryResult = queryResult;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
