import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../../services/auth-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  noLoggedAdmin: boolean;
  sysAdminIsLogged: boolean;
  airlineAdminIsLogged: boolean;
  hotelAdminIsLogged: boolean;
  carAdminIsLogged: boolean;

  constructor(private auth: AuthServiceService) {
    this.noLoggedAdmin = true;
    this.sysAdminIsLogged = false;
    this.airlineAdminIsLogged = false;
    this.hotelAdminIsLogged = false;
    this.carAdminIsLogged = false;
  }

  ngOnInit() {
    const user = this.auth.getUser();


    let type;
    if (user == null) {

    } else {
      console.log(user['token']);
      const temp = user['token'];
      const splitted = temp.split('.', 3);
      type = splitted[1];
      if ( type === 'SYSTEM_ADMIN') {
        this.noLoggedAdmin = false;
        this.sysAdminIsLogged = true;
        this.airlineAdminIsLogged = false;
        this.hotelAdminIsLogged = false;
        this.carAdminIsLogged = false;
      } else if ( type === 'AIRLINE_ADMIN') {
        this.noLoggedAdmin = false;
        this.sysAdminIsLogged = false;
        this.airlineAdminIsLogged = true;
        this.hotelAdminIsLogged = false;
        this.carAdminIsLogged = false;
      } else if ( type === 'HOTEL_ADMIN') {
        this.noLoggedAdmin = false;
        this.sysAdminIsLogged = false;
        this.airlineAdminIsLogged = false;
        this.hotelAdminIsLogged = true;
        this.carAdminIsLogged = false;
      } else if ( type === 'RENT_A_CAR_SERVICE_ADMIN') {
        this.noLoggedAdmin = false;
        this.sysAdminIsLogged = false;
        this.airlineAdminIsLogged = false;
        this.hotelAdminIsLogged = false;
        this.carAdminIsLogged = true;
      }
    }
  }

}
