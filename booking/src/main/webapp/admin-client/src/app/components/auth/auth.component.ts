import {Component, ComponentFactoryResolver, OnInit, ViewChild} from '@angular/core';
import {NgForm} from '@angular/forms';
import {PlaceholderDirective} from './placeholder.directive';
import {Observable, Subscription} from 'rxjs';
import {AuthResponseData, AuthServiceService} from '../../services/auth-service.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {

  error: string = null;
  @ViewChild(PlaceholderDirective, { static: false }) alertHost: PlaceholderDirective;
  private closeSub: Subscription;

  constructor(private authService: AuthServiceService,
              private router: Router) {}


  ngOnInit() {
  }

  // onSubmit(form: NgForm) {
  //   if (!form.valid) {
  //     return;
  //   }
  //   const username = form.value.username;
  //   const password = form.value.password;
  //
  //   let authObs: Observable<AuthResponseData>;
  //
  //   authObs = this.authService.login(username, password);
  //
  //   authObs.subscribe(resData => {
  //       console.log(resData);
  //       this.router.navigate(['/']);
  //     }, errorMessage => {
  //       console.log(errorMessage);
  //       this.error = errorMessage;
  //     }
  //   );
  //
  //   form.reset();
  // }
}
