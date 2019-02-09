import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../../../services/auth-service.service';
import { RentACarServiceServiceService } from '../../../services/rent-a-car-service-service.service';
import { RentACar } from '../../../model/rent-a-car';

@Component({
  selector: 'app-rent-a-car-service-admin',
  templateUrl: './rent-a-car-service-admin.component.html',
  styleUrls: ['./rent-a-car-service-admin.component.css']
})
export class RentACarServiceAdminComponent implements OnInit {

  rent_a_car_serviceID: null;
  rent_a_car: RentACar = null;

  constructor(
    private auth: AuthServiceService,
    private rentACarService: RentACarServiceServiceService
  ) { }

  ngOnInit() {
    const token = this.auth.getUser();
    const id = token.split('.', 3)[2];
    this.rent_a_car_serviceID = id;

    this.rentACarService.getRentACar(id).subscribe(
      res => {
        this.rent_a_car = res;
      }
    );
  }

}
