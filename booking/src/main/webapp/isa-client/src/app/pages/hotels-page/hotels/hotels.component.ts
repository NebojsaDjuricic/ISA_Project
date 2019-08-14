import { Component, OnInit } from '@angular/core';
import { Hotel } from '../../../model/hotel';
import { HotelService } from '../../../services/hotel.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-hotels',
  templateUrl: './hotels.component.html',
  styleUrls: ['./hotels.component.css']
})
export class HotelsComponent implements OnInit {
  // hotels: Observable<Hotel[]>;
  hotel: Hotel;

  constructor(
    private hotelService: HotelService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.getInfo();
    // this.hotels = this.hotelService.getAll();
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
