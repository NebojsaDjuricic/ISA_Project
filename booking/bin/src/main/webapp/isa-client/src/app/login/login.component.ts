import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserDTO } from '../model/userDTO';
import { UserService } from '../services/user.service';
import { AuthServiceService } from '../services/auth-service.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  submitted = false;
  success = false;

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private auth: AuthServiceService,
    private router: Router
  ) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  onSubmit() {
    console.log('Login press');

    const user = new UserDTO();
    user.email = this.loginForm.controls.email.value;
    user.password = this.loginForm.controls.password.value;

    console.log('User: ' + user.email);

    this.userService.login(user).subscribe(
      res => {
        if ( res['token'] == null ) {
          console.log('Login failed');
        } else {
          this.auth.setToken(res);
          this.router.navigate(['/']);
        }
      }
    );
  }

}
