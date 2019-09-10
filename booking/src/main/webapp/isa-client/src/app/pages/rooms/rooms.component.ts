import { Component, OnInit } from '@angular/core';
import {Hotel} from '../../model/hotel';
import {Room} from '../../model/room';
import {Observable} from 'rxjs';
import {HotelService} from '../../services/hotel.service';
import {AuthServiceService} from '../../services/auth-service.service';
import {RoomService} from '../../services/room.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-rooms',
  templateUrl: './rooms.component.html',
  styleUrls: ['./rooms.component.css']
})
export class RoomsComponent implements OnInit {

  hotelID: String;
  hotel: Hotel;
  rooms: Room[] = [];
  room_id: String;
  room: Room;

  constructor(private hotelService: HotelService,
              private roomService: RoomService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.getRoom(this.route.snapshot.params['roomId']);

    this.route.params.subscribe(
      params => {
        this.hotelID = params['id'];
        this.room_id = params['roomId'];
        console.log(this.hotelID);
        console.log(this.room_id);
      }
    );

    this.room = new Room();
    this.roomService.getRoom(this.room_id)
      .subscribe(
        res => {
          this.room = res;
          // console.log('this.room ' + JSON.stringify(this.room));
        }
      );
  }

  getRoom(id) {
    this.roomService.getRoom(id).subscribe(data => {
      this.room_id = data.id;
      this.room = data;
    });
  }

  onBookRoom(id: String) {

  }
}
