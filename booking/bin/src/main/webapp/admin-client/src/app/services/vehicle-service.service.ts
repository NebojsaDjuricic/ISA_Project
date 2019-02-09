import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Vehicle } from '../model/vehicle';

@Injectable({
  providedIn: 'root'
})
export class VehicleServiceService {

  private backEndUrl = 'http://localhost:8080/vehicle';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  addVehicle(vehicle: Vehicle) {
    return this.http.post(this.backEndUrl + '/add', vehicle, this.httpOptions);
  }
}
