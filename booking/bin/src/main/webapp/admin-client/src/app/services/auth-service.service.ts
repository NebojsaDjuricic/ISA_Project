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
    this.user = user;
    localStorage.setItem('user', user);
  }

  public getUser(): any | null {
    console.log('Auth getUser ' + this.user);
    return this.user;
  }

}
