import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {RoomSearchDTO} from '../model/roomSearchDTO';
import {Room} from '../model/room';
import {Observable} from 'rxjs';
import {OrdinarySearchDTO} from '../model/ordinarySearchDTO';
import {Hotel} from '../model/hotel';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  private backEndUrl = 'http://localhost:8080/room';
  private backendHotelURL = 'http://localhost:8080/hotels';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  makeQuery(query: RoomSearchDTO): Observable<Room[]> {
    return this.http.post<Room[]>( this.backEndUrl + '/search', query, this.httpOptions);
  }

  getRoom(id: String) {
    return this.http.get<Room>(this.backEndUrl + '/' + id);
  }

  ordinarySearch(search: OrdinarySearchDTO): Observable<Hotel[]> {
    return  this.http.post<Hotel[]>(this.backendHotelURL + '/ordinarySearch', search, this.httpOptions);
  }
}
