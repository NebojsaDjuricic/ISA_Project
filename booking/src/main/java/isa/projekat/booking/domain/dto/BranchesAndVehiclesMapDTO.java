package isa.projekat.booking.domain.dto;

import java.util.ArrayList;

public class BranchesAndVehiclesMapDTO {
	
	private String branchID;
	private ArrayList<String> vehiclesInBranch;
	
	public BranchesAndVehiclesMapDTO() {
		this.setVehiclesInBranch(new ArrayList<String>());
	}

	public String getBranchID() {
		return branchID;
	}

	public void setBranchID(String branchID) {
		this.branchID = branchID;
	}

	public ArrayList<String> getVehiclesInBranch() {
		return vehiclesInBranch;
	}

	public void setVehiclesInBranch(ArrayList<String> vehiclesInBranch) {
		this.vehiclesInBranch = vehiclesInBranch;
	}
}
