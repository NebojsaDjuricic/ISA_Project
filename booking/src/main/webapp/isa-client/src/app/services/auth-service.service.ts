import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  private token: any | null;

  constructor() { }

  public logoutUser() {
    this.token = null;
    localStorage.clear();
  }

  public setToken(token: any) {
    this.token = token['token'];
    localStorage.setItem('token', this.token);
  }

  public getToken(): any | null {
    this.token = localStorage.getItem('token');
    return this.token;
  }

}
