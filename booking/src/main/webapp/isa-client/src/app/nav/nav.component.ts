import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../services/auth-service.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  private userIsLoggedIn: boolean;

  constructor(private auth: AuthServiceService) { }

  ngOnInit() {
    this.userIsLoggedIn = false;

    if (this.auth.getToken() != null) {
       this.userIsLoggedIn = true;
    }
  }

  logout() {
    this.auth.logoutUser();
    window.location.reload();
  }

  // isLoggedIn() {
  //
  // }
}
