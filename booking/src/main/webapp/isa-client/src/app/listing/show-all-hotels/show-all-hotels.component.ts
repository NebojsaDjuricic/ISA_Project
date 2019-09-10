import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Hotel } from '../../model/hotel';
import { HotelService } from '../../services/hotel.service';
import {OrdinarySearchResultDTO} from '../../model/ordinarySearchResultDTO';

@Component({
  selector: 'app-show-all-hotels',
  templateUrl: './show-all-hotels.component.html',
  styleUrls: ['./show-all-hotels.component.css']
})
export class ShowAllHotelsComponent implements OnInit {
  selectedHotel: Hotel;
  hotels: Observable<Hotel[]>;
  hotelSearchResult: OrdinarySearchResultDTO;
  searchedHotel: Hotel[];

  // constructor() { }
  constructor(private hotelService: HotelService) { }

  ngOnInit() {
    this.getAllHotels();

    // this.hotelService.hotelSelected
    //   .subscribe(
    //     (hotel: Hotel) => {
    //       this.selectedHotel = hotel;
    //     }
    //   );
  }

  getAllHotels() {
    this.hotels = this.hotelService.getAll();
  }

  fetchQueryResults($event) {
    this.hotelSearchResult = $event;
    this.searchedHotel = this.hotelSearchResult.queryResult;
  }
}
