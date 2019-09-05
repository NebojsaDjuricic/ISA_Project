import {Component, Directive, Input, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, NgControl, Validators} from '@angular/forms';
import {Administrator} from '../../../../model/administrator';
import {AdminServiceService} from '../../../../services/admin-service.service';
import {AuthServiceService} from '../../../../services/auth-service.service';
import {ActivatedRoute, Router} from '@angular/router';
import { NgSelectModule, NgOption } from '@ng-select/ng-select';

@Component({
  selector: 'app-edit-admin',
  templateUrl: './edit-admin.component.html',
  styleUrls: ['./edit-admin.component.css']
})
export class EditAdminComponent implements OnInit {

  editAdminForm: FormGroup;
  admin: Administrator;
  editedAdmin: Administrator;
  adminUsername: String;
  admin_username: String;
  errorMessage = 'Invalid value!';
  isSysAdmin: boolean;
  isNotSysAdmin: boolean;
  admintip: any;

  constructor(private formBuilder: FormBuilder,
              private adminService: AdminServiceService,
              private auth: AuthServiceService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.getAdmin(this.route.snapshot.params['adminUsername']);
    this.editAdminForm = this.formBuilder.group(
      {
        username: new FormControl('', [Validators.required]),
        email: new FormControl('', [Validators.required, Validators.email]),
        password: new FormControl('', [Validators.required]),
        type: new FormControl('', [Validators.required]),
        // type: new FormControl({value: '', disabled: this.isNotSysAdmin}, Validators.required),
      }
    );

    this.editedAdmin = new Administrator();

    this.route.params.subscribe(
      params => {
        this.adminUsername = params['adminUsername'];
      }
    );

    this.admin = new Administrator();
    this.adminService.getAdmin(this.adminUsername)
      .subscribe(
        res => {
          this.admin = res;
          }
      );

    const userType = this.auth.getUser();
    let split = null;
    let userTIP = null;
    if (userType) {
      split = userType.split('.', 3);
      userTIP = split[1];
    }

    if (userTIP === 'SYSTEM_ADMIN') {
      this.isSysAdmin = true;
      this.isNotSysAdmin = false;
    } else {
      this.isSysAdmin = false;
      this.isNotSysAdmin = true;
    }

    console.log('sys:' + this.isSysAdmin);
    console.log('not sys:' + this.isNotSysAdmin);

  }

  getAdmin(username) {
    this.adminService.getAdmin(username)
      .subscribe(
        data => {
          this.admin_username = data.username;
          this.editAdminForm.patchValue(
            {
              username: data.username,
              email: data.email,
              password: data.password,
              type: data.type
            }
          );
        }
      );
  }

  onSubmit() {
    this.editedAdmin.username = this.adminUsername;
    this.editedAdmin.email = this.editAdminForm.controls.email.value;
    this.editedAdmin.password = this.editAdminForm.controls.password.value;
    this.editedAdmin.type = this.editAdminForm.controls.type.value;

    console.log(this.editedAdmin);

    this.adminService.editAdmin(this.editedAdmin)
      .subscribe(
        res => {
          console.log(res);
        }
      );

    this.router.navigate(['/']);
  }

  onCancel() {
    this.router.navigate(['/']);
  }


}

@Directive({
  selector : '[disableControl]'
})
export class DisableControlDirective {

  @Input() set disableControl(condition: boolean) {
    const action = condition ? 'disable' : 'enable';
    console.log(action, condition);
    setTimeout(() => this.ngControl.control[action](), 10);
  }

  constructor(private ngControl: NgControl) {
  }
}
