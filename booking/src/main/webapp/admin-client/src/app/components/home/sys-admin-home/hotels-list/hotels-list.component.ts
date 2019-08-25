import { Component, OnInit } from '@angular/core';
import {Hotel} from '../../../../model/hotel';
import {HotelService} from '../../../../services/hotel.service';
import {AdminServiceService} from '../../../../services/admin-service.service';
import {AuthServiceService} from '../../../../services/auth-service.service';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-hotels-list',
  templateUrl: './hotels-list.component.html',
  styleUrls: ['./hotels-list.component.css']
})
export class HotelsListComponent implements OnInit {

  hotelID: String;
  hotel: Observable<Hotel>;
  hotels: Hotel[] = [];

  constructor(private hotelService: HotelService,
              private adminService: AdminServiceService,
              private auth: AuthServiceService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    // const usertoken = this.auth.getUser();
    // const splitted = usertoken.split('.', 3);
    // this.hotelID = splitted[2];
    // this.hotelService.getHotel(this.hotelID)
    //   .subscribe(
    //     res => {
    //       this.hotel = res;
    //     }
    //   );

    this.hotelService.getHotels()
      .subscribe(
        res => {
          this.hotels = res;
          console.log(this.hotels);
        }
      );

    // this.route.params
    //   .subscribe(
    //     (params: Params) => {
    //       this.hotelID = params.id;
    //       console.log('Hotel id:' + this.hotelID);
    //       this.hotel = this.hotelService.getHotel(this.hotelID);
    //       console.log('Hotel:' + this.hotel);
    //     }
    //   );


  }

}
