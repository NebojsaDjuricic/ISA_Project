import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  private user: any | null;

  constructor() { }

  public logoutUser() {
    this.user = null;
    localStorage.clear();
  }

  public setUser(user: any) {
    this.user = user['token'];
    localStorage.setItem('user', user['token']);
    const strParse = user['token'];
    const split = strParse.split('.', 3);
    const username = split[0];
    localStorage.setItem('username', username);
  }

  public getUser(): any | null {
    this.user = localStorage.getItem('user');
    return this.user;
  }

  public getAdminUsername(): any | null {
    return localStorage.getItem('username');
  }

}
