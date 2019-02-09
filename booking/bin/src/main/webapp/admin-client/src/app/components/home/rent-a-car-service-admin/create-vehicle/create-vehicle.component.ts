import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Vehicle } from '../../../../model/vehicle';
import { VehicleServiceService } from '../../../../services/vehicle-service.service';

@Component({
  selector: 'app-create-vehicle',
  templateUrl: './create-vehicle.component.html',
  styleUrls: ['./create-vehicle.component.css']
})
export class CreateVehicleComponent implements OnInit {

  createVehicleForm: FormGroup;
  vehicle: Vehicle;

  constructor(
    private formBuilder: FormBuilder,
    private vehicleService: VehicleServiceService
    ) { }

  ngOnInit() {
    this.createVehicleForm = this.formBuilder.group(
      {
        brand: ['', Validators.required],
        model: ['', Validators.required],
        licence: ['', Validators.required],
        status: ['', Validators.required],
        price: ['', Validators.required],
        rating: ['', Validators.required]
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

    this.vehicleService.addVehicle(this.vehicle).subscribe(
      res => {
        console.log(res);
      }
    );
  }

}
