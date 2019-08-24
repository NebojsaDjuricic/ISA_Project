import { Component, OnInit } from '@angular/core';
import {Hotel} from '../../../../model/hotel';
import {Room} from '../../../../model/room';
import {HotelService} from '../../../../services/hotel.service';
import {AdminServiceService} from '../../../../services/admin-service.service';
import {AuthServiceService} from '../../../../services/auth-service.service';
import {RoomService} from '../../../../services/room.service';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css']
})
export class RoomListComponent implements OnInit {

  hotelID: String;
  hotel: Hotel;
  rooms: Room[] = [];
  room_id: String;
  room: Observable<Room>;

  constructor(private hotelService: HotelService,
              private adminService: AdminServiceService,
              private auth: AuthServiceService,
              private roomService: RoomService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    const usertoken = this.auth.getUser();
    const splitted = usertoken.split('.', 3);
    this.hotelID = splitted[2];
    this.hotel = new Hotel();
    this.hotelService.getHotel(this.hotelID)
      .subscribe(
        res => {
          for (const room of res.rooms) {
            this.rooms.push(room);
          }
          this.hotel = res;
        }
      );

    this.route.params
      .subscribe(
        (params: Params) => {
          this.room_id = params.id;
          console.log(this.room_id);
          this.room = this.roomService.getRoom(this.room_id);
        }
      );
  }

  getRoom(id) {
    this.roomService.getRoom(id).subscribe(data => {
      this.room_id = data.id;
    });

    return this.room_id;
  }

  onDelete(room_id: String) {
    // const id = this.getRoom(this.route.snapshot.params['roomID']);
    // this.room_id = this.route.snapshot.params['roomID'];

    this.roomService.deleteRoom(room_id).subscribe();
    this.router.navigate(['/']);
  }
}
