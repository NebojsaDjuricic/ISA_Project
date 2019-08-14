import { Component, OnInit } from '@angular/core';
import {Hotel} from '../../../model/hotel';
import {HotelService} from '../../../services/hotel.service';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-hotel-detail',
  templateUrl: './hotel-detail.component.html',
  styleUrls: ['./hotel-detail.component.css']
})
export class HotelDetailComponent implements OnInit {
  // hotel: Observable<Hotel>;
  hotel: Observable<Hotel>;
  id: string;

  constructor(private hotelService: HotelService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.getInfo();
  }

  getInfo() {
    // const id = this.route.snapshot.paramMap.get('id');
    // this.hotelService.getHotel(id).subscribe(
    //   retVal => {
    //     this.hotel = retVal;
    //   }
    // );

    this.route.params
      .subscribe(
        (params: Params) => {
          this.id = params.id;
          this.hotel = this.hotelService.getHotel(this.id);
        }
      );
  }

}
