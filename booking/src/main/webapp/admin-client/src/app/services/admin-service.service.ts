import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Administrator } from 'src/app/model/administrator';

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {

  backEndURL = 'http://localhost:8080/admin';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  add(admin: Administrator) {
    return this.http.post(this.backEndURL + '/add', admin, this.httpOptions );
  }

  getAdmin(id: String) {
    return this.http.post<Administrator>(this.backEndURL + '/get/' + id, this.httpOptions);
  }

}
