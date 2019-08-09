import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Hotel} from '../model/hotel';

@Injectable({
  providedIn: 'root'
})
export class HotelServiceService {

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
}
