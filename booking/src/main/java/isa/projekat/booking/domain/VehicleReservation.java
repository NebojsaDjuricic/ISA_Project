package isa.projekat.booking.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;

@Document("VehicleReservations")
public class VehicleReservation {

    @Id
    private int id;
    private String vehicleID;
    private SimpleDateFormat startDate;
    private SimpleDateFormat endDate;
    private String startPlace;
    private String endPlace;
}
