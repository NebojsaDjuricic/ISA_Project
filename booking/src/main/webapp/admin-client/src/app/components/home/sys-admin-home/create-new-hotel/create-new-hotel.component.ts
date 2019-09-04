import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Hotel} from '../../../../model/hotel';
import {Address} from '../../../../model/address';
import {HotelService} from '../../../../services/hotel.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-create-new-hotel',
  templateUrl: './create-new-hotel.component.html',
  styleUrls: ['./create-new-hotel.component.css']
})
export class CreateNewHotelComponent implements OnInit {

  createNewHotelForm: FormGroup;
  newHotel: Hotel;
  address: Address;
  errorMessage = 'This field is required!';

  constructor(private hotelService: HotelService,
              private formBuilder: FormBuilder,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.createNewHotelForm = this.formBuilder.group({
      name: ['', Validators.required],
      streetName: ['', Validators.required],
      buildingNumber: ['', Validators.required],
      city: ['', Validators.required],
      country: ['', Validators.required],
      // lat: [''],
      // lon: [''],
      phoneNumber: ['', Validators.required],
      contactEmail: new FormControl('', [Validators.required, Validators.email]),
      description: ['', Validators.required],
      website: ['', Validators.required],
      rating: [0.0, Validators.required],
      numberOfFloors: new FormControl(null, [Validators.required, Validators.pattern(/^[1-9]\d*$/)]),
      stars: new FormControl(null, [Validators.required, Validators.pattern(/^[1-9]\d*$/)]),
      rooms: [],
      additionalServices: [],
    });

    this.newHotel = new Hotel();
    this.address = new Address();
  }

  onSubmit() {
    this.address.streetName = this.createNewHotelForm.controls.streetName.value;
    this.address.buildingNumber = this.createNewHotelForm.controls.buildingNumber.value;
    this.address.city = this.createNewHotelForm.controls.city.value;
    this.address.country = this.createNewHotelForm.controls.country.value;
    // this.address.coordinatePosition.lat = 0;
    // this.address.coordinatePosition.lon = 0;
    this.newHotel.name = this.createNewHotelForm.controls.name.value;
    this.newHotel.address = this.address;
    this.newHotel.phoneNumber = this.createNewHotelForm.controls.phoneNumber.value;
    this.newHotel.contactEmail = this.createNewHotelForm.controls.contactEmail.value;
    this.newHotel.description = this.createNewHotelForm.controls.description.value;
    this.newHotel.website = this.createNewHotelForm.controls.website.value;
    this.newHotel.numberOfFloors = this.createNewHotelForm.controls.numberOfFloors.value;
    this.newHotel.stars = this.createNewHotelForm.controls.stars.value;

    console.log(this.newHotel);

    this.hotelService.addHotel(this.newHotel)
      .subscribe(
        res => {
          console.log(res);
        }
      );

    this.createNewHotelForm.reset();
  }

  onCancel() {
    this.router.navigate(['../'], {relativeTo: this.route});
  }

}
