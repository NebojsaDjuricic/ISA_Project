import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RentACar } from '../../../../model/rent-a-car';
import { RentACarServiceServiceService } from '../../../../services/rent-a-car-service-service.service';
import { Address } from 'src/app/model/address';

@Component({
  selector: 'app-create-rent-a-car-service',
  templateUrl: './create-rent-a-car-service.component.html',
  styleUrls: ['./create-rent-a-car-service.component.css']
})
export class CreateRentACarServiceComponent implements OnInit {

  createNewRentACarForm: FormGroup;
  newRentACar: RentACar;
  address: Address;

  constructor(
    private rent_a_car_service: RentACarServiceServiceService,
    private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.createNewRentACarForm = this.formBuilder.group({
      name: ['', Validators.required],
      streetName: ['', Validators.required],
      buildingNumber: ['', Validators.required],
      city: ['', Validators.required],
      country: ['', Validators.required],
      description: ['', Validators.required]
    });

    this.newRentACar = new RentACar();
    this.address = new Address();

  }

  onSubmit() {
    // Validate
    this.address.streetName = this.createNewRentACarForm.controls.streetName.value;
    this.address.buildingNumber = this.createNewRentACarForm.controls.buildingNumber.value;
    this.address.city = this.createNewRentACarForm.controls.city.value;
    this.address.country = this.createNewRentACarForm.controls.country.value;

    this.newRentACar.name = this.createNewRentACarForm.controls.name.value;
    this.newRentACar.description = this.createNewRentACarForm.controls.description.value;
    this.newRentACar.address = this.address;

    console.log(this.newRentACar);

    this.rent_a_car_service.addRentACar(this.newRentACar).subscribe(
      res => {
        console.log(res);
      }
    );
  }

}
