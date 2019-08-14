import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Room} from '../model/room';
import {RoomDTO} from '../model/roomDTO';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  private backEndUrl = 'http://localhost:8080/room';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  addRoom(room: Room) {
    return this.http.post(this.backEndUrl + '/add', room, this.httpOptions);
  }

  getRoom(id: String) {
    return this.http.get<Room>(this.backEndUrl + '/' + id);
  }

  editRoom(room: RoomDTO) {
    return this.http.post(this.backEndUrl + '/edit' + room, this.httpOptions);
  }

}
