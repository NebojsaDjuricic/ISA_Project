import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {RoomDTO} from '../../../../model/roomDTO';
import {Hotel} from '../../../../model/hotel';
import {RoomService} from '../../../../services/room.service';
import {HotelService} from '../../../../services/hotel.service';
import {AuthServiceService} from '../../../../services/auth-service.service';

@Component({
  selector: 'app-create-room',
  templateUrl: './create-room.component.html',
  styleUrls: ['./create-room.component.css']
})
export class CreateRoomComponent implements OnInit {

  createRoomForm: FormGroup;
  room: RoomDTO;
  hotels: Hotel[] = [];
  submitted = false;

  constructor(private formBuilder: FormBuilder,
              private roomService: RoomService,
              private hotelService: HotelService,
              private auth: AuthServiceService
              ) { }

  ngOnInit() {
    this.createRoomForm = this.formBuilder.group(
      {
        roomType: [RoomType.Value.DOUBLE, Validators.required],
        roomStatus: [RoomStatus.Value.AVAILABLE, Validators.required],
        capacity: ['', Validators.required],
        floor: ['', Validators.required],

        // Price[] dodati

      }
    );
    this.room = new RoomDTO();
  }

  onSubmit() {

  }
}

module RoomStatus {
  export enum Value {
    AVAILABLE,
    RESERVED,
    OCCUPIED
  }
}

module RoomType {
  export enum Value {
    SINGLE,
    DOUBLE,
    TRIPLE,
    QUAD
  }
}
