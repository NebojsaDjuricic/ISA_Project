import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Administrator } from 'src/app/model/administrator';
import {BehaviorSubject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  userAdmin = new BehaviorSubject<Administrator>(null);
  backEndURL = 'http://localhost:8080/admin';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  // login(info: Administrator) {
  //   return this.http.post(this.backEndURL + '/login', info, this.httpOptions);
  // }

  login(username: String, password: String) {
    return this.http.post('http://localhost:8080/admin/login',
      {
        username: username,
        password: password
      }, this.httpOptions);
  }

  isUserLoggedIn() {
    const user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null);
  }

}
