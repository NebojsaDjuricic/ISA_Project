import { Component, OnInit } from '@angular/core';
import { RentACar } from '../../model/rent-a-car';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { RentACarService } from '../../services/rent-a-car.service';
import { Observable } from 'rxjs';
import { Vehicle } from 'src/app/model/vehicle';
import { DataForParent } from '../../searches/rent-a-car-search/rent-a-car-search.component';
import { VehicleService } from '../../services/vehicle.service';
import { VehicleReservationDTO } from '../../model/vehicleReservationDTO';

@Component({
  selector: 'app-rent-a-car-page',
  templateUrl: './rent-a-car-page.component.html',
  styleUrls: ['./rent-a-car-page.component.css']
})
export class RentACarPageComponent implements OnInit {

  company: RentACar;
  queryResult: Vehicle[];
  dataFromChild: DataForParent;
  vehicleReservationDetails: VehicleReservationDTO;

  constructor(
    private rentACarService: RentACarService,
    private route: ActivatedRoute,
    private location: Location,
    private vehicleService: VehicleService
  ) { }

  ngOnInit() {
    this.getInfo();
    this.vehicleReservationDetails = new VehicleReservationDTO();
  }

  getInfo() {
    const id = this.route.snapshot.paramMap.get('id');
    this.rentACarService.getRentACar(id).subscribe(
      retVal => {
        this.company = retVal;
      }
    );
  }

  fetchQueryResults($event) {
    this.dataFromChild = $event;

    console.log(this.dataFromChild.vehicles.length);

    this.queryResult = this.dataFromChild.vehicles;
  }

  makeVehicleReservation(vehicle: Vehicle) {

    console.log(this.company.id);
    this.vehicleReservationDetails.rentACarServiceID = this.company.id;
    this.vehicleReservationDetails.vehicleID = vehicle.licenceID;
    this.vehicleReservationDetails.endDate = this.dataFromChild.endDate;
    this.vehicleReservationDetails.endPlace = this.dataFromChild.endPlace;
    this.vehicleReservationDetails.startDate = this.dataFromChild.startDate;
    this.vehicleReservationDetails.startPlace = this.dataFromChild.startPlace;

    this.vehicleService.makeVehicleReservation(this.vehicleReservationDetails).subscribe(
      res => {
        
      }
    );

    console.log("Vehicle reservation completed");

    this.vehicleReservationDetails = null;
  }

}
