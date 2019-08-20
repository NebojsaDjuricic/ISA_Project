import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Hotel} from '../model/hotel';
import {Room} from '../model/room';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  private backEndUrl = 'http://localhost:8080/hotels';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  getHotel(id: String): Observable<Hotel> {
    return this.http.get<Hotel>(this.backEndUrl + '/' + id);
  }

  addHotel(hotel: Hotel) {
    return this.http.post(this.backEndUrl + '/addHotel', hotel, this.httpOptions);
  }

  editHotel() {}

  getRooms(hotelID: String) {
    return this.http.get<Room[]>(this.backEndUrl + '/' + hotelID + '/rooms');
  }

  getAdminHotel(adminID: String) {
    return this.http.get<Hotel>(this.backEndUrl + '/' + adminID + '/hotels');
  }

  getHotels() {
    return this.http.get<Hotel[]>(this.backEndUrl);
  }

}
