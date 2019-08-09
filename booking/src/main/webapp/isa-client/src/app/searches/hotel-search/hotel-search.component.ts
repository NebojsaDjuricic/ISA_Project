import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {RoomSearchDTO} from '../../model/roomSearchDTO';
import {RoomService} from '../../services/room.service';

@Component({
  selector: 'app-hotel-search',
  templateUrl: './hotel-search.component.html',
  styleUrls: ['./hotel-search.component.css']
})
export class HotelSearchComponent implements OnInit {

  searchForm: FormGroup;
  roomSearch: RoomSearchDTO;

  constructor(private formBuilder: FormBuilder, private roomService: RoomService) { }

  ngOnInit() {
    this.searchForm = this.formBuilder.group({
      hotelName: ['', Validators.required],
      city: ['', Validators.required],
      country: ['', Validators.required],
      checkInDate: ['', Validators.required],
      checkOutDate: ['', Validators.required],
      guests: ['', Validators.required],
      rooms: ['', Validators.required]
    });

    this.roomSearch = new RoomSearchDTO();
  }

  onSubmit() {
    this.roomSearch.hotelName = this.searchForm.controls.hotelName.value;
    this.roomSearch.city = this.searchForm.controls.City.value;
    this.roomSearch.country = this.searchForm.controls.Country.value;
    this.roomSearch.checkInDate = this.searchForm.controls.checkInDate.value;
    this.roomSearch.checkOutDate = this.searchForm.controls.checkOutDate.value;
    this.roomSearch.guests = this.searchForm.controls.guests.value;
    this.roomSearch.rooms = this.searchForm.controls.rooms.value;

    this.roomService.makeQuery(this.roomSearch).subscribe(
      res => {
        console.log(res);
      }
    );
  }
}
