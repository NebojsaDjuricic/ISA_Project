import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Hotel } from '../../model/hotel';
import { HotelService } from '../../services/hotel.service';

@Component({
  selector: 'app-show-all-hotels',
  templateUrl: './show-all-hotels.component.html',
  styleUrls: ['./show-all-hotels.component.css']
})
export class ShowAllHotelsComponent implements OnInit {

  hotels: Observable<Hotel[]>;

  constructor(private hotelService: HotelService) { }

  ngOnInit() {
    this.getAllHotels();
  }

  getAllHotels() {
    this.hotels = this.hotelService.getAll();
  }
}
