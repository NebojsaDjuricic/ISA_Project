import { Component, OnInit } from '@angular/core';
import {Hotel} from '../../../../model/hotel';
import {Room} from '../../../../model/room';
import {HotelService} from '../../../../services/hotel.service';
import {AdminServiceService} from '../../../../services/admin-service.service';
import {AuthServiceService} from '../../../../services/auth-service.service';

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css']
})
export class RoomListComponent implements OnInit {

  hotelID: String;
  hotel: Hotel;
  rooms: Room[] = [];

  constructor(private hotelService: HotelService,
              private adminService: AdminServiceService,
              private auth: AuthServiceService) { }

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
  }

}
