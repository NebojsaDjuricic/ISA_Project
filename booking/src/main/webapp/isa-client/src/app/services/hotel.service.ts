import {EventEmitter, Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Hotel } from '../model/hotel';
import {Observable, Subject} from 'rxjs';
import { Response } from '@angular/http';
import { map } from 'rxjs/operators';
import {Room} from '../model/room';

@Injectable({
  providedIn: 'root'
})

export class HotelService {
  private backEndUrl = 'http://localhost:8080/hotels';
  hotels: Observable<Hotel[]>;

  // added
  hotelChanged = new Subject<Observable<Hotel[]>>();

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<Hotel[]>(this.backEndUrl);
  }

  getHotel(id: String): Observable<Hotel> {
    return this.http.get<Hotel>(this.backEndUrl + '/' + id);
  }

  getRooms(hotelID: String) {
    return this.http.get<Room[]>(this.backEndUrl + '/' + hotelID + '/rooms');
  }
}
