import { Component, OnInit } from '@angular/core';
import { RentACarServiceServiceService } from '../../../../services/rent-a-car-service-service.service';
import { AdminServiceService } from '../../../../services/admin-service.service';
import { RentACar } from '../../../../model/rent-a-car';
import { AuthServiceService } from '../../../../services/auth-service.service';
import { Branch } from '../../../../model/branch';

@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
  styleUrls: ['./vehicle-list.component.css']
})
export class VehicleListComponent implements OnInit {

  adminID: String;
  rentACarID: String;
  rentACar: RentACar;
  branches: Branch[] = [];

  constructor(
    private rentACarServiceService: RentACarServiceServiceService,
    private adminService: AdminServiceService,
    private auth: AuthServiceService
    ) { }

  ngOnInit() {

    const usertoken = this.auth.getUser();
    const splitted = usertoken.split('.', 3);
    this.rentACarID = splitted[2];
    this.rentACar = new RentACar();
    this.rentACarServiceService.getRentACar(this.rentACarID).subscribe(
      res => {

        for (const branch of res.branches) {
          this.branches.push(branch);
        }
        this.rentACar = res;

        console.log(this.branches.length);
      }
    );
  }

}
