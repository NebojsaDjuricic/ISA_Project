import { Component, OnInit } from '@angular/core';
import {Hotel} from '../../../model/hotel';
import {HotelService} from '../../../services/hotel.service';
import {ActivatedRoute, Params, Router} from '@angular/router';

@Component({
  selector: 'app-hotel-detail',
  templateUrl: './hotel-detail.component.html',
  styleUrls: ['./hotel-detail.component.css']
})
export class HotelDetailComponent implements OnInit {
  hotel: Hotel;
  id: string;

  constructor(private hotelService: HotelService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.getInfo();
  }

  getInfo() {
    const id = this.route.snapshot.paramMap.get('id');
    this.hotelService.getHotel(id).subscribe(
      retVal => {
        this.hotel = retVal;
      }
    );
  }

}
