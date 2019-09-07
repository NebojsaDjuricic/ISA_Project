import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { VehicleSearchDTO } from '../model/vehicleSearchDTO';
import { Observable } from 'rxjs';
import { Vehicle } from '../model/vehicle';
import { VehicleReservationDTO } from '../model/vehicleReservationDTO';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  private backEndUrl = 'http://localhost:8080/vehicle';
  vehicleSearchQueryResult: Observable<Vehicle[]>;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  makeQuery(query: VehicleSearchDTO ): Observable<Vehicle[]> {
    return this.http.post<Vehicle[]>(this.backEndUrl + '/search', query, this.httpOptions );
  }

  makeVehicleReservation(details: VehicleReservationDTO) {
    return this.http.post(this.backEndUrl + '/makeVehicleReservation', details, this.httpOptions)
  }
}
