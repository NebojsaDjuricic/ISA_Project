import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RentACar } from '../model/rent-a-car';
import { Observable } from 'rxjs';
import { Response } from '@angular/http';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class RentACarService {

  private backEndUrl = 'http://localhost:8080/rent-a-car';

  data: Observable<RentACar[]>;
  returnedRentACar: Observable<RentACar>;

  constructor(private http: HttpClient) { }

  getAll() {
    this.data = this.http.get<RentACar[]>(this.backEndUrl + '/get-all');

    return this.data;
  }

  getRentACar(id: String): Observable<RentACar> {
    return this.http.get<RentACar>(this.backEndUrl + '/get/' + id);
  }
}
