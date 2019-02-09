import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RentACar } from '../model/rent-a-car';
import { Branch } from '../model/branch';
import { Observable } from 'rxjs';
import { Response } from '@angular/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RentACarServiceServiceService {

  private backEndUrl = 'http://localhost:8080/rent-a-car';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  getRentACar(id: String): Observable<RentACar> {
    return this.http.get<RentACar>(this.backEndUrl + '/get/' + id);
  }

  addRentACar(rent_a_car: RentACar) {
    return this.http.post(this.backEndUrl + '/add', rent_a_car, this.httpOptions);
  }

  addBranch(branch: Branch) {
    return this.http.post(this.backEndUrl + '/add-branch', branch, this.httpOptions);
  }
}
