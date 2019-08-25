import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Hotel} from '../../../../model/hotel';
import {HotelService} from '../../../../services/hotel.service';
import {AuthServiceService} from '../../../../services/auth-service.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Address} from '../../../../model/address';

@Component({
  selector: 'app-edit-hotel',
  templateUrl: './edit-hotel.component.html',
  styleUrls: ['./edit-hotel.component.css']
})
export class EditHotelComponent implements OnInit {

  editHotelForm: FormGroup;
  hotel: Hotel;
  editedHotel: Hotel;
  hotelID: String;
  hotel_id: String;
  address: Address;
  editedAddress: Address;
  errorMessage = 'Invalid value!';

  constructor(private formBuilder: FormBuilder,
              private hotelService: HotelService,
              private auth: AuthServiceService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.getHotel(this.route.snapshot.params['hotelID']);
    this.editHotelForm = this.formBuilder.group(
      {
        name: new FormControl('', [Validators.required]),
        streetName: new FormControl('', [Validators.required]),
        buildingNumber: new FormControl('', [Validators.required]),
        city: new FormControl('', [Validators.required]),
        country: new FormControl('', [Validators.required]),
        // lat: [''],
        // lon: [''],
        phoneNumber: new FormControl('', [Validators.required]),
        contactEmail: new FormControl('', [Validators.required]),
        description: new FormControl('', [Validators.required]),
        website: new FormControl('', [Validators.required]),
        rating: new FormControl(0.0, [Validators.required]),
        numberOfFloors: new FormControl(null, [Validators.required, Validators.pattern(/^[1-9]\d*$/)]),
        stars: new FormControl(null, [Validators.required, Validators.pattern(/^[1-9]\d*$/)]),
        rooms: [],
        additionalServices: []
      }
    );

    this.editedHotel = new Hotel();
    this.editedAddress = new Address();

    this.route.params.subscribe(
      params => {
        this.hotelID = params['hotelID'];
      }
    );

    this.hotel = new Hotel();
    this.hotelService.getHotel(this.hotelID)
      .subscribe(
        res => {
          this.hotel = res;
          // console.log('Hotel: ' + JSON.stringify(this.hotel));
        }
      );
  }

  getHotel(id) {
    this.hotelService.getHotel(id).subscribe(data => {
      this.hotel_id = data.id;
      this.editHotelForm.setValue({
        name: data.name,
        streetName: data.address.streetName,
        buildingNumber: data.address.buildingNumber,
        city: data.address.city,
        country: data.address.country,
        phoneNumber: data.phoneNumber,
        contactEmail: data.contactEmail,
        description: data.description,
        website: data.website,
        numberOfFloors: data.numberOfFloors,
        stars: data.stars,
        rating: data.rating,
        rooms: data.rooms,
        additionalServices: data.additionalServices
      });
    });
  }

  onSubmit() {
    this.editedHotel.id = this.hotelID;
    this.editedHotel.name = this.editHotelForm.controls.name.value;
    this.editedAddress.streetName = this.editHotelForm.controls.streetName.value;
    console.log('fking ulica:' + this.editedHotel.address.streetName);
    this.editedAddress.buildingNumber = this.editHotelForm.controls.buildingNumber.value;
    this.editedAddress.city = this.editHotelForm.controls.city.value;
    this.editedAddress.country = this.editHotelForm.controls.country.value;
    this.editedHotel.address = this.editedAddress;
    this.editedHotel.phoneNumber = this.editHotelForm.controls.phoneNumber.value;
    this.editedHotel.contactEmail = this.editHotelForm.controls.contactEmail.value;
    this.editedHotel.description = this.editHotelForm.controls.description.value;
    this.editedHotel.website = this.editHotelForm.controls.website.value;
    this.editedHotel.numberOfFloors = this.editHotelForm.controls.numberOfFloors.value;
    this.editedHotel.stars = this.editHotelForm.controls.stars.value;

    console.log(this.editedHotel);

    this.hotelService.editHotel(this.editedHotel)
      .subscribe(
        res => {
          console.log(res);
        }
      );

    this.router.navigate(['/']);
  }

  onCancel() {
    this.router.navigate(['/']);
  }
}
