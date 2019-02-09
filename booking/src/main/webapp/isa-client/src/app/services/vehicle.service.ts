import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { VehicleSearchDTO } from '../model/vehicleSearchDTO';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  private backEndUrl = 'http://localhost:8080/vehicle';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  makeQuery(query: VehicleSearchDTO ) {
    return this.http.post(this.backEndUrl + '/search', query, this.httpOptions );
  }
}
