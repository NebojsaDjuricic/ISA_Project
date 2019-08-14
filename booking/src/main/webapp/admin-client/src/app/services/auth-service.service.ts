import { Injectable } from '@angular/core';
import {BehaviorSubject} from 'rxjs';
import {Administrator} from '../model/administrator';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {catchError} from 'rxjs/operators';

// added new
export interface AuthResponseData {
  kind: string;
  idToken: string;
  email: string;
  refreshToken: string;
  expiresIn: string;
  localId: string;
  registered?: boolean;
}

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  private user: any | null;

  // added new
  admin = new BehaviorSubject<Administrator>(null);
  private tokenExpirationTimer: any;

  // constructor() { }

  // added new
  constructor(private http: HttpClient,
              private router: Router) {

  }

  // added new
  // login(username: string, password: string) {
  //   return this.http.post<AuthResponseData>(
  //     'http://localhost:8080/admin/login',
  //     {
  //       username: username,
  //       password: password,
  //       returnSecureToken: true
  //     }
  //
  //   );
  // }

  public logoutUser() {
    this.user = null;
    localStorage.clear();

    // added new
    // this.admin.next(null);
    // this.router.navigate(['/login']);
    // localStorage.removeItem('username');
    // localStorage.clear();

    // if (this.tokenExpirationTimer) {
    //   clearTimeout(this.tokenExpirationTimer);
    // }
    //
    // this.tokenExpirationTimer = null;
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





  // ############## ADDED NEW ################
  // private handleAuthentication(email: string, userId: string, token: string, expiresIn: number) {
  //   const expirationDate = new Date(new Date().getTime() + expiresIn * 1000);
  //   const user = new Administrator(
  //
  //   );
  //   this.user.next(user);
  //   this.autoLogout(expiresIn * 1000);
  //   localStorage.setItem('userData', JSON.stringify(user));
  // }
  //
  // autoLogout(expirationDuration: number) {
  //   console.log(expirationDuration);
  //   this.tokenExpirationTimer = setTimeout(() => {
  //     this.logoutUser();
  //   }, expirationDuration);
  // }

  // ##############################

}
