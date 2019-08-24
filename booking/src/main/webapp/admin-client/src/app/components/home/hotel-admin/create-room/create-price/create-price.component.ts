import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-create-price',
  templateUrl: './create-price.component.html',
  styleUrls: ['./create-price.component.css']
})
export class CreatePriceComponent implements OnInit {
  createPriceForm: FormGroup;
  isViewable: boolean;

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.isViewable = true;
    this.createPriceForm = this.formBuilder.group(
      {
        price: new FormControl(null, [Validators.required, Validators.pattern(/^[1-9]\d*$/)]),
        startDate: new FormControl('', [Validators.required]),
        endDate: new FormControl('', [Validators.required]),
        naPopustu: new FormControl(null, [Validators.required]),
        popust: new FormControl(null, [Validators.required, Validators.pattern(/^[1-9]\d*$/)]),
      }
    );
  }

  onSubmit() {

  }

  onCancel() {
    this.isViewable = !this.isViewable;
  }
}
