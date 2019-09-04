import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Price} from '../../../../../model/price';
import {RoomService} from '../../../../../services/room.service';

@Component({
  selector: 'app-create-price',
  templateUrl: './create-price.component.html',
  styleUrls: ['./create-price.component.css']
})
export class CreatePriceComponent implements OnInit {
  createPriceForm: FormGroup;
  isViewable: boolean;
  price: Price;
  errorMessage = 'This field is required!';

  constructor(private formBuilder: FormBuilder,
              private roomService: RoomService,
              private router: Router,
              private route: ActivatedRoute) { }

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

    this.price = new Price();
  }

  onSubmit() {
    this.price.price = this.createPriceForm.controls.price.value;
    this.price.startDate = this.createPriceForm.controls.startDate.value;
    this.price.endDate = this.createPriceForm.controls.endDate.value;
    this.price.naPopustu = this.createPriceForm.controls.naPopustu.value;
    this.price.popust = this.createPriceForm.controls.popust.value;

    this.roomService.addPrice(this.price)
      .subscribe(
        res => {
          console.log(res);
        }
      );

    this.router.navigate(['../'], {relativeTo: this.route});
  }

  onCancel() {
    this.router.navigate(['../'], {relativeTo: this.route});
  }
}
