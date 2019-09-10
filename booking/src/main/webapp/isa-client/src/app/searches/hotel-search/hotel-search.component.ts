import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {RoomSearchDTO} from '../../model/roomSearchDTO';
import {RoomService} from '../../services/room.service';
import {Room} from '../../model/room';
import {OrdinarySearchDTO} from '../../model/ordinarySearchDTO';
import {Hotel} from '../../model/hotel';
import {Vehicle} from '../../model/vehicle';

@Component({
  selector: 'app-hotel-search',
  templateUrl: './hotel-search.component.html',
  styleUrls: ['./hotel-search.component.css']
})
export class HotelSearchComponent implements OnInit {

  searchForm: FormGroup;
  roomSearch: RoomSearchDTO;
  ordinarySearch: OrdinarySearchDTO;
  data: Data;

  @Input() hotelID: String;

  searchResult: Room[];
  ordinarySearchResult: Hotel[];

  @Output() queryResultEvent = new EventEmitter<Object>();

  constructor(private formBuilder: FormBuilder,
              private roomService: RoomService) { }

  ngOnInit() {
    // this.searchForm = this.formBuilder.group({
    //   hotelName: ['', Validators.required],
    //   city: ['', Validators.required],
    //   country: ['', Validators.required],
    //   checkInDate: ['', Validators.required],
    //   checkOutDate: ['', Validators.required],
    //   guests: ['', Validators.required],
    //   rooms: ['', Validators.required],
    //   minPrice: [''],
    //   maxPrice: [''],
    //   type: ['', Validators.required],
    //   hotelID: [this.hotelID, Validators.required]
    // });
    //
    // this.roomSearch = new RoomSearchDTO();

    this.searchForm = this.formBuilder.group({
      hotelName: ['', Validators.required],
      city: ['', Validators.required],
      country: ['', Validators.required],
      checkInDate: ['', Validators.required],
      checkOutDate: ['', Validators.required],
      guests: ['', Validators.required],
      // hotelID: [this.hotelID, Validators.required]
    });

    this.ordinarySearch = new OrdinarySearchDTO();
    this.data = new Data();
  }

  onSubmit() {
    // this.roomSearch.hotelName = this.searchForm.controls.hotelName.value;
    // this.roomSearch.city = this.searchForm.controls.city.value;
    // this.roomSearch.country = this.searchForm.controls.country.value;
    // this.roomSearch.checkInDate = this.searchForm.controls.checkInDate.value;
    // this.roomSearch.checkOutDate = this.searchForm.controls.checkOutDate.value;
    // this.roomSearch.guests = this.searchForm.controls.guests.value;
    // this.roomSearch.rooms = this.searchForm.controls.rooms.value;
    // this.roomSearch.minPrice = this.searchForm.controls.minPrice.value;
    // this.roomSearch.maxPrice = this.searchForm.controls.maxPrice.value;
    // this.roomSearch.hotelID = this.searchForm.controls.hotelID.value;
    //
    // this.roomService.makeQuery(this.roomSearch).subscribe(
    //   res => {
    //     this.searchResult = res;
    //     this.queryResultEvent.emit(this.searchResult);
    //   }
    // );

    this.ordinarySearch.hotelName = this.searchForm.controls.hotelName.value;
    this.ordinarySearch.city = this.searchForm.controls.city.value;
    this.ordinarySearch.country = this.searchForm.controls.country.value;
    this.ordinarySearch.startDate = this.searchForm.controls.checkInDate.value;
    this.ordinarySearch.endDate = this.searchForm.controls.checkOutDate.value;
    this.ordinarySearch.numberOfPerson = this.searchForm.controls.guests.value;

    this.roomService.ordinarySearch(this.ordinarySearch).subscribe(
      res => {
        this.ordinarySearchResult = res;

        this.data.hotels = res;
        this.data.startDate = this.ordinarySearch.startDate;
        this.data.endDate = this.ordinarySearch.endDate;
        this.data.city = this.ordinarySearch.city;
        this.data.country = this.ordinarySearch.country;
        this.data.numberOfPerson = this.ordinarySearch.numberOfPerson;

        this.queryResultEvent.emit(this.ordinarySearchResult);
      }
    );
  }
}


export class Data {

  constructor() {
    this.hotels = [];
  }

  hotels: Hotel[];
  startDate: String;
  endDate: String;
  city: String;
  country: String;
  numberOfPerson: number;
}
