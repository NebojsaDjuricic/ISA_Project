import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { VehicleDTO } from '../../../../model//vehicleDTO';
import { Vehicle } from '../../../../model//vehicle';
import { ActivatedRoute } from '@angular/router';
import {Router} from '@angular/router';
import { VehicleServiceService } from '../../../../services/vehicle-service.service';
import { AuthServiceService } from '../../../../services/auth-service.service';

@Component({
  selector: 'app-edit-vehicle',
  templateUrl: './edit-vehicle.component.html',
  styleUrls: ['./edit-vehicle.component.css']
})
export class EditVehicleComponent implements OnInit {

  editVehicleForm: FormGroup;
  vehicle: Vehicle;
  editedVehicle: VehicleDTO;
  branchID: String;
  vehicleID: String;
  submitted = false;

  constructor(
    private formBuilder: FormBuilder,
    private router: ActivatedRoute,
    private vehicleService: VehicleServiceService,
    private auth: AuthServiceService,
    private navigator: Router
    ) { }

  ngOnInit() {
    this.editVehicleForm = this.formBuilder.group({
      brand: ['', Validators.required],
        model: ['', Validators.required],
        price: ['', Validators.required],
        branch: ['', Validators.required],
        status: ['', Validators.required],
        licence: ['', Validators.required]
    });

    this.editedVehicle = new VehicleDTO();

    this.router.params.subscribe(
      params => {
        this.branchID = params['branchID'];
        this.vehicleID = params['vehicleID'];
      }
    );

    this.vehicle = new VehicleDTO();
    // vehicle = popunjeno vozilo i branch
    this.vehicleService.getVehicle(this.vehicleID).subscribe(
      res => {
        this.vehicle = res;
        console.log(this.vehicle.status);
      }
    );



  }

  onSubmit() {
    this.submitted = true;
    console.log('onSubmit save vehicle');

    this.editedVehicle.licenceID = this.vehicleID;
    this.editedVehicle.branchID = this.branchID;
    this.editedVehicle.brand = this.editVehicleForm.controls.brand.value;
    this.editedVehicle.model = this.editVehicleForm.controls.model.value;
    this.editedVehicle.price = this.editVehicleForm.controls.price.value;
    this.editedVehicle.status = this.editVehicleForm.controls.status.value;
    this.editedVehicle.admin = this.auth.getAdminUsername();

    this.vehicleService.editVehicle(this.editedVehicle).subscribe(
      res => {
        console.log(res);
      }
    );

    this.navigator.navigate(['/']);
  }

}
