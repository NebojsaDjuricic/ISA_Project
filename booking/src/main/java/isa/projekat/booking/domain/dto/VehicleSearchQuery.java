package isa.projekat.booking.domain.dto;

public class VehicleSearchQuery {
    private String startDate;
    private String endDate;
    private String startPlace;
    private String endPlace;
    private String type;
    private String passangers;

    public VehicleSearchQuery() {

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

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(String endPlace) {
        this.endPlace = endPlace;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassangers() {
        return passangers;
    }

    public void setPassangers(String passangers) {
        this.passangers = passangers;
    }
}
