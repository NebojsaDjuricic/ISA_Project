import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user';
import { UserDTO } from '../model/userDTO';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private backEndUrl = 'http://localhost:8080/user';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  registerUser(user) {

    this.http.post(this.backEndUrl + '/register', user).subscribe(data => {
      console.log(data);
    });

  }

  login(user: UserDTO) {
    return this.http.post(this.backEndUrl +  '/login', user);
  }

}
