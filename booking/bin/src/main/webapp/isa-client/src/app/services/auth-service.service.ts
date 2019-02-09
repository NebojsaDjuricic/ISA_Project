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
    this.token = token;
    localStorage.setItem('token', token);
  }

  public getToken(): any | null {
    return this.token;
  }

}
