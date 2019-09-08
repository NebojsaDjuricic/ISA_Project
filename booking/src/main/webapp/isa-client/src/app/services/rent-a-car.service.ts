import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RentACar } from '../model/rent-a-car';
import { Observable } from 'rxjs';
import { Response } from '@angular/http';
import { map } from 'rxjs/operators';
import { RentACarSearchResultDTO } from '../model/rent-a-carSearchResultDTO';
import { RentACarSearchDTO } from '../model/rent-a-carSearchDTO';


@Injectable({
  providedIn: 'root'
})
export class RentACarService {

  private backEndUrl = 'http://localhost:8080/rent-a-car';
  
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

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

  search(queryInput: RentACarSearchDTO): Observable<RentACarSearchResultDTO> {
    console.log("Service input: " + queryInput.name);

    var myQuery = queryInput.name;
    
    return this.http.post<RentACarSearchResultDTO>(this.backEndUrl + '/search', myQuery, this.httpOptions);
  }
}
