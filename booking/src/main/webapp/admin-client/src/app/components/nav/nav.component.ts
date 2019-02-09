import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../../services/auth-service.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  userIsLoggedIn: boolean;

  constructor(
    private auth: AuthServiceService,
    private router: Router
    ) { }

  ngOnInit() {
    this.userIsLoggedIn = this.auth.getUser() != null;
  }

  logout() {
    console.log('logout');
    this.auth.logoutUser();
    this.router.navigate(['/']);
  }
}
