import { Component, OnInit } from '@angular/core';
import {Hotel} from '../../../model/hotel';
import {AuthServiceService} from '../../../services/auth-service.service';
import {HotelService} from '../../../services/hotel.service';

@Component({
  selector: 'app-hotel-admin',
  templateUrl: './hotel-admin.component.html',
  styleUrls: ['./hotel-admin.component.css']
})
export class HotelAdminComponent implements OnInit {

  hotelId: null;
  hotel: Hotel = null;

  constructor(
    private auth: AuthServiceService,
    private hotelService: HotelService
  ) { }

  ngOnInit() {
    const token = this.auth.getUser();
    const id = token.split('.', 3)[2];
    this.hotelId = id;

    this.hotelService.getHotel(id).subscribe(
      res => {
        this.hotel = res;
      }
    );
  }

}
