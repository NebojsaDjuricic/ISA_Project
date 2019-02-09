import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../services/auth-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  private isUserLoggedIn: boolean;

  constructor(private auth: AuthServiceService) { 
    this.isUserLoggedIn = false;

    if ( this.auth.getToken() != null) {
      this.isUserLoggedIn = true;
    }
  }

  ngOnInit() {
    this.isUserLoggedIn = false;

    if ( this.auth.getToken() != null) {
      this.isUserLoggedIn = true;
    }

  }

}
