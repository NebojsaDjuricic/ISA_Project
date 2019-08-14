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
