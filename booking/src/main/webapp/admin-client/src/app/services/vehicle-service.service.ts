import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Vehicle } from '../model/vehicle';
import { VehicleDTO } from '../model/vehicleDTO';

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

  getVehicle(id: String) {
    return this.http.get<Vehicle>(this.backEndUrl + '/get/' + id);
  }

  editVehicle(vehicle: VehicleDTO) {
    return this.http.post(this.backEndUrl + '/save', vehicle, this.httpOptions);
  }
}









