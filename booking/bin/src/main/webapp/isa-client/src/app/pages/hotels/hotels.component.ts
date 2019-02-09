import { Component, OnInit } from '@angular/core';
import { Hotel } from '../../model/hotel';
import { HotelService } from '../../services/hotel.service';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-hotels',
  templateUrl: './hotels.component.html',
  styleUrls: ['./hotels.component.css']
})
export class HotelsComponent implements OnInit {

  hotel: Hotel;

  constructor(
    private hotelService: HotelService,
    private route: ActivatedRoute,
    private location: Location
  ) { }

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
