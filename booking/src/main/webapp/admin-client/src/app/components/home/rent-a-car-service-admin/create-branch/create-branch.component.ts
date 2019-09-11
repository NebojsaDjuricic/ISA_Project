import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Branch } from '../../../../model/branch';
import { Address } from '../../../../model/address';
import { RentACarServiceServiceService } from '../../../../services/rent-a-car-service-service.service';
import { AuthServiceService } from '../../../../services/auth-service.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create-branch',
  templateUrl: './create-branch.component.html',
  styleUrls: ['./create-branch.component.css']
})
export class CreateBranchComponent implements OnInit {

  createBranchForm: FormGroup;
  branch: Branch;
  address: Address;
  submitter = false;

  constructor(
    private formBuilder: FormBuilder,
    private rentACarService: RentACarServiceServiceService,
    private auth: AuthServiceService,
    private router: Router
  ) { }

  ngOnInit() {
    this.createBranchForm = this.formBuilder.group({
      name: ['', Validators.required],
      streetName: ['', Validators.required],
      buildingNumber: ['', Validators.required],
      city: ['', Validators.required],
      country: ['', Validators.required],
      phoneNumber: ['', Validators.required],
      contactEmail: ['', Validators.required],
    });

    this.branch = new Branch();
    this.address = new Address();
  }

  onSubmit() {
    // Validate

    // Create address
    this.address.streetName = this.createBranchForm.controls.streetName.value;
    this.address.buildingNumber = this.createBranchForm.controls.buildingNumber.value;
    this.address.city = this.createBranchForm.controls.city.value;
    this.address.country = this.createBranchForm.controls.country.value;
    // Fill branch properties
    this.branch.name = this.createBranchForm.controls.name.value;
    this.branch.address = this.address;
    this.branch.contactEmail = this.createBranchForm.controls.contactEmail.value;
    this.branch.phoneNumber = this.createBranchForm.controls.phoneNumber.value;
    this.branch.admin = this.auth.getAdminUsername();
    // Hit backend

    this.rentACarService.addBranch(this.branch).subscribe(
      res => {
        console.log(res);
        this.router.navigate(['/']);
      }
    );
  }

}
