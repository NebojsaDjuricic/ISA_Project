import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../../services/auth-service.service';
import {Router} from '@angular/router';
import {Subscription} from 'rxjs';
import {LoginService} from '../../services/login.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  userIsLoggedIn = false;
  whichUserType: any;
  admin_username: any;
  admin_hotel: any;

  // added
  private userSub: Subscription;

  constructor(
    private auth: AuthServiceService,
    private router: Router,
    private loginService: LoginService
    ) { }

  ngOnInit() {
    this.userIsLoggedIn = this.auth.getUser() != null;
    console.log('LoggedIn: ' + this.userIsLoggedIn);
    const userType = this.auth.getUser();
    let split = null;
    let userTIP = null;
    let adminUsername = null;
    let adminHotel = null;
    if (userType) {
      split = userType.split('.', 3);
      userTIP = split[1];
    }
    console.log('User type: ' + userTIP);

    if (userType) {
      split = userType.split('.', 3);
      adminUsername = split[0];
    }
    console.log('Admin username: ' + adminUsername);
    this.admin_username = adminUsername;

    if (userType) {
      split = userType.split('.', 3);
      adminHotel = split[2];
    }

    console.log('Admins hotel: ' + adminHotel);
    this.admin_hotel = adminHotel;

    if (userTIP === 'SYSTEM_ADMIN') {
      this.whichUserType = 'SYSTEM ADMIN';
    } else if (userTIP === 'HOTEL_ADMIN') {
      this.whichUserType = 'HOTEL ADMIN';
    } else if (userTIP === 'AIRLINE_ADMIN') {
      this.whichUserType = 'AIRLINE ADMIN';
    } else if (userTIP === 'RENT_A_CAR_SERVICE_ADMIN') {
      this.whichUserType = 'RENT A CAR ADMIN';
    } else {
      this.whichUserType = 'Home';
    }
    // this.userSub = this.loginService.userAdmin.subscribe(
    //   admin => {
    //     this.userIsLoggedIn = !admin;
    //     console.log('LoggedIn: ' + this.userIsLoggedIn);
    //   }
    // );
  }

  logout() {
    this.auth.logoutUser();
    this.router.navigate(['/login']);
    this.userIsLoggedIn = this.auth.getUser() != null;
    console.log('LoggedIn: ' + this.userIsLoggedIn);
  }
}
