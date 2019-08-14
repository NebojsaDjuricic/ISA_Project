import {EventEmitter, Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Hotel } from '../model/hotel';
import {Observable, Subject} from 'rxjs';
import { Response } from '@angular/http';
import { map } from 'rxjs/operators';

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
    this.hotels = this.http.get<Hotel[]>(this.backEndUrl);

    return this.hotels;
  }

  getHotel(id: String): Observable<Hotel> {
    return this.http.get<Hotel>(this.backEndUrl + '/' + id);
  }
}
