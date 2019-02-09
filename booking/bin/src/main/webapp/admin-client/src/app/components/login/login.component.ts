import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginService } from '../../services/login.service';
import { Administrator } from 'src/app/model/administrator';
import { AuthServiceService } from '../../services/auth-service.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  admin: Administrator;

  constructor(
    private formBuilder: FormBuilder,
    private loginService: LoginService,
    private auth: AuthServiceService,
    private router: Router
  ) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });

    this.admin = new Administrator();
  }

  login() {
    this.admin.username = this.loginForm.controls.username.value;
    this.admin.password = this.loginForm.controls.password.value;

    this.loginService.login(
      this.admin
    )
    .subscribe( res => {
      if ( res['token'] == null ) {
        console.log('RetVal is null');
      } else {
        console.log('Nije null');
        console.log(res);
        this.auth.setUser(res);
        this.router.navigate(['/']);
      }
    });
  }

}
