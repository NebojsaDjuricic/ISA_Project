import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Administrator } from 'src/app/model/administrator';
import { AdminServiceService } from '../../../../services/admin-service.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-create-new-admin',
  templateUrl: './create-new-admin.component.html',
  styleUrls: ['./create-new-admin.component.css']
})
export class CreateNewAdminComponent implements OnInit {

  createAdminForm: FormGroup;
  newAdmin: Administrator;

  constructor(
    private formBuilder: FormBuilder,
    private adminService: AdminServiceService,
    private router: Router,
    private route: ActivatedRoute
    ) { }

  ngOnInit() {
    this.createAdminForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      passwordRepeat: ['', Validators.required],
      email: ['', Validators.required],
      role: ['', Validators.required],
      editingObjectID: ['', Validators.required]
    });

    this.newAdmin = new Administrator();
  }

  onSubmit() {
    // Validate

    this.newAdmin.username = this.createAdminForm.controls.username.value;
    this.newAdmin.password = this.createAdminForm.controls.password.value;
    this.newAdmin.email = this.createAdminForm.controls.email.value;
    const role = this.createAdminForm.controls.role.value;
    this.newAdmin.role = role;
    this.newAdmin.editingObjectID = this.createAdminForm.controls.editingObjectID.value;

    console.log('Samo role: ' + role);
    console.log('Role in object: ' + this.newAdmin.role);
    console.log(this.newAdmin);

    this.adminService.add(this.newAdmin).subscribe(
      res => {
        console.log(res);
      }
    );
  }

  onCancel() {
    this.router.navigate(['../'], {relativeTo: this.route});
  }
}
