import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Room} from '../model/room';
import {RoomDTO} from '../model/roomDTO';
import {Observable, Subject} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {Price} from '../model/price';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  private backEndUrl = 'http://localhost:8080/room';

  roomsChanged = new Subject<Room[]>();

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  addRoom(room: Room) {
    return this.http.post(this.backEndUrl + '/addRoom', room, this.httpOptions);
  }

  getRoom(id: String) {
    return this.http.get<Room>(this.backEndUrl + '/' + id);
  }

  editRoom(room: RoomDTO) {
    return this.http.post(this.backEndUrl + '/editRoom', room, this.httpOptions);
  }

  deleteRoom(id: String) {
    return this.http.delete(this.backEndUrl + '/delete/' + id, this.httpOptions);
  }

  // deleteRoom(room: Observable<Room>) {
  //   return this.http.delete<Room>(this.backEndUrl + '/' + room.id, this.httpOptions);
  // }

  // deleteRoom(room: Room) {
  //   return this.http.delete<Room>(this.backEndUrl + '/' + room.id, this.httpOptions);
  // }

  addPrice(price: Price) {
    return this.http.post(this.backEndUrl + '/prices/addPrice', price, this.httpOptions);
  }

  getPrice(id: String) {
    return this.http.get<Price>(this.backEndUrl + '/prices/' + id);
  }

  editPrice(price: Price) {
    return this.http.post(this.backEndUrl + '/prices/editPrice', price, this.httpOptions);
  }


}
