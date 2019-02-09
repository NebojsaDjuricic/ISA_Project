import { Component, OnInit } from '@angular/core';
import {FormGroup} from '@angular/forms';
import {Hotel} from '../../../../model/hotel';
import {Address} from '../../../../model/address';

@Component({
  selector: 'app-create-new-hotel',
  templateUrl: './create-new-hotel.component.html',
  styleUrls: ['./create-new-hotel.component.css']
})
export class CreateNewHotelComponent implements OnInit {

  createNewHotel: FormGroup;
  newHotel: Hotel;
  address: Address;

  constructor() { }

  ngOnInit() {
  }

}
