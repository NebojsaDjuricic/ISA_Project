import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Vehicle } from '../../../../model/vehicle';
import { Branch } from '../../../../model/branch';
import { VehicleServiceService } from '../../../../services/vehicle-service.service';
import { RentACarServiceServiceService } from '../../../../services/rent-a-car-service-service.service';
import { AuthServiceService } from '../../../../services/auth-service.service';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-create-vehicle',
  templateUrl: './create-vehicle.component.html',
  styleUrls: ['./create-vehicle.component.css']
})
export class CreateVehicleComponent implements OnInit {

  createVehicleForm: FormGroup;
  vehicle: Vehicle;
  branches: Branch[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private vehicleService: VehicleServiceService,
    private rentACarServiceService: RentACarServiceServiceService,
    private auth: AuthServiceService
    ) { }

  ngOnInit() {
    this.createVehicleForm = this.formBuilder.group(
      {
        brand: ['', Validators.required],
        model: ['', Validators.required],
        licence: ['', Validators.required],
        price: ['', Validators.required],
        branch: ['', Validators.required]
      }
    );

    this.rentACarServiceService.getBranches(this.auth.getAdminUsername()).subscribe(
      res => {
        this.branches = res;
        console.log('Branches size: ' + this.branches.length);
      }
    );
    this.vehicle = new Vehicle();
  }

  onSubmit() {
    // Validate

    this.vehicle.brand = this.createVehicleForm.controls.brand.value;
    this.vehicle.model = this.createVehicleForm.controls.model.value;
    this.vehicle.licenceID = this.createVehicleForm.controls.licence.value;
    this.vehicle.price = this.createVehicleForm.controls.price.value;
    this.vehicle.branchID = this.createVehicleForm.controls.branch.value;
    this.vehicle.admin = this.auth.getAdminUsername();


    this.vehicleService.addVehicle(this.vehicle).subscribe(
      res => {
        console.log(res);
      }
    );
  }

}
