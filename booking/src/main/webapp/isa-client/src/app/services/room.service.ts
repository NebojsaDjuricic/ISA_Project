import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {RoomSearchDTO} from '../model/roomSearchDTO';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  private backEndUrl = 'http://localhost:8080/room';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  makeQuery(query: RoomSearchDTO) {
    return this.http.post(this.backEndUrl + '/search', query, this.httpOptions);
  }
}
